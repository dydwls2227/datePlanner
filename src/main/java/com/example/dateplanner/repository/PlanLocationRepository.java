package com.example.dateplanner.repository;

import com.example.dateplanner.domain.PlanLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanLocationRepository extends JpaRepository<PlanLocation, Long> {
}