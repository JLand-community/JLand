package com.jland.website.service;

import com.jland.website.model.PresentationPlanItem;

import java.util.List;

public interface PresentationService {

    List<PresentationPlanItem> getPresentationPlan(Long presentationId);
}
