package com.jland.website.repository;

import com.jland.website.model.PresentationPlanItem;

import java.util.List;

public interface PresentationPlanRepository {

    List<PresentationPlanItem> getAllByPresentationId(Long presentationId);
}
