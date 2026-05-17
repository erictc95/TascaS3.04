package com.agenda.event.service;

import com.agenda.common.exception.EventValidationException;
import com.agenda.event.dto.CreateEventCommand;
import com.agenda.event.model.Event;
import com.agenda.event.model.EventRepeatType;
import com.agenda.event.model.EventStatus;
import com.agenda.event.repository.EventInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventServiceTest {

    private EventService eventService;
    private EventInMemoryRepository eventRepository;

    @BeforeEach
    void setUp() {
        eventRepository = new EventInMemoryRepository();
        eventService = new EventService(eventRepository);
    }

    @Test
    void shouldCreateEventAndReturnGeneratedId() {
        CreateEventCommand command = new CreateEventCommand(
                "Sprint planning",
                "Plan the next sprint",
                LocalDateTime.of(2026, 5, 18, 9, 0),
                LocalDateTime.of(2026, 5, 18, 10, 0),
                "Agile Room",
                EventRepeatType.NONE,
                0,
                45
        );

        int createdId = eventService.createEvent(command);
        Event savedEvent = eventRepository.findAll().getFirst();

        assertThat(createdId).isEqualTo(1);
        assertThat(eventRepository.findAll()).hasSize(1);
        assertThat(savedEvent.getName()).isEqualTo("Sprint planning");
        assertThat(savedEvent.getDescription()).isEqualTo("Plan the next sprint");
        assertThat(savedEvent.getStartDate()).isEqualTo(LocalDateTime.of(2026, 5, 18, 9, 0));
        assertThat(savedEvent.getEndDate()).isEqualTo(LocalDateTime.of(2026, 5, 18, 10, 0));
        assertThat(savedEvent.getLocation()).isEqualTo("Agile Room");
        assertThat(savedEvent.getRepeatType()).isEqualTo(EventRepeatType.NONE);
        assertThat(savedEvent.getEventCustomRepeat()).isZero();
        assertThat(savedEvent.getEventNotificationMinutes()).isEqualTo(45);
        assertThat(savedEvent.getStatus()).isEqualTo(EventStatus.PLANNED);
        assertThat(savedEvent.getEventCreatedAt()).isNotNull();
    }

    @Test
    void shouldApplyDefaultNotificationMinutesWhenValueIsNull() {
        CreateEventCommand command = new CreateEventCommand(
                "Medical checkup",
                "Annual follow-up",
                LocalDateTime.of(2026, 5, 20, 17, 0),
                null,
                "North Medical Center",
                EventRepeatType.YEARLY,
                0,
                null
        );

        eventService.createEvent(command);
        Event savedEvent = eventRepository.findAll().getFirst();

        assertThat(eventRepository.findAll()).hasSize(1);
        assertThat(savedEvent.getEventNotificationMinutes()).isEqualTo(30);
    }

    @Test
    void shouldThrowWhenCommandIsNull() {
        assertThatThrownBy(() -> eventService.createEvent(null))
                .isInstanceOf(EventValidationException.class)
                .hasMessage("CreateEventCommand cannot be null.");
    }

    @Test
    void shouldThrowWhenEndDateIsBeforeStartDate() {
        CreateEventCommand command = new CreateEventCommand(
                "English class",
                "Speaking practice",
                LocalDateTime.of(2026, 5, 21, 19, 0),
                LocalDateTime.of(2026, 5, 21, 18, 0),
                "Central Academy",
                EventRepeatType.NONE,
                0,
                20
        );

        assertThatThrownBy(() -> eventService.createEvent(command))
                .isInstanceOf(EventValidationException.class)
                .hasMessage("End date cannot be before start date.");
    }

    @Test
    void shouldThrowWhenCustomRepeatDaysAreInvalid() {
        CreateEventCommand command = new CreateEventCommand(
                "English class",
                "Speaking practice",
                LocalDateTime.of(2026, 5, 21, 19, 0),
                null,
                "Central Academy",
                EventRepeatType.CUSTOM,
                0,
                20
        );

        assertThatThrownBy(() -> eventService.createEvent(command))
                .isInstanceOf(EventValidationException.class)
                .hasMessage("Invalid custom repeat days.");
    }
}
