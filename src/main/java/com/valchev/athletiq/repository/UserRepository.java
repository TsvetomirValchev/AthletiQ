package com.valchev.athletiq.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valchev.athletiq.domain.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}
