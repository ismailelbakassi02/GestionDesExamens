package com.sge.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Administrateur extends Personne {

    private String fonction;
    private String departement;
}
