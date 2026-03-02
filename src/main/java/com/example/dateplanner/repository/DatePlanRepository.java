package com.example.dateplanner.repository;

import com.example.dateplanner.domain.DatePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatePlanRepository extends JpaRepository<DatePlan, Long> {
}
