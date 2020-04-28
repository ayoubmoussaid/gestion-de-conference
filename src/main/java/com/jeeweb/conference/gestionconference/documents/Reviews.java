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
public class Reviews {
    private String id;
    private float note;
    private String comment;
    @DBRef
    private Conference conference;
    @DBRef
    private Cuser reviewer;
    @DBRef
    private Proposition proposition;

}
