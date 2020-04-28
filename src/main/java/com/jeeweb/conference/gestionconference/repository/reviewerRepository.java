package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.Cuser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface reviewerRepository extends MongoRepository<Cuser, Integer> {

}
