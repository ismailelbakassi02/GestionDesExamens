package com.sge.view;

import com.sge.model.Etudiant;
import com.sge.repository.EtudiantRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
@Getter
@Setter
public class AuthController implements Serializable {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String email;
    private String password;
    private Etudiant etudiant = new Etudiant();

    public String login() {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(this.email, this.password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "/index.xhtml?faces-redirect=true";
        } catch (AuthenticationException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Invalid credentials."));
            return null;
        }
    }

    public String register() {
        try {
            etudiant.setPassword(passwordEncoder.encode(etudiant.getPassword()));
            etudiantRepository.save(etudiant);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Successful", "You can now log in."));
            return "/login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Error", "Email may already be in use."));
            return null;
        }
    }
}
