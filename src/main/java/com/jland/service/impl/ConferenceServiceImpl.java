package com.jland.service.impl;

import com.jland.model.Conference;
import com.jland.repository.ConferenceRepository;
import com.jland.service.ConferenceService;
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
