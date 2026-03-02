package com.example.dateplanner.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "plan_location")
public class PlanLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private DatePlan datePlan;

    @Column(nullable = false)
    private String placeName;

    private String category;

    private Integer sequence;

    private Integer estimatedCost;

    @Builder
    public PlanLocation(String placeName, String category, Integer sequence, Integer estimatedCost) {
        this.placeName = placeName;
        this.category = category;
        this.sequence = sequence;
        this.estimatedCost = estimatedCost;
    }

    // 연관관계 편의 메서드를 위한 Setter (DatePlan에서 호출됨)
    protected void setDatePlan(DatePlan datePlan) {
        this.datePlan = datePlan;
    }
}

