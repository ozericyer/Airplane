package com.example.Airplane.services;

import com.example.Airplane.models.Airplane;
import com.example.Airplane.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    public Iterable<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Airplane saveAirplane(Airplane airplane) {

        if (airplane.getId() != 0 && airplane.getPlate() != null ) {
            if (!airplaneRepository.existsById(airplane.getId())) {
                return airplaneRepository.save(airplane);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Airplane is already exist");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Airplane does not have necessary attribute");
        }
    }

    public Airplane updateAirplane(Airplane airplane) {

        if (airplane.getId() != 0 && airplane.getPlate() != null ) {
            if (airplaneRepository.existsById(airplane.getId())) {
                return airplaneRepository.save(airplane);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Airplane Id does not match to update");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Airplane is not found");
        }
    }

    public Optional<Airplane> deleteAirplaneById(int id) {

        if (airplaneRepository.existsById(id)) {
            Optional<Airplane> deletedAirplane = airplaneRepository.findById(id);
            airplaneRepository.deleteById(id);
            return deletedAirplane;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airplane is not found");
        }
    }
}