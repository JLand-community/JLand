package com.jland.website.service;

import com.jland.website.web.dto.ParticipationDto;

import java.util.List;

public interface ParticipationService {

    List<ParticipationDto> getAllByConferenceId(Long conferenceId);

    void add(ParticipationDto participant);
}
