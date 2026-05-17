package com.agenda.event.repository;

import com.agenda.event.model.Event;

public interface EventRepository {
    int saveEvent(Event event);
}
