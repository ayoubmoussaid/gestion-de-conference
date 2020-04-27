package com.jeeweb.conference.gestionconference.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Conference {
	private int id;
	private String title;
	private Date datedebut;
	private Date datefin;
	private List<Session> sessions;

	@Override
	public String toString() {
		return "Conference{" +
				"id=" + id +
				", title='" + title + '\'' +
				", datedebut=" + datedebut +
				", datefin=" + datefin +
				", sessions=" + sessions +
				'}';
	}
}
