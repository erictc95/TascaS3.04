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


    public Event(int id, String name, String description, LocalDateTime startDate, LocalDateTime endDate, String location, EventRepeatType repeatType, int eventCustomRepeat, int eventNotificationMinutes, EventStatus status, LocalDateTime eventCreatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.repeatType = repeatType;
        this.eventCustomRepeat = eventCustomRepeat;
        this.eventNotificationMinutes = eventNotificationMinutes;
        this.status = status;
        this.eventCreatedAt = eventCreatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public EventRepeatType getRepeatType() {
        return repeatType;
    }

    public int getEventCustomRepeat() {
        return eventCustomRepeat;
    }

    public int getEventNotificationMinutes() {
        return eventNotificationMinutes;
    }

    public EventStatus getStatus() {
        return status;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }
}
