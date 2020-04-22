package com.dev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.course.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{

}
