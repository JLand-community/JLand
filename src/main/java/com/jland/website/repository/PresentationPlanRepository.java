package com.jland.website.repository;

import com.jland.website.model.PresentationPlan;

import java.util.List;

public interface PresentationPlanRepository {

    List<PresentationPlan> getAllByPresentationId(Long presentationId);
}
