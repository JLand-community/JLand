package com.jland.website.repository;

import com.jland.website.model.Participation;

import java.util.List;

public interface ParticipationRepository {

    List<Participation> getAllByConferenceId(Long conferenceId);

    void addParticipant();
}
