package com.jland.website.repository;

import com.jland.website.model.Participant;

import java.util.List;

public interface ParticipantRepository {

    void participate(long userId, long conferenceId);

    void notParticipate(long userId, long conferenceId);

    List<Participant> getAllByConferenceId(Long conferenceId);

    Boolean isParticipant(long userId, long conferenceId);


}
