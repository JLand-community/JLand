package com.jland.web.controller;

import com.jland.service.PresentationService;
import com.jland.web.dto.PresentationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/presentation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PresentationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final PresentationService presentationService;

    public PresentationController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @RequestMapping(value = "/{presentationId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<PresentationDto>> getPresentationsByConferenceId(@PathVariable("presentationId") Long conferenceId) {
        LOGGER.info("Getting all presentations");
        return new ResponseEntity<>(presentationService.getPresentationsByConferenceId(conferenceId), HttpStatus.OK);
    }
}
