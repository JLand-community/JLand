package com.jland.service.impl;

import com.jland.model.Presentation;
import com.jland.repository.PresentationRepository;
import com.jland.service.PresentationService;
import com.jland.web.dto.PresentationDto;
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
