package com.jland.service.impl;

import com.jland.model.Conference;
import com.jland.repository.ConferenceRepository;
import com.jland.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Conference getConferenceById(Long conferenceId) {
        return conferenceRepository.getConferenceById(conferenceId);
    }
}
