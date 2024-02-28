package br.com.lufecrx.projects.bbb.vote.api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.lufecrx.projects.bbb.vote.api.model.ParticipantModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoteService {
    
    private static final String TOPIC = "vote";
    private final KafkaTemplate<Object, Object> template;

    public void addEvent(ParticipantModel participant) {
        template.send(TOPIC, participant);
    }
}
