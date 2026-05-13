package com.agenda.event.model;

import java.time.LocalDateTime;

public class Event {

    private int id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private EventRepeatType repeatType;
    private int eventCustomRepeat;
    private int eventNotificationMinutes;
    private EventStatus status;
    private LocalDateTime eventCreatedAt;

}
