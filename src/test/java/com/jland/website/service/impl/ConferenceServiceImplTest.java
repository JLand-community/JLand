package com.jland.website.service.impl;

import com.jland.website.exception.EntityNotFoundException;
import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ConferenceServiceImplTest {

    @Test
    void testGetByIdNegative() throws Exception {
        ConferenceRepository mockConferenceRepository = Mockito.mock(ConferenceRepository.class);

        when(mockConferenceRepository.getById(1L)).thenReturn(Optional.empty());
        ConferenceServiceImpl conferenceService = new ConferenceServiceImpl(mockConferenceRepository);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> conferenceService.getById(1L));
        assertEquals("Conference hasn't been found by id: 1", exception.getMessage());
    }

    @Test
    void testGetByIdPositive() throws Exception {
        ConferenceRepository mockConferenceRepository = Mockito.mock(ConferenceRepository.class);
        Conference conference = new Conference();
        conference.setId(1L);
        when(mockConferenceRepository.getById(1L)).thenReturn(Optional.of(conference));

        ConferenceServiceImpl conferenceService = new ConferenceServiceImpl(mockConferenceRepository);
        Conference actual = conferenceService.getById(1L);

        assertEquals(conference.getId(), actual.getId());
    }

    @Test
    void testGetNearestConferenceNegative() throws Exception {
        ConferenceRepository mockConferenceRepository = Mockito.mock(ConferenceRepository.class);

        when(mockConferenceRepository.getUpcomingConference()).thenReturn(Optional.empty());
        ConferenceServiceImpl conferenceService = new ConferenceServiceImpl(mockConferenceRepository);

        Exception exception = assertThrows(EntityNotFoundException.class, conferenceService::getUpcomingConference);
        assertEquals("Anyone conference hasn't been found", exception.getMessage());
    }

    @Test
    void testGetNearestConferencePositive() throws Exception {
        ConferenceRepository mockConferenceRepository = Mockito.mock(ConferenceRepository.class);
        Conference conference = new Conference();
        conference.setId(10L);

        when(mockConferenceRepository.getUpcomingConference()).thenReturn(Optional.of(conference));
        ConferenceServiceImpl conferenceService = new ConferenceServiceImpl(mockConferenceRepository);
        Conference actualNearestConference = conferenceService.getUpcomingConference();

        assertEquals(conference.getId(), actualNearestConference.getId());
    }

}