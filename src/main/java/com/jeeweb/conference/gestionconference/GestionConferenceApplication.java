package com.jeeweb.conference.gestionconference;

import com.jeeweb.conference.gestionconference.documents.*;
import com.jeeweb.conference.gestionconference.repository.*;
import com.jeeweb.conference.gestionconference.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                            ConferenceRepository conferenceRepository,
                            PropositionRepository propositionRepository,
							SessionRepository sessionRepository){
		return args -> {

//			Stream.of("1 admin ADMIN", "2 chair CHAIR", "3 anotherChair CHAIR", "4 author AUTHOR", "5 reviewer REVIEWER").forEach(user->{
//				System.out.println(Integer.parseInt(user.split("")[0]));
//				System.out.println(user.split("")[1]);
//				System.out.println(user.split("")[2]);
//				accountService.saveUser(Integer.parseInt(user.split("")[0]), user.split("")[1], "1234", "1234", user.toUpperCase(), null, user.split("")[2]);
//			});


            cuserRepository.deleteAll();


			accountService.saveUser( "admin", "1234", "1234", "molChi", "Travolta","060601", "conf@gmail.com", "ADMIN");
			accountService.saveUser( "chair", "1234", "1234", "anaResponsable", "Travolta","060601", "conf@gmail.com", "CHAIR");
			accountService.saveUser( "anotherChair", "1234", "1234", "anaResponsableAkhur", "Travolta","060601", "conf@gmail.com", "CHAIR");
			accountService.saveUser( "author", "1234", "1234", "anaAuthor", "Travolta","060601", "conf@gmail.com", "AUTHOR");
			accountService.saveUser( "reviewer", "1234", "1234", "anaKanReview", "Travolta","060601", "conf@gmail.com", "REVIEWER");


			conferenceRepository.deleteAll();
            conferenceRepository.save(new Conference(1,"AI Conf20","This is our last conference so i'm gonna stop the description ",
					new SimpleDateFormat("dd-MM-yyyy").parse("20-05-2020"),new SimpleDateFormat("dd-MM-yyyy").parse("22-05-2020"),
					null,null, null));
            conferenceRepository.save(new Conference(2,"Corona Virus v19","Corona is deadly stay safe",
					new SimpleDateFormat("dd-MM-yyyy").parse("25-05-2020"),new SimpleDateFormat("dd-MM-yyyy").parse("26-05-2020"),
					null,cuserRepository.findById(2).get(),null));
            Conference c = new Conference(3,"The world is ending Conf 2.0","Yep as you heard this is the second meeting in the series of the last day on earth talking about stuff",
					new SimpleDateFormat("dd-MM-yyyy").parse("02-06-2020"),new SimpleDateFormat("dd-MM-yyyy").parse("05-06-2020"),
					null,null,new ArrayList<>());



            propositionRepository.deleteAll();
            Proposition p1 = new Proposition(1,"Prop1 title","",false,null,c,null);
            Proposition p2 = new Proposition(2,"Prop2 title","",false,null,c,null);
			c.getPropositions().add(p1);
			c.getPropositions().add(p2);
            conferenceRepository.save(c);
            propositionRepository.save(p1);
            propositionRepository.save(p2);
//            sessionRepository.save(new Session(1,"t",new Date(),"room1",null,null));
		};
	}

	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}
}
