package com.example.dateplanner.service;

import com.example.dateplanner.domain.DatePlan;
import com.example.dateplanner.domain.PlanLocation;
import com.example.dateplanner.repository.DatePlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatePlanService {

    private final DatePlanRepository datePlanRepository;

    // AI가 생성한 데이트 플랜과 장소들을 통째로 묶어서 저장하는 메서드
    @Transactional
    public Long savePlanWithLocations(DatePlan plan, List<PlanLocation> locations) {

        // 데이트 플랜에 장소들을 차례대로 추가합니다.
        for (PlanLocation location : locations) {
            plan.addLocation(location);
        }

        DatePlan savedPlan = datePlanRepository.save(plan);

        return savedPlan.getId();
    }
}