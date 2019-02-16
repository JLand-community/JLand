package com.jland.website.web.controller;

import com.jland.website.model.Conference;

import com.jland.website.model.User;
import com.jland.website.service.ConferenceService;
import com.jland.website.service.EventService;
import com.jland.website.service.ParticipantService;
import com.jland.website.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = {"/home", "/"})
public class HomePageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

    private final ConferenceService conferenceService;
    private final EventService eventService;
    private final ParticipantService participantService;
    private final UserService userService;

    public HomePageController(ConferenceService conferenceService, EventService eventService, ParticipantService participantService, UserService userService) {
        this.conferenceService = conferenceService;
        this.eventService = eventService;
        this.participantService = participantService;
        this.userService = userService;
    }

    @GetMapping
    public String mainPage(Model model, Principal principal)  {
        Conference conference = conferenceService.getNearestConference();
        User user = userService.findUserByUsername(principal.getName());
        boolean isParticipant = participantService.isParticipant(user.getId(), conference.getId());
        LOGGER.info("Request for displaying last created conference {} and its agenda events", conference);
        model.addAttribute("conference", conference);
        model.addAttribute("user", user);
        model.addAttribute("isParticipant", isParticipant);
        model.addAttribute("events", eventService.getAllByConferenceId(conference.getId()));
        return "mainpage";
    }

}
