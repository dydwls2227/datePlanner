package com.example.dateplanner.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "date_plans")
public class DatePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // 예: "강남역 10만원 가성비 데이트"

    private LocalDate planDate; // 데이트 날짜

    private Integer totalBudget; // 총 예산

    private String theme; // 분위기 테마 (예: "조용한", "활동적인")

    // 하나의 데이트 플랜 안에는 여러 개의 장소(식당, 카페 등)가 들어갑니다. (1:N 관계)
    @OneToMany(mappedBy = "datePlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanLocation> locations = new ArrayList<>();

    @Builder
    public DatePlan(String title, LocalDate planDate, Integer totalBudget, String theme) {
        this.title = title;
        this.planDate = planDate;
        this.totalBudget = totalBudget;
        this.theme = theme;
    }

    // 장소 추가 편의 메서드
    public void addLocation(PlanLocation location) {
        locations.add(location);
        location.setDatePlan(this);
    }
}