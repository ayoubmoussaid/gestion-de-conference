package com.jeeweb.conference.gestionconference.service;

import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private CuserRepository cuserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(CuserRepository cuserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.cuserRepository = cuserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Cuser saveUser( String username, String password, String confirmedPassword, String firstName, String lastName, String phone, String email, String role) {

        Cuser userExists = cuserRepository.findByUsername(username);
        if(userExists!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Password not confirmed");
        Cuser user = new Cuser((int) cuserRepository.count() + 1, username, firstName, lastName, phone, email, bCryptPasswordEncoder.encode(password),role,null,null);
        cuserRepository.save(user);
        return user;
    }

    @Override
    public Cuser loadUserByUsername(String username) {
        return cuserRepository.findByUsername(username);
    }
}
