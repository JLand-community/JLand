package com.jland.service.impl;

import com.jland.model.Event;
import com.jland.model.Presentation;
import com.jland.model.User;
import com.jland.repository.PresentationRepository;
import com.jland.service.PresentationService;
import com.jland.web.dto.PresentationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PresentationServiceImplTest {

    @Mock
    private PresentationRepository presentationRepository;
    @InjectMocks
    private PresentationServiceImpl service;

    @Test
    void getPresentationsByConferenceId() {
        // Given
        Presentation presentation = new Presentation();
        User user = new User();
        user.setFirstName("FName");
        user.setLastName("LName");
        presentation.setUser(user);
        Event event = new Event();
        event.setName("EName");
        event.setType("Type");
        event.setStartTime(LocalTime.of(1, 20));
        event.setEndTime(LocalTime.of(3, 20));
        presentation.setEvent(event);
        presentation.setName("PName");
        List<Presentation> presentations = Collections.singletonList(presentation);
        given(presentationRepository.getPresentationsByConferenceId(anyLong())).willReturn(presentations);

        // When
        List<PresentationDto> resultList = service.getPresentationsByConferenceId(1L);
        assertEquals(1, resultList.size());
        assertEquals("PName", resultList.get(0).getPresentationName());
        assertEquals("FName", resultList.get(0).getUserFirstName());
        assertEquals("LName", resultList.get(0).getUserLastName());


    }
}