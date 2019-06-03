package com.jland.website.service;

import com.jland.website.model.Conference;

public interface ConferenceService {

    Conference getById(Long conferenceId);

    Conference getUpcomingConference();

}
