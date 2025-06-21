package com.sge.service;

import com.sge.model.Administrateur;
import com.sge.model.Etudiant;
import com.sge.model.Personne;
import com.sge.model.Professeur;
import com.sge.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Personne personne = personneRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (personne instanceof Administrateur) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else if (personne instanceof Professeur) {
            authorities.add(new SimpleGrantedAuthority("PROFESSEUR"));
        } else if (personne instanceof Etudiant) {
            authorities.add(new SimpleGrantedAuthority("ETUDIANT"));
        }

        return new org.springframework.security.core.userdetails.User(personne.getEmail(), personne.getPassword(), authorities);
    }
}
