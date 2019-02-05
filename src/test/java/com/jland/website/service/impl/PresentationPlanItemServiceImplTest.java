package com.jland.website.service.impl;

import com.jland.website.model.PresentationPlanItem;
import com.jland.website.repository.PresentationPlanRepository;
import com.jland.website.web.dto.PresentationPlanDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PresentationPlanItemServiceImplTest {
    @Mock
    PresentationPlanRepository repository;
    @InjectMocks
    PresentationPlanServiceImpl service;

    @Test
    public void getAllByPresentationId() {
        // Given
        PresentationPlanItem plan = new PresentationPlanItem();
        plan.setId(1L);
        plan.setItem("item");
        plan.setOrder(12);
        List<PresentationPlanItem> plans = Collections.singletonList(plan);
        given(repository.getAllByPresentationId(1L)).willReturn(plans);

        // When
        List<PresentationPlanDto> planDtos = service.getAllByPresentationId(1L);

        // Then
        assertThat(planDtos.size()).isEqualTo(1);
        assertThat(planDtos.get(0)).isEqualToComparingFieldByField(plan);
    }

}