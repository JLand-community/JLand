package com.jland.website.web.controller;

import com.jland.website.service.ParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/conferences/{conferenceId}")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping(path = "/user/{userId}/participate")
    public String participate(@PathVariable("userId") long userId, @PathVariable("conferenceId")  long conferenceId) {
        participantService.participate(userId , conferenceId);
        return "redirect:/home";
    }

    @PostMapping(path = "/user/{userId}/notParticipate")
    public String notParticipate(@PathVariable("userId") long userId, @PathVariable("conferenceId")  long conferenceId) {
        participantService.notParticipate(userId, conferenceId);
        return "redirect:/home";
    }

    @GetMapping(path = "/participants")
    public String getAll(Model model, @PathVariable("conferenceId")  long conferenceId){
        model.addAttribute("participants", participantService.getAll(conferenceId));

       return "participants";
    }


}
