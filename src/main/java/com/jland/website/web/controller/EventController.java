package com.jland.website.web.controller;


import com.jland.website.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conferences/{id}")
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/agendaEvents")
    public ResponseEntity<?> getAll(@PathVariable("id") Long id) {
        LOGGER.info("Request to retrieve agenda events by conference id {}", id);
        return new ResponseEntity<>(eventService.getAllByConferenceId(id), HttpStatus.OK);
    }
}
