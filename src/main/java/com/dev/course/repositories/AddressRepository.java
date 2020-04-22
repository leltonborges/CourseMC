package com.dev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.course.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
