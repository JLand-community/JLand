package com.jland.website.service.impl;

import com.jland.website.model.PresentationPlanItem;
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
        List<PresentationPlanItem> presentationPlanItem = presentationPlanRepository.getAllByPresentationId(presentationId);
        return presentationPlanItem.stream().map(PresentationPlanDto::from).collect(Collectors.toList());
    }
}
