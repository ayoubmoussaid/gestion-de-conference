package com.jeeweb.conference.gestionconference.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuser {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private int id;
	private String username;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String password;
	private String role;
	@DBRef
	private List<Conference> conferences = new ArrayList<>();
	@DBRef
	private List<Session> sessions = new ArrayList<>();
    @DBRef
    private Collection<Proposition> propositions = new ArrayList<>();

	public Cuser(int id, String username, String first_name, String last_name, String phone, String email, String password, String role, List<Conference> conferences, List<Session> sessions) {
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.conferences = conferences;
		this.sessions = sessions;
	}

	public Cuser(String first_name, String last_name, String phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
	}

	public Cuser(int id, String username, String first_name, String last_name, String phone, String email, String password, String role) {
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.conferences = new ArrayList<Conference>();
	}


	@Override
	public String toString() {
		return "Cuser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				", conferences=" + conferences +
				", sessions=" + sessions +
				'}';
	}
}
