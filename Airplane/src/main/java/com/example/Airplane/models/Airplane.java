package com.example.Airplane.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="airplane")
public class Airplane {
    @Id
    private int id;
    private String type;
    private String plate;
    private int fuel;

    public Airplane() {}

    public Airplane(int id, String type, String plate, int fuel) {
        this.id = id;
        this.type = type;
        this.plate = plate;
        this.fuel = fuel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}