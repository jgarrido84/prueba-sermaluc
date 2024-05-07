package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.PlantillaCargo;

@Repository
public interface PlantillaCargoRepository extends JpaRepository<PlantillaCargo, Long> {

}
