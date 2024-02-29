package br.com.lufecrx.bbb.vote.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lufecrx.bbb.vote.ms.model.VoteModel;

public interface VoteRepository extends MongoRepository<VoteModel, String> {

}
