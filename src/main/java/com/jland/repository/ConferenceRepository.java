package com.jland.repository;

import com.jland.model.Conference;

public interface ConferenceRepository {

    Conference getConferenceById(Long conferenceId);
}
