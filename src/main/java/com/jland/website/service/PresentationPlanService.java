package com.jland.website.service;

import com.jland.website.web.dto.PresentationPlanDto;

import java.util.List;

public interface PresentationPlanService {

    List<PresentationPlanDto> getAllByPresentationId(Long presentationId);
}
