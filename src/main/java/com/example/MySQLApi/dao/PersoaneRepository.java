package com.example.MySQLApi.dao;

import com.example.MySQLApi.model.Persoane;
import org.springframework.data.repository.CrudRepository;

public interface PersoaneRepository extends CrudRepository<Persoane, Integer> {
}
