package com.jland.website.web.controller;

import com.jland.website.model.Conference;
import com.jland.website.model.User;
import com.jland.website.service.ConferenceService;
import com.jland.website.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/home"})
public class HomePageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

    private final ConferenceService conferenceService;
    private final EventService eventService;

    @Autowired
    public HomePageController(ConferenceService conferenceService, EventService eventService) {
        this.conferenceService = conferenceService;
        this.eventService = eventService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String mainPage(Model model) {
        Conference conference = conferenceService.getNearestConference();
        LOGGER.info("Request for displaying last created conference {} and its agenda events", conference);
        model.addAttribute("conference", conference);
        model.addAttribute("user", new User("Alyona", "Stroganova"));
        model.addAttribute("events", eventService.getAllByConferenceId(conference.getId()));
        return "mainpage";
    }
}
