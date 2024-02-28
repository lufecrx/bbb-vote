package br.com.lufecrx.projects.bbb.vote.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lufecrx.projects.bbb.vote.api.model.ParticipantModel;

public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {
    
}
