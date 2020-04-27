package com.jeeweb.conference.gestionconference.documents;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor

public class Cuser {
	@Id
	private int id;
	private String username;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String password;
	private String role;
	private List<Conference> conferences;
	private List<Session> sessions;

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

	public Cuser(int id, String username, String first_name, String last_name, String phone, String email, String password, String role) {
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Conference> getConferences() {
		return conferences;
	}

	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
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
