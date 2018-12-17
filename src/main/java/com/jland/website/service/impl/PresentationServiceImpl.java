package com.jland.website.service.impl;

import com.jland.website.model.Presentation;
import com.jland.website.repository.PresentationRepository;
import com.jland.website.service.PresentationService;
import com.jland.website.web.dto.PresentationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresentationServiceImpl implements PresentationService {

    private final PresentationRepository presentationRepository;

    public PresentationServiceImpl(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    @Override
    public List<PresentationDto> getPresentationsByConferenceId(Long conferenceId) {
        List<Presentation> presentations = presentationRepository.getPresentationsByConferenceId(conferenceId);
        return presentations.stream().map(PresentationDto::from).collect(Collectors.toList());
    }
}
