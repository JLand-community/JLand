package com.jland.website.service.impl;

import com.jland.website.model.Event;
import com.jland.website.repository.EventRepository;
import com.jland.website.service.EventService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllByConferenceId(Long conferenceId) {
        return eventRepository.getAllByConferenceId(conferenceId);
    }
}
