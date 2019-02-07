package com.jland.website.service.impl;

import com.jland.website.model.Participant;
import com.jland.website.repository.ParticipantRepository;
import com.jland.website.service.ParticipantService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceIml implements ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantServiceIml(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public boolean isParticipant(long userId, long conferenceId) {
        return participantRepository.isParticipant(userId,conferenceId);
    }

    @Override
    public void participate(long userId, long conferenceId) {
        participantRepository.participate(userId, conferenceId);
    }

    @Override
    public void notParticipate(long userId, long conferenceId) {
        participantRepository.notParticipate(userId, conferenceId);
    }

    @Override
    public List<Participant> getAll(long conferenceId) {
       return participantRepository.getAllByConferenceId(conferenceId);
    }

}
