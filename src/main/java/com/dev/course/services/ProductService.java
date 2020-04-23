package com.dev.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.course.domain.Product;
import com.dev.course.repositories.ProductRepository;
import com.dev.course.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product findById(Integer id) {
		Optional<Product> prod = repo.findById(id);
		return prod.orElseThrow(() -> new ObjectNotFoundException("Not found id: "+id +" type: "+ Product.class.getSimpleName()));
	}
}
