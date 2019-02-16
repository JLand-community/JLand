package com.jland.website.web.controller;

import com.jland.website.service.PresentationPlanService;
import com.jland.website.service.PresentationService;
import com.jland.website.web.dto.PresentationDto;
import com.jland.website.web.dto.PresentationPlanDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PresentationControllerTest {

    private MockMvc mockMvc;
    @Mock
    private PresentationService presentationService;

    @Mock
    private PresentationPlanService presentationPlanService;
    @InjectMocks
    private PresentationController controller;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getPresentationsByConferenceId() throws Exception {
        // Given
        PresentationDto dto = new PresentationDto();
        dto.setPresentationName("PName");
        dto.setUserFirstName("Uname");
        dto.setUserLastName("ULname");
        List<PresentationDto> presentationDtos = Collections.singletonList(dto);
        given(presentationService.getAllByConferenceId(1L)).willReturn(presentationDtos);

        // When Then
        mockMvc.perform(get("/conferences/1/presentations").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].presentationName", is(dto.getPresentationName())))
                .andExpect(jsonPath("$[0].userFirstName", is(dto.getUserFirstName())))
                .andExpect(jsonPath("$[0].userLastName", is(dto.getUserLastName())));
    }

    @Test
    void getPresentationPansByPresentationId() throws Exception {
        //  Given
        PresentationPlanDto dto = new PresentationPlanDto();
        dto.setItem("item1");
        given(presentationPlanService.getAllByPresentationId(anyLong())).willReturn(Collections.singletonList(dto));

        // When Then
        mockMvc.perform(get("/conferences/1/presentations/1/plan"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].item", is(dto.getItem())));
    }
}