package com.example.Airplane.controller;
import com.example.Airplane.models.Airplane;
import com.example.Airplane.models.Airport;
import com.example.Airplane.services.AirplaneService;
import com.example.Airplane.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("api/airport")
public class AirportController {
    @Autowired
    AirportService airportService;
    @PostMapping()
    public ResponseEntity save(@RequestBody Airport airport) {

        Airport createdAirport = airportService.saveAirport(airport);
        return new ResponseEntity(createdAirport, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity getAirports() {

        Iterable<Airport> airports = airportService.getAllAirports();
        return new ResponseEntity(airports, HttpStatus.OK);
    }
    @PutMapping("update/")
    public ResponseEntity updateAirport(@RequestBody Airport airport) {

        Airport updatedAirport = airportService.updateAirport(airport);
        return new ResponseEntity(updatedAirport, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletedAirportById(@PathVariable int id) {
        Optional<Airport> deletedAirport =  airportService.deleteAirportById(id);
        return new ResponseEntity(deletedAirport, HttpStatus.OK);
    }
}