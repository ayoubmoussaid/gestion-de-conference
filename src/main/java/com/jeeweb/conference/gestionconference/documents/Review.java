package com.jeeweb.conference.gestionconference.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String id;
    private float note;
    private String comment;
    @DBRef
    private Conference conference;
    @DBRef
    private Cuser user;
    @DBRef
    private Proposition proposition;

}
