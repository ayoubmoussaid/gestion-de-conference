package com.jeeweb.conference.gestionconference.resource;

import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.repository.ConferenceRepository;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/rest/conference")
public class ConferenceResource {
	private ConferenceRepository conferenceRepository;

	public ConferenceResource(ConferenceRepository conferenceRepository) {
		this.conferenceRepository = conferenceRepository;
	}

	@GetMapping("/all")
	public List<Conference> getAll(){
		return conferenceRepository.findAll();
	}
}
