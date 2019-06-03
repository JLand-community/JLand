
package com.jland.website.web.controller;

import com.jland.website.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/conferences"})
public class ConferenceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        LOGGER.info("Request to retrieve conference with id {}", id);
        return new ResponseEntity<>(conferenceService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/upcomingConference")
    public ResponseEntity<?> getUpcomingConference() {
        LOGGER.info("Request to retrieve conference with max id");
        return new ResponseEntity<>(conferenceService.getUpcomingConference(), HttpStatus.OK);
    }
}

