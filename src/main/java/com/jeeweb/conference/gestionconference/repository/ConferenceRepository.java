package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.documents.Cuser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConferenceRepository extends MongoRepository<Conference, Integer> {
	Conference findConferenceById(int id);
	List<Conference> findConferenceByUser(Cuser user);
}
