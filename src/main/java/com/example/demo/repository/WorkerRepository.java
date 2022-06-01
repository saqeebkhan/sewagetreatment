package com.example.demo.repository;

import com.example.demo.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Optional<Worker> findById(Long id);
    Optional<List<Worker>> findByState(String state);
    Optional<Worker> findByCity(String city);
}
