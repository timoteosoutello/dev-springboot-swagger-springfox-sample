package com.github.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.model.Payload;

public interface PayloadRepository extends JpaRepository<Payload, UUID> {

}
