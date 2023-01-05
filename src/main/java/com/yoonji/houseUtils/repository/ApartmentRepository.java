package com.yoonji.houseUtils.repository;

import com.yoonji.houseUtils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
