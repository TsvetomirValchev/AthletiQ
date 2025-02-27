package com.valchev.athletiq.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valchev.athletiq.domain.dto.ExerciseDTO;
import com.valchev.athletiq.domain.entity.Exercise;
import com.valchev.athletiq.domain.entity.Workout;
import com.valchev.athletiq.domain.mapper.ExerciseMapper;
import com.valchev.athletiq.repository.ExerciseRepository;
import com.valchev.athletiq.repository.WorkoutRepository;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseMapper exerciseMapper;

    public List<ExerciseDTO> findAll() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exerciseMapper.toDTOs(exercises);
    }

    public Optional<ExerciseDTO> findById(UUID exerciseId) {
        return exerciseRepository.findById(exerciseId).map(exerciseMapper::toDTO);
    }

    public ExerciseDTO save(ExerciseDTO exerciseDTO) {
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);

        if (exerciseDTO.getWorkoutId() != null) {
            Optional<Workout> workout = workoutRepository.findById(exerciseDTO.getWorkoutId());
            workout.ifPresent(exercise::setWorkout);
        }

        Exercise savedExercise = exerciseRepository.save(exercise);
        return exerciseMapper.toDTO(savedExercise);
    }

    public void deleteById(UUID exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }


    public List<Exercise> getExercisesByIds(List<UUID> exerciseIds) {
        return exerciseIds.stream()
                .map(exerciseRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
