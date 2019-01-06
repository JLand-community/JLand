package com.jland.website.web.controller;

import com.jland.website.service.ParticipationService;
import com.jland.website.web.dto.ParticipationDto;
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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ParticipationControllerTest {

    private MockMvc mockMvc;
    @Mock
    private ParticipationService participationService;
    @InjectMocks
    private ParticipationController controller;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllByConferenceId() throws Exception {
        // Given
        ParticipationDto dto = new ParticipationDto();
        dto.setEventRole("Listener");
        dto.setFirstName("Uname");
        dto.setLastName("ULname");
        List<ParticipationDto> participationDtos = Collections.singletonList(dto);
        given(participationService.getAllByConferenceId(1L)).willReturn(participationDtos);

        // When Then
        mockMvc.perform(get("/participants/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].eventRole", is(dto.getEventRole())))
                .andExpect(jsonPath("$[0].firstName", is(dto.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", is(dto.getLastName())));
    }
}