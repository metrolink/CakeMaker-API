package com.example.restservice.repository;

import com.example.restservice.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Long> {

    @Query("select c from Cake c where c.cakeName=:cakeName")
    public Cake findByName(String cakeName);

    //@Query("select ca from Cake where ca.id=:id")
    //public Cake getCakeObject(Long id);
}
