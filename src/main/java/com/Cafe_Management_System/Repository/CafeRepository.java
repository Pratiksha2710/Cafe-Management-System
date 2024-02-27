package com.Cafe_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cafe_Management_System.Model.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
