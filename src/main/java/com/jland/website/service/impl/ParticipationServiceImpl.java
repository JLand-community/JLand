package com.jland.website.service.impl;

import com.jland.website.model.Participation;
import com.jland.website.repository.ParticipationRepository;
import com.jland.website.service.ParticipationService;
import com.jland.website.web.dto.ParticipationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipationServiceImpl implements ParticipationService {
    private ParticipationRepository participationRepository;

    public ParticipationServiceImpl(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Override
    public List<ParticipationDto> getAllByConferenceId(Long conferenceId) {
         List<Participation> participants = participationRepository.getAllByConferenceId(conferenceId);
        return participants.stream().map(ParticipationDto::from).collect(Collectors.toList());
    }
}
