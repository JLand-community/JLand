package com.jland.website.web.controller;


import com.jland.website.model.Event;
import com.jland.website.model.PresentationEvent;
import com.jland.website.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EventControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    void initMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    void getAll() throws Exception {
        //GIVEN

        Event event = new Event();
        event.setId(1L);
        event.setType("Coffee");
        event.setName("Coffee break");
        event.setStartTime(LocalTime.of(11, 30));
        event.setEndTime(LocalTime.of(11, 45));
        event.setOrder(1);

        PresentationEvent presentationEvent = new PresentationEvent();
        presentationEvent.setId(2L);
        presentationEvent.setType("PresentationPlan");
        presentationEvent.setName("PresentationPlan name");
        presentationEvent.setStartTime(LocalTime.of(11, 45));
        presentationEvent.setEndTime(LocalTime.of(13, 0));
        presentationEvent.setOrder(2);
        presentationEvent.setPresentationId(21L);
        presentationEvent.setPresentationName("PresentationPlan name");
        presentationEvent.setUserLastName("User Last Name");
        presentationEvent.setUserFirstName("User First Name");


        List<Event> list = new ArrayList<>();
        list.add(event);
        list.add(presentationEvent);
        //WHEN
        when(eventService.getAllByConferenceId(1L)).thenReturn(list);
        //THEN
        mockMvc.perform(get("/conferences/1/agendaEvents").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].type", is(event.getType())))
                .andExpect(jsonPath("$[0].name", is(event.getName())))
                .andExpect(jsonPath("$[0].startTime", is(event.getStartTime().toString())))
                .andExpect(jsonPath("$[0].endTime", is(event.getEndTime().toString())))
                .andExpect(jsonPath("$[0].order", is(event.getOrder())))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].type", is(presentationEvent.getType())))
                .andExpect(jsonPath("$[1].name", is(presentationEvent.getName())))
                .andExpect(jsonPath("$[1].startTime", is(presentationEvent.getStartTime().toString())))
                .andExpect(jsonPath("$[1].endTime", is(presentationEvent.getEndTime().toString())))
                .andExpect(jsonPath("$[1].order", is(presentationEvent.getOrder())))
                .andExpect(jsonPath("$[1].presentationId", is(21)))
                .andExpect(jsonPath("$[1].presentationName", is(presentationEvent.getPresentationName())))
                .andExpect(jsonPath("$[1].userLastName", is(presentationEvent.getUserLastName())))
                .andExpect(jsonPath("$[1].userFirstName", is(presentationEvent.getUserFirstName())));

    }
}
