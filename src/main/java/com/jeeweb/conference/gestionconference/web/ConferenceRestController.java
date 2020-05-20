package com.jeeweb.conference.gestionconference.web;

import com.jeeweb.conference.gestionconference.documents.Conference;
import com.jeeweb.conference.gestionconference.documents.Cuser;
import com.jeeweb.conference.gestionconference.documents.Proposition;
import com.jeeweb.conference.gestionconference.repository.ConferenceRepository;
import com.jeeweb.conference.gestionconference.repository.CuserRepository;
import com.jeeweb.conference.gestionconference.repository.PropositionRepository;
import com.jeeweb.conference.gestionconference.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ConferenceRestController {

    @Autowired
    private PropositionRepository propositionRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CuserRepository cuserRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/submitProposition/{idConf}/{idAuthor}")
    @Transactional
    public String submitProposition(@RequestBody SubmissionForm submissionForm,
                                    @PathVariable("idConf") int idconf,
                                    @PathVariable("idAuthor") int idAuthor){
        Proposition proposition = new Proposition((int) propositionRepository.count() + 1,submissionForm.getTitre(),"",false,null,null,null);
        Conference conference = conferenceRepository.findById(idconf).get();
        Cuser author = cuserRepository.findById(idAuthor).get();
        proposition.setConference(conference);
        proposition.setAuthor(author);
        conference.getPropositions().add(proposition);
        author.getPropositions().add(proposition);
        conferenceRepository.save(conference);
        propositionRepository.save(proposition);
        cuserRepository.save(author);
        return "submission registred";
    }

    @PostMapping("/createAuthor")
    @Transactional
    public String createAuthor(@RequestBody AuthorAccountInfoForm author) {
        accountService.saveUser(author.getUsername(),author.getPassword(),author.getConfirmedPassword(),author.getFirst_name(),author.getLast_name(),
                author.getPhone(),author.getEmail(),author.getRole());
     return "author created";
    }

}
@Data
class SubmissionForm {
    private String titre;
}
@Data
class AuthorAccountInfoForm {
    private String first_name;
    private String last_name;
    private String phone;
    private String username;
    private String email;
    private String password;
    private String confirmedPassword;
    private String role;
}
