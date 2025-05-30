package com.valchev.athletiq.domain.dto;

import com.valchev.athletiq.domain.entity.SetType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ExerciseSetDTO {

    private UUID exerciseSetId;
    private UUID exerciseId;
    private Integer orderPosition;
    private Integer reps;
    private Double weight;
    private Integer restTimeSeconds;
    private SetType type;
    private Boolean completed;

}