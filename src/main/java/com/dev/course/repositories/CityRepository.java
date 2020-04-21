package com.dev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.course.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
