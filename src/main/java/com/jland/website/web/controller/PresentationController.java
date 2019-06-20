package com.jland.website.web.controller;

import com.jland.website.service.PresentationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/presentations/")
public class PresentationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    private PresentationService presentationService;

    public PresentationController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @GetMapping("/{presentationId}/presentationPlan")
    public ResponseEntity<?> getPresentationPlan(@PathVariable Long presentationId) {
        LOGGER.info("Request to retrieve presentation plan by presentation id {}", presentationId);
        return new ResponseEntity<>(presentationService.getPresentationPlan(presentationId), HttpStatus.OK);
    }
}
