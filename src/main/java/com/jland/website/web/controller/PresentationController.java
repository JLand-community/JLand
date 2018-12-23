package com.jland.website.web.controller;

import com.jland.website.service.PresentationService;
import com.jland.website.web.dto.PresentationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/presentations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PresentationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PresentationController.class);

    private final PresentationService presentationService;

    public PresentationController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @RequestMapping(value = "/{conferenceId}", method = RequestMethod.GET)
    public ResponseEntity<List<PresentationDto>> getAllByConferenceId(@PathVariable("conferenceId") Long conferenceId) {
        LOGGER.info("Getting all presentations");
        return new ResponseEntity<>(presentationService.getAllByConferenceId(conferenceId), HttpStatus.OK);
    }
}
