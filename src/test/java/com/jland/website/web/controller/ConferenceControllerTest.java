package com.jland.website.web.controller;

import com.jland.website.model.Conference;
import com.jland.website.service.ConferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ConferenceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ConferenceService conferenceService;

    @InjectMocks
    private ConferenceController conferenceController;

    @BeforeEach
    void initMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(conferenceController).build();
    }

    @Test
    void getConferenceById() throws Exception {
        //GIVEN
        Conference conference = new Conference();
        conference.setId(1);
        conference.setDate(LocalDate.of(2019, 1, 12));
        conference.setDescription("New conference");
        conference.setAddress("Fabra");
        //WHEN
        when(conferenceService.getById(1L)).thenReturn(conference);
        //THEN
        mockMvc.perform(get("/api/conferences/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("date", is(
                        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ENGLISH)
                                .format(conference.getDate())
                        )))
                .andExpect(jsonPath("description", is(conference.getDescription())))
                .andExpect(jsonPath("address", is(conference.getAddress())));
    }

    @Test
    void getUpcomingConference() throws Exception {
        //GIVEN
        Conference conference = new Conference();
        conference.setId(1);
        conference.setDate(LocalDate.of(2019, 1, 12));
        conference.setDescription("New conference");
        conference.setAddress("Fabra");
        //WHEN
        when(conferenceService.getUpcomingConference()).thenReturn(conference);
        //THEN
        mockMvc.perform(get("/api/conferences/upcomingConference").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("date",
                        is(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ENGLISH)
                                .format(conference.getDate()))))
                .andExpect(jsonPath("description", is(conference.getDescription())))
                .andExpect(jsonPath("address", is(conference.getAddress())));
    }
}