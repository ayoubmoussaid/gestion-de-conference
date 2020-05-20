package com.jeeweb.conference.gestionconference.documents;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proposition {
    @Id
    private int id;
    private String titre;
    private String path;
    private boolean status;
    @DBRef
    private Cuser author;
    @DBRef
    private Conference conference;
    @DBRef
    private Session session;
}
