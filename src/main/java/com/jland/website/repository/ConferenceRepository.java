package com.jland.website.repository;

import com.jland.website.model.Conference;

public interface ConferenceRepository {

    Conference getConferenceById(Long conferenceId);
}