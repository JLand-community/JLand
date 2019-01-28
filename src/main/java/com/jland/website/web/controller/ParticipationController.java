package com.jland.website.web.controller;

import com.jland.website.model.Participant;
import com.jland.website.service.ParticipationService;
import com.jland.website.web.dto.ParticipationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/participants", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ParticipationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipationController.class);

    private ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @RequestMapping(value = "/{conferenceId}", method = RequestMethod.GET)
    public ResponseEntity<List<ParticipationDto>> getAllByConferenceId(@PathVariable("conferenceId") Long conferenceId) {
        LOGGER.info("Get list of participants by conference id {}.", conferenceId);
        return new ResponseEntity<>(participationService.getAllByConferenceId(conferenceId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void add (@RequestBody ParticipationDto participant) {
        LOGGER.info("Adding participant");
        participationService.add(participant);
    }
}
