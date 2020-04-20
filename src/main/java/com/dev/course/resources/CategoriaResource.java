package com.dev.course.resources;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.course.domain.Category;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listar() {
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(2, "Escritório");
		
		List<Category> list = Arrays.asList(cat1, cat2);
		return list;
	}
}
