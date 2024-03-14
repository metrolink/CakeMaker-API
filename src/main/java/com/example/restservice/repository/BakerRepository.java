package com.example.restservice.repository;

import com.example.restservice.entities.Baker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BakerRepository extends JpaRepository<Baker, Long> {

    @Query("select b from Baker b where b.name=:name")
    public Baker findByBaker(String name);
}
