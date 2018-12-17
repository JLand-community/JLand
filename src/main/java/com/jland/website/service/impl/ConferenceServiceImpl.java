package com.jland.website.service.impl;

import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import com.jland.website.service.ConferenceService;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Conference getConferenceById(Long conferenceId) {
        return conferenceRepository.getConferenceById(conferenceId);
    }
}
