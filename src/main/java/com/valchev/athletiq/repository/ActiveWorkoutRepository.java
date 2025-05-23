package com.valchev.athletiq.repository;

import com.valchev.athletiq.domain.entity.ActiveWorkout;
import com.valchev.athletiq.domain.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, UUID> {
    List<ActiveWorkout> findByEndTimeIsNull();
    List<ActiveWorkout> findByUser_UserIdAndEndTimeIsNull(UUID userId);


}