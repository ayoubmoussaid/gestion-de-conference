package com.jeeweb.conference.gestionconference;

import com.jeeweb.conference.gestionconference.documents.Session;
import com.jeeweb.conference.gestionconference.documents.User;
import com.jeeweb.conference.gestionconference.repository.PropositionRepository;
import com.jeeweb.conference.gestionconference.repository.ReviewsRepository;
import com.jeeweb.conference.gestionconference.repository.SessionRepository;
import com.jeeweb.conference.gestionconference.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionConferenceApplication.class, args);

	}
}
