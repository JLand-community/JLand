package com.jland.website.repository;

import com.jland.website.model.Event;

import java.util.List;

public interface EventRepository {

    List<Event> getAllByConferenceId(Long conferenceId);

}
