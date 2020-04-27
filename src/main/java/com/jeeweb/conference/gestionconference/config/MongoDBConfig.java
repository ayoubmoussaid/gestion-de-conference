package com.jeeweb.conference.gestionconference.config;

import com.jeeweb.conference.gestionconference.documents.Session;
import com.jeeweb.conference.gestionconference.documents.User;
import com.jeeweb.conference.gestionconference.repository.PropositionRepository;
import com.jeeweb.conference.gestionconference.repository.ReviewsRepository;
import com.jeeweb.conference.gestionconference.repository.SessionRepository;
import com.jeeweb.conference.gestionconference.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDBConfig {
	@Bean
	CommandLineRunner commandLineRunner(UsersRepository usersRepository,
										SessionRepository sessionRepository,
										PropositionRepository propositionRepository,
										ReviewsRepository reviewsRepository
										) {
		return onfeargs -> {
			usersRepository.save(new User(1, "ayoub", "moussaid", 1500L));
			usersRepository.save(new User(2, "youssef", "hamid", 2300L));

			sessionRepository.deleteAll();
			Stream.of("S1 Session une", "S2 Session tanya", "S3 Session talta").forEach(s -> {
				sessionRepository.save(new Session(s.split(" ")[0], s.split(" ")[1], new Date(), "Room"+s.split(" ")[0]));
			});
			sessionRepository.findAll().forEach(System.out::println);

			sessionRepository.deleteAll();
			Stream.of("S1 Session une", "S2 Session tanya", "S3 Session talta").forEach(s -> {
				sessionRepository.save(new Session(s.split(" ")[0], s.split(" ")[1], new Date(), "Room"+s.split(" ")[0]));
			});
			sessionRepository.findAll().forEach(System.out::println);

		};
	}
}
