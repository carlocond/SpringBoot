package com.esercizio1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techStack;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public boolean equals(Object o) {
        // Controlla se l'oggetto passato è null oppure di un'altra classe
        if (o == null || getClass() != o.getClass()) return false;

        // Fa il cast da Object a SoftwareEngineer per poter accedere ai suoi campi
        SoftwareEngineer that = (SoftwareEngineer) o;

        // Confronta i campi id, name e techStack dei due oggetti
        // Objects.equals gestisce anche i valori null in modo sicuro
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(techStack, that.techStack);
    }

    @Override
    public int hashCode() {
        // Genera un codice hash basato sui campi id, name e techStack
        // Serve per strutture dati come HashMap o HashSet
        return Objects.hash(id, name, techStack);
    }
}
