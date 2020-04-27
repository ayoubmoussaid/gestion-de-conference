package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.Cuser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CuserRepository extends MongoRepository<Cuser, Integer> {
	Cuser findCuserById(int id);
}
