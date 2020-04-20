package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, Integer> {
}
