
package com.jland.website.web.controller;

import com.jland.website.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conferences", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConferenceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("Request to retrieve conference with id {}", id);
        return new ResponseEntity<>(conferenceService.getById(id), HttpStatus.OK);
    }
}

