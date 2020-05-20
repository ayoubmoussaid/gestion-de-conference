package com.jeeweb.conference.gestionconference.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Session {
    @Id
    private int id;
    private String title;
    private Date date;
    private String room;
    @DBRef
    private Proposition proposition;
    @DBRef
    private Conference conference;


    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", room='" + room + '\'' +
                '}';
    }
}
