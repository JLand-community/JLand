package com.jland.website.web.controller;

import com.jland.website.service.ParticipantService;
import com.jland.website.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conferences/{conferenceId}")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceController.class);

    private final ParticipantService participantService;
    private final UserService userService;

    public UserController(ParticipantService participantService, UserService userService) {
        this.participantService = participantService;
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username, @PathVariable Long conferenceId) {
        LOGGER.info("Request to retrieve user info");
        System.out.println("username: " + username + ", conferenceId: " + conferenceId);
        return new ResponseEntity<>(userService.findByUsernameAndConferenceId(username, conferenceId), HttpStatus.OK);
    }

    @GetMapping("/participants")
    public ResponseEntity<?> getAll(@PathVariable Long conferenceId){
        LOGGER.info("Request to retrieve all participants by conference id");
        return new ResponseEntity<>(userService.getAll(conferenceId), HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/participate")
    public ResponseEntity<?> participate(@PathVariable Long userId, @PathVariable Long conferenceId) {
        LOGGER.info("Request to register user, userId {}", userId);
        participantService.participate(userId , conferenceId);
        return new ResponseEntity<>(userService.findByIdAndConferenceId(userId, conferenceId), HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/notParticipate")
    public ResponseEntity<?> notParticipate(@PathVariable Long userId, @PathVariable Long conferenceId) {
        participantService.notParticipate(userId, conferenceId);
        return new ResponseEntity<>(userService.findByIdAndConferenceId(userId, conferenceId), HttpStatus.OK);
    }

}
