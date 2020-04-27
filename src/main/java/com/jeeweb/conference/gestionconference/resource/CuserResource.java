package com.jeeweb.conference.gestionconference.resource;

import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/Cusers")
public class CuserResource {
	private CuserRepository cuserRepository;

	public CuserResource(CuserRepository cuserRepository) {
		this.cuserRepository = cuserRepository;
	}

	@GetMapping("/all")
	public List<Cuser> getAll(){
		return cuserRepository.findAll();
	}
}
