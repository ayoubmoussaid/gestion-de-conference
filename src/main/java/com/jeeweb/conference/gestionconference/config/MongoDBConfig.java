package com.jeeweb.conference.gestionconference.config;

import com.jayway.jsonpath.Criteria;
import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.documents.Session;
import com.jeeweb.conference.gestionconference.repository.ConferenceRepository;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import com.jeeweb.conference.gestionconference.repository.SessionRepository;
import com.jeeweb.conference.gestionconference.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@Configuration
public class MongoDBConfig{

	@Bean
	CommandLineRunner commandLineRunner(UsersRepository usersRepository,
	                                    SessionRepository sessionRepository,
	                                    CuserRepository cuserRepository,
	                                    ConferenceRepository conferenceRepository
	) {
		return args -> {
			cuserRepository.save(new Cuser(1, "rainman", "ayoub", "moussaid", "phonenumber", "test@test.com", "something","admin"));
			cuserRepository.save(new Cuser(2, "hamid", "achraf", "lasri", "phonenumber", "test@test.com", "something","chair"));
			Conference conf = new Conference(1, "intelligence artificielle", new Date(), new Date(), null);
			conferenceRepository.save(conf);

			Cuser user = cuserRepository.findById(2).get();
			user.getConferences().add(conf);
			cuserRepository.save(user);
		};
	}
}
