package com.jland.website.service.impl;

import com.jland.website.model.PresentationPlan;
import com.jland.website.repository.PresentationPlanRepository;
import com.jland.website.service.PresentationPlanService;
import com.jland.website.web.dto.PresentationPlanDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresentationPlanServiceImpl implements PresentationPlanService {

    private final PresentationPlanRepository presentationPlanRepository;

    public PresentationPlanServiceImpl(PresentationPlanRepository presentationPlanRepository) {
        this.presentationPlanRepository = presentationPlanRepository;
    }

    @Override
    public List<PresentationPlanDto> getAllByPresentationId(Long presentationId) {
        List<PresentationPlan> presentationPlan = presentationPlanRepository.getAllByPresentationId(presentationId);
        return presentationPlan.stream().map(PresentationPlanDto::from).collect(Collectors.toList());
    }
}
