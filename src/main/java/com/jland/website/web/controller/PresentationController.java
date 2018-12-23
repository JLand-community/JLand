package com.jland.website.web.controller;

import com.jland.website.service.PresentationPlanService;
import com.jland.website.service.PresentationService;
import com.jland.website.web.dto.PresentationDto;
import com.jland.website.web.dto.PresentationPlanDto;
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
    private final PresentationPlanService presentationPlanService;

    public PresentationController(PresentationService presentationService, PresentationPlanService presentationPlanService) {
        this.presentationService = presentationService;
        this.presentationPlanService = presentationPlanService;
    }

    @RequestMapping(value = "/{conferenceId}", method = RequestMethod.GET)
    public ResponseEntity<List<PresentationDto>> getAllByConferenceId(@PathVariable("conferenceId") Long conferenceId) {
        LOGGER.info("Getting all presentations by conference Id = {}", conferenceId);
        return new ResponseEntity<>(presentationService.getAllByConferenceId(conferenceId), HttpStatus.OK);
    }

    @RequestMapping(value = "/presentation/{presentationId}", method = RequestMethod.GET)
    public ResponseEntity<List<PresentationPlanDto>> getPresentationPlans(@PathVariable("presentationId") Long presentationId) {
        LOGGER.info("Get list of presentation plans by presentationId = {}", presentationId);
        return new ResponseEntity<>(presentationPlanService.getAllByPresentationId(presentationId), HttpStatus.OK);
    }
}
