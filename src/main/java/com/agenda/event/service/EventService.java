package com.agenda.event.service;

import com.agenda.event.dto.CreateEventCommand;
import com.agenda.event.model.Event;
import com.agenda.event.model.EventRepeatType;
import com.agenda.event.model.EventStatus;
import com.agenda.event.repository.EventRepository;
import jdk.jfr.EventType;

import java.time.LocalDateTime;

public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public int createEvent(CreateEventCommand newEvent) {
        if (newEvent == null) {
            throw new IllegalArgumentException("CreateEventCommand cannot be null.");
        }

        if (newEvent.endDate() != null && newEvent.endDate().isBefore(newEvent.startDate())) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }

        if(newEvent.eventCustomRepeatDays() < 0 || (newEvent.repeatType() == EventRepeatType.CUSTOM && newEvent.eventCustomRepeatDays() == 0)) {
            throw new IllegalArgumentException("Invalid custom repeat days.");
        }

        Event event = new Event(
                0,
                newEvent.name(),
                newEvent.description(),
                newEvent.startDate(),
                newEvent.endDate(),
                newEvent.location(),
                newEvent.repeatType(),
                newEvent.eventCustomRepeatDays(),
                newEvent.eventNotificationMinutes() == null ? 30 : newEvent.eventNotificationMinutes(),
                EventStatus.PLANNED,
                LocalDateTime.now()
        );

        return eventRepository.saveEvent(event);
    }
}
