package com.dev.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
}
