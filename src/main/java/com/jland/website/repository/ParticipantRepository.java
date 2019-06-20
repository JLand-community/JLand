package com.jland.website.repository;

public interface ParticipantRepository {

    void participate(long userId, long conferenceId);

    void notParticipate(long userId, long conferenceId);

}
