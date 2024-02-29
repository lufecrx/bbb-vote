package br.com.lufecrx.bbb.vote.ms.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lufecrx.bbb.vote.ms.model.ParticipantModel;
import br.com.lufecrx.bbb.vote.ms.model.VoteModel;
import br.com.lufecrx.bbb.vote.ms.repository.VoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j 
public class VoteService {
    
    private final VoteRepository repository;

    @KafkaListener(topics = "vote", groupId = "MicroserviceVoteGroup")
    public void execute(ConsumerRecord<String, String> register) {
        String participantStr = register.value();
        log.info("vote received: {}", participantStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipantModel participant = null;
        
        try {
            participant = mapper.readValue(participantStr, ParticipantModel.class);
        } catch (JsonProcessingException e) {
            log.error("Error parsing json: {}", e.getMessage());
            return;
        }
        
        VoteModel vote = new VoteModel(null, participant, new Date());
        VoteModel entity = repository.save(vote);

        log.info("vote registred: [id={}, date={}]", entity.getId(), entity.getDate());
    }
}
