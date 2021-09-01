package com.example.Airplane.repositories;

import com.example.Airplane.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Integer> {
}
