package com.agenda.event.repository;

import com.agenda.event.model.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventInMemoryRepository implements EventRepository{

    private final List<Event> eventList;
    private int nextId;

    public EventInMemoryRepository() {
        this.eventList = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public int saveEvent(Event event) {
        event.setId(nextId++);
        this.eventList.add(event);
        return event.getId();
    }

    public List<Event> findAll() {
        return Collections.unmodifiableList(eventList);
    }
}
