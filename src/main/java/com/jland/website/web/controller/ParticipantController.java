package com.jland.website.web.controller;

import com.jland.website.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/conference/{conferenceId}/user/{userId}")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping(path = "/register")
    public String register(@PathVariable("userId") long userId, @PathVariable("conferenceId")  long conferenceId) {
        participantService.register(userId , conferenceId);
        return "redirect:/home";
    }

    @PostMapping(path = "/unregister")
    public String unregister(@PathVariable("userId") long userId, @PathVariable("conferenceId")  long conferenceId) {
        participantService.unregister(userId, conferenceId);
        return "redirect:/home";
    }


}
