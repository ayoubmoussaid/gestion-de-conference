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
public class Proposition {
    private String id;
    private String titre;
    private String path;
    @DBRef
    private Cuser author;
    private boolean status;
    @DBRef
    private Session session;
}
