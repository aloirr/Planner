package com.br.aloi.planner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.aloi.planner.model.GenericModel;

@Repository
public interface ModelRepository extends JpaRepository<GenericModel, Integer> {
}