package com.dev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.course.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
