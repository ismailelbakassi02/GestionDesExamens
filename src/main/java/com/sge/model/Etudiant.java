package com.sge.model;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
=======
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

>>>>>>> 8ecbe6009a04f5d74624a17d461e3aa0b0cd7da1
import java.util.List;
import java.util.Objects;

@Entity
<<<<<<< HEAD
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String cne; // Code National de l'Étudiant
    private String filiere;

    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> inscriptions;

    // Constructors
    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String email, String cne, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cne = cne;
        this.filiere = filiere;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(id, etudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", cne='" + cne + '\'' +
                ", filiere='" + filiere + '\'' +
                '}';
    }
}
=======
@Getter
@Setter
public class Etudiant extends Personne {

    private String numeroEtudiant;
    private String groupe;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "etudiant")
    private List<Note> notes;

    @OneToMany(mappedBy = "etudiant")
    private List<Reclamation> reclamations;
}
>>>>>>> 8ecbe6009a04f5d74624a17d461e3aa0b0cd7da1
