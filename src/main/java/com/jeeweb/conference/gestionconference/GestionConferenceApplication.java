package com.jeeweb.conference.gestionconference;

import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.repository.*;
import com.jeeweb.conference.gestionconference.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionConferenceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService,
							CuserRepository cuserRepository,
                            ConferenceRepository conferenceRepository){
		return args -> {
			cuserRepository.deleteAll();
//			Stream.of("1 admin ADMIN", "2 chair CHAIR", "3 anotherChair CHAIR", "4 author AUTHOR", "5 reviewer REVIEWER").forEach(user->{
//				System.out.println(Integer.parseInt(user.split("")[0]));
//				System.out.println(user.split("")[1]);
//				System.out.println(user.split("")[2]);
//				accountService.saveUser(Integer.parseInt(user.split("")[0]), user.split("")[1], "1234", "1234", user.toUpperCase(), null, user.split("")[2]);
//			});
			accountService.saveUser(1, "admin", "1234", "1234", "molChi", null, "ADMIN");
			accountService.saveUser(2, "chair", "1234", "1234", "anaResponsable", null, "CHAIR");
			accountService.saveUser(3, "anotherChair", "1234", "1234", "anaResponsableAkhur", null, "CHAIR");
			accountService.saveUser(4, "author", "1234", "1234", "anaAuthor", null, "AUTHOR");
			accountService.saveUser(5, "reviewer", "1234", "1234", "anaKanReview", null, "REVIEWER");

			conferenceRepository.deleteAll();
			Stream.of("1 AI", "2 Corona Virus", "3 The world is ending").forEach(conf->{
				conferenceRepository.save(new Conference(Integer.parseInt(conf.split("")[0]),conf.split("")[1],new Date(),null,null,null));
			});
		};
	}

	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}
}
