package com.example.Airplane.services;

import com.example.Airplane.models.Airplane;
import com.example.Airplane.models.Airport;
import com.example.Airplane.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    public Airport saveAirport(Airport airport) {

        if(airport.getId() != 0 && airport.getName() != null) {
            if(!airportRepository.existsById(airport.getId())) {
                return airportRepository.save(airport);
            }else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Airport is already exist");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Airport does not have necessary attribute");
        }
    }

    public Iterable<Airport> getAllAirports() {

        return airportRepository.findAll();
    }

    public Airport updateAirport(Airport airport) {
        if(airport.getId() != 0 && airport.getName() != null) {
            if(airportRepository.existsById(airport.getId())) {
                return airportRepository.save(airport);
            }else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Airport Id does not match to update");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Airport is not found");
        }
    }

    public Optional<Airport> deleteAirportById(int id) {

        if (airportRepository.existsById(id)) {
            Optional<Airport> deletedAirport = airportRepository.findById(id);
            airportRepository.deleteById(id);
            return deletedAirport;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airplane is not found");
        }
    }
}
