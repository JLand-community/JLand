package com.jland.website.repository;

import com.jland.website.model.Participant;
import com.jland.website.model.User;

import java.util.List;

public interface ParticipantRepository {

    void registerParticipant(long userId, long conferenceId);

    void unregisterParticipant(long userId, long conferenceId);

    List<Participant> getAllByConferenceId(Long conferenceId);

    Boolean isParticipant(long userId, long conferenceId);


}
