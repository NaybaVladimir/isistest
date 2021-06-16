package org.example.isistest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Position {
    @Id
    private String name;
    private String status; //Действующий или Архивный


    public Position() {
        this.status="Действующий";
    }
}