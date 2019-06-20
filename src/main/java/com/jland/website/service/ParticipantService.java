package com.jland.website.service;

public interface ParticipantService {

    void participate(long userId, long conferenceId);

    void notParticipate(long userId, long conferenceId);

}
