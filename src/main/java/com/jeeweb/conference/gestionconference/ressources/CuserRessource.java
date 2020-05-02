package com.jeeweb.conference.gestionconference.ressources;


import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/cusers")
public class CuserRessource {
	private CuserRepository cuserRepository;

	public CuserRessource(CuserRepository cusersRepository) {
		this.cuserRepository = cusersRepository;
	}

	@GetMapping("/all")
	public List<Cuser> getAll(){
		return cuserRepository.findAll();
	}

	@GetMapping("/chair")
	public List<Cuser> getAllChairs(){return cuserRepository.findCuserByRole("CHAIR");}

	@GetMapping("/test")
	public List<Conference> getAllConference(){return cuserRepository.findByUsername("anotherChair").getConferences();}
}
