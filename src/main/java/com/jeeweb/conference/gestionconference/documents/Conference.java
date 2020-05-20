package com.jeeweb.conference.gestionconference.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Conference {
    @Id
	private int id;
	private String title;
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datedebut;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datefin;
	@DBRef
	private List<Session> sessions = new ArrayList<>();
	@DBRef
	private Cuser chair;
	@DBRef
	private Collection<Proposition> propositions = new ArrayList<>();
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
