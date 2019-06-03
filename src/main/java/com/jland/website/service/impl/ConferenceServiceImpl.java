package com.jland.website.service.impl;

import com.jland.website.exception.EntityNotFoundException;
import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import com.jland.website.service.ConferenceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Conference getById(Long id) {
        Optional<Conference> conference = conferenceRepository.getById(id);
        if (conference.isPresent()) {
            return conference.get();
        }
        throw new EntityNotFoundException("Conference hasn't been found by id: " + id);
    }

    @Override
    public Conference getUpcomingConference() {
        Optional<Conference> conference = conferenceRepository.getUpcomingConference();
        if (conference.isPresent()) {
            return conference.get();
        }
        throw new EntityNotFoundException("Anyone conference hasn't been found");
    }


}
