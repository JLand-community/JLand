package com.jland.website.service.impl;

import com.jland.website.repository.ParticipantRepository;
import com.jland.website.service.ParticipantService;

import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceIml implements ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantServiceIml(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public void participate(long userId, long conferenceId) {participantRepository.participate(userId, conferenceId);
    }

    @Override
    public void notParticipate(long userId, long conferenceId) {
        participantRepository.notParticipate(userId, conferenceId);
    }

}
