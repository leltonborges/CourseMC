package com.dev.course;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.course.domain.Address;
import com.dev.course.domain.Category;
import com.dev.course.domain.City;
import com.dev.course.domain.Client;
import com.dev.course.domain.Product;
import com.dev.course.domain.State;
import com.dev.course.domain.enums.TypeClient;
import com.dev.course.repositories.AddressRepository;
import com.dev.course.repositories.CategoryRepository;
import com.dev.course.repositories.CityRepository;
import com.dev.course.repositories.ClientRepository;
import com.dev.course.repositories.ProductRepository;
import com.dev.course.repositories.StateRepository;

@SpringBootApplication
public class CoursoMcApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired 
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São paulo");
		
		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	
		Client cli1 = new Client(null, "Amanda", "amanda@gmail.com", "097.560.864-08", TypeClient.PESSOA_FISICA);
		cli1.getPhones().addAll(Arrays.asList("86464-4646","94654-5512"));
		
		Address add1 = new Address(null, "Rua Lores", "300", "Apto 302", "Jardim", "8465-786", cli1, c1);
		Address add2 = new Address(null, "Avenida Matos", "105", "Sala 808", "Centro", "3168-653", cli1, c2);
		
//		cli1.getAddresses().addAll(Arrays.asList(add1, add2));
		clientRepository.saveAll(Arrays.asList(cli1));
		
		addressRepository.saveAll(Arrays.asList(add1, add2));
		
	}
}