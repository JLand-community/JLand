package com.jland.website.service.impl;

import com.jland.website.model.PresentationPlanItem;
import com.jland.website.repository.PresentationRepository;
import com.jland.website.service.PresentationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationServiceDefault implements PresentationService {

    private final PresentationRepository presentationRepository;

    public PresentationServiceDefault(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    @Override
    public List<PresentationPlanItem> getPresentationPlan(Long presentationId) {
        return presentationRepository.getPresentationPlan(presentationId);
    }
}
