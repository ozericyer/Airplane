package com.example.Airplane.models;
import javax.persistence.*;
@Entity
@Table(name="airport")
public class Airport {
    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;
    public Airport() {}
    public Airport(int id, String name, Airplane airplane) {
        this.id = id;
        this.name = name;
        this.airplane = airplane;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
