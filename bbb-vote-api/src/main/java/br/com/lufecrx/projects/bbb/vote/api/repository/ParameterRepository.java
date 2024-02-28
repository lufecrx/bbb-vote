package br.com.lufecrx.projects.bbb.vote.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lufecrx.projects.bbb.vote.api.model.ParameterModel;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {
    
}
