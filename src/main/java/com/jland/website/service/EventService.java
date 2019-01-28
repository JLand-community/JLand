package com.jland.website.service;

import com.jland.website.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllByConferenceId(Long conferenceId);

}
