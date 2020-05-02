package com.jeeweb.conference.gestionconference;

import com.jeeweb.conference.gestionconference.repository.*;
import com.jeeweb.conference.gestionconference.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class GestionConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionConferenceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService,
							CuserRepository cuserRepository){
		return args -> {
			cuserRepository.deleteAll();
			Stream.of("admin").forEach(user->{
				accountService.saveUser(user, "1234", "1234", user.toUpperCase(), null);
			});
		};
	}

	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}
}
