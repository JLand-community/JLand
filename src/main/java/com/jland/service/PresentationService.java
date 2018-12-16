package com.jland.service;

import com.jland.web.dto.PresentationDto;

import java.util.List;

public interface PresentationService {

    List<PresentationDto> getPresentationsByConferenceId(Long conferenceId);
}
