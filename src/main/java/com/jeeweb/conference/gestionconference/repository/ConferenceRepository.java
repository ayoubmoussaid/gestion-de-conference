package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConferenceRepository extends MongoRepository<Conference, Integer> {
}
