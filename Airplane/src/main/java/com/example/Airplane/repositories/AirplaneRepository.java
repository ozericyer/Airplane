package com.example.Airplane.repositories;

import com.example.Airplane.models.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
}