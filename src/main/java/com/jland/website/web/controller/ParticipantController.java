package com.jland.website.web.controller;

import com.jland.website.model.Participant;
import com.jland.website.service.ParticipantService;
import com.jland.website.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/conferences/{conferenceId}")
public class ParticipantController {

    private final ParticipantService participantService;
    private final UserService userService;
    public ParticipantController(ParticipantService participantService, UserService userService) {
        this.participantService = participantService;
        this.userService = userService;
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
    public String getAll(Model model, @PathVariable("conferenceId")  long conferenceId, Principal principal){
        List<Participant> participants = participantService.getAll(conferenceId);
        model.addAttribute("participants", participants);
        model.addAttribute("conferenceId", conferenceId);
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        model.addAttribute("count", participants.size());
       return "participants";
    }


}
