package com.example.Airplane.controller;
import com.example.Airplane.models.Airplane;
import com.example.Airplane.services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("api/airplane/")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;
    @GetMapping()
    public ResponseEntity getAirplanes() {

        Iterable<Airplane> airplanes = airplaneService.getAllAirplanes();
        return new ResponseEntity(airplanes, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity saveAirplane(@RequestBody Airplane airplane) {

        Airplane createdAirplane = airplaneService.saveAirplane(airplane);
        return new ResponseEntity(createdAirplane, HttpStatus.OK);
    }
    @PutMapping("update/")
    public ResponseEntity updateAirplane(@RequestBody Airplane airplane) {

        Airplane updatedAirplane = airplaneService.updateAirplane(airplane);
        return new ResponseEntity(updatedAirplane, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deletedAirplaneById(@PathVariable int id) {

        Optional<Airplane> deletedAirplane =  airplaneService.deleteAirplaneById(id);
        return new ResponseEntity(deletedAirplane, HttpStatus.OK);
    }
}
