package br.com.lufecrx.projects.bbb.vote.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lufecrx.projects.bbb.vote.api.model.ParticipantModel;
import br.com.lufecrx.projects.bbb.vote.api.service.VoteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vote")
@AllArgsConstructor
public class VoteController {

    private final VoteService service;
    
    @PostMapping
    public ResponseEntity<String> vote(@RequestBody ParticipantModel participant) {
        service.addEvent(participant);
        return ResponseEntity.ok("vote counted");
    }
}
