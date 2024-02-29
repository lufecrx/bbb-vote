package br.com.lufecrx.bbb.vote.ms.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("votes")
public class VoteModel {
    
    @Id
    private String id;
    private ParticipantModel participant;
    private Date date;

}
