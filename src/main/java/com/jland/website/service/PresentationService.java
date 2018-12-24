package com.jland.website.service;

import com.jland.website.web.dto.PresentationDto;

import java.util.List;

public interface PresentationService {

    List<PresentationDto> getAllByConferenceId(Long conferenceId);
}
