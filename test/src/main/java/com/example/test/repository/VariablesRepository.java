package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Variables;

@Repository
public interface VariablesRepository extends JpaRepository<Variables, Long> {

}
