package com.fabrick.checkfinancial.persistence.repository;

import com.fabrick.checkfinancial.persistence.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MovementsRepo extends JpaRepository<Movement, Long> {

    /*List<Movement> findByMovtype(String movtype);*/
    List<Movement> findAll();
}
