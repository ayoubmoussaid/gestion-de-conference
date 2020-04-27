package com.jeeweb.conference.gestionconference.config;

import com.jeeweb.conference.gestionconference.documents.User;
import com.jeeweb.conference.gestionconference.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDBConfig {
	@Bean
	CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
		return onfeargs -> {
			usersRepository.save(new User(1, "ayoub", "moussaid", 1500L));
			usersRepository.save(new User(2, "youssef", "hamid", 2300L));
		};
	}
}
