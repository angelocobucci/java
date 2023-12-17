package com.fabric.checkfinancial.persistence.repository;

import com.fabric.checkfinancial.persistence.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementsRepo extends JpaRepository<Movement, Long> {

    List<Movement> findByMovType(String movType);

    List<Movement> findByInsertDateTime(LocalDateTime insertDateTime);
}
