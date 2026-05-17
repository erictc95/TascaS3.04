package com.agenda.event.dto;

import com.agenda.event.model.EventRepeatType;

import java.time.LocalDateTime;

public record CreateEventCommand(
        String name,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String location,
        EventRepeatType repeatType,
        int eventCustomRepeatDays,
        Integer eventNotificationMinutes
) {
}
