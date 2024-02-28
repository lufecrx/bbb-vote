package br.com.lufecrx.projects.bbb.vote.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lufecrx.projects.bbb.vote.api.model.ParticipantModel;
import br.com.lufecrx.projects.bbb.vote.api.repository.ParticipantRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/participants")
@AllArgsConstructor
public class ParticipantController {
    
    private final ParticipantRepository repository;

    @PostMapping("/save")
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel parameter) {
        ParticipantModel entity = repository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consult")
    public ResponseEntity<ParticipantModel> consult(@RequestParam String id) {
        Optional<ParticipantModel> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opt.get());
    }
}
