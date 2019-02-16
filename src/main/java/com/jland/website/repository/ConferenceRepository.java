package com.jland.website.repository;

import com.jland.website.model.Conference;

import java.util.Optional;

public interface ConferenceRepository {

    Optional<Conference> getById(Long conferenceId);

    Optional<Conference> getNearestConference();


}
