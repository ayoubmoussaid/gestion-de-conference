package com.jeeweb.conference.gestionconference.repository;

import com.jeeweb.conference.gestionconference.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsersRepository extends MongoRepository<User, Integer> {
}
