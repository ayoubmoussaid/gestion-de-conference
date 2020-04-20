package com.jeeweb.conference.gestionconference.resource;


import com.jeeweb.conference.gestionconference.documents.User;
import com.jeeweb.conference.gestionconference.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
	private UsersRepository usersRepository;

	public UsersResource(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/all")
	public List<User> getAll(){
		return usersRepository.findAll();
	}
}
