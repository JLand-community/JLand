package com.jland.repository;

import com.jland.model.PresentationPlan;

import java.util.List;

public interface PresentationPlanRepository {

    List<PresentationPlan> getPresentationPlanByPresentationId(Long presentationId);
}
