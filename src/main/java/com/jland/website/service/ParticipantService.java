package com.jland.website.service;

import com.jland.website.model.Participant;

import java.util.List;

public interface ParticipantService {

    boolean isParticipant(long userId, long conferenceId);

    void register(long userId, long conferenceId);

    void unregister(long userId, long conferenceId);

    List<Participant> getAll(long conferenceId);

}
