package org.example.isistest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bic;

    private String name;

    private String address;

    private String status;//Действующий или Архивный


    public Bank() {
        this.status="Действующий";
    }
}