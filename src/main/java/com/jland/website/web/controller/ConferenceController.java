package com.jland.website.web.controller;

import com.jland.website.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/conference", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConferenceController {

    private static final Logger log = LoggerFactory.getLogger(ConferenceController.class);

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getConferenceById(@PathVariable("id") Long id) {
        log.info("Request to retrieve conference with id {}", id);
        return new ResponseEntity<>(conferenceService.getConferenceById(id), HttpStatus.OK);
    }
}
