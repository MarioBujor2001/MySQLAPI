package com.example.MySQLApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class Persoane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    @Column(name="Nume")
    private  String nume;
    @NotBlank
    @Column(name="Prenume")
    private  String prenume;
    @NotNull
    @Column(name="Varsta")
    private Integer varsta;

    public Persoane(String nume,
                    String prenume,
                    Integer varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public Persoane(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}
