package com.jeeweb.conference.gestionconference.ressources;

import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.repository.ConferenceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/conferences")
public class ConferenceRessource {
	private ConferenceRepository conferenceRepository;

	public ConferenceRessource(ConferenceRepository conferenceRepository) {
		this.conferenceRepository = conferenceRepository;
	}

	@GetMapping("/all")
	public List<Conference> getAll(){return conferenceRepository.findAll() ;}

}
