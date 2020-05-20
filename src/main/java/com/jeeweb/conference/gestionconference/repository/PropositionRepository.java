package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.Proposition;
import com.jeeweb.conference.gestionconference.documents.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PropositionRepository extends MongoRepository<Proposition, Integer> {

}
