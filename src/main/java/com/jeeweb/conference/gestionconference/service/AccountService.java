package com.jeeweb.conference.gestionconference.service;

import com.jeeweb.conference.gestionconference.documents.Cuser;

public interface AccountService {
    public Cuser saveUser( String username, String password, String confirmedPassword, String firstName, String lastName, String phone, String email, String role);
    public Cuser loadUserByUsername(String username);
}
