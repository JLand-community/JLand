package com.jland.website.repository;

import com.jland.website.model.Participant;

import java.util.List;

public interface ParticipationRepository {

    List<Participant> getAllByConferenceId(Long conferenceId);

    void add(Participant participant);
}
