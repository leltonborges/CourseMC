package com.dev.course;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.course.domain.Address;
import com.dev.course.domain.Category;
import com.dev.course.domain.City;
import com.dev.course.domain.Client;
import com.dev.course.domain.ItemRequest;
import com.dev.course.domain.Payment;
import com.dev.course.domain.PaymentCard;
import com.dev.course.domain.PaymentWithBoleto;
import com.dev.course.domain.Product;
import com.dev.course.domain.Request;
import com.dev.course.domain.State;
import com.dev.course.domain.enums.StatusPayment;
import com.dev.course.domain.enums.TypeClient;
import com.dev.course.repositories.AddressRepository;
import com.dev.course.repositories.CategoryRepository;
import com.dev.course.repositories.CityRepository;
import com.dev.course.repositories.ClientRepository;
import com.dev.course.repositories.ItemRequestRepository;
import com.dev.course.repositories.PaymentRepository;
import com.dev.course.repositories.ProductRepository;
import com.dev.course.repositories.RequestRepository;
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
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ItemRequestRepository itemRequestRepository;
	
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Request rq1 = new Request(null, sdf.parse("2019/12/12 11:34"), cli1, add1);
		Request rq2 = new Request(null, sdf.parse("2020/03/17 10:45"), cli1, add2);
		
		Payment pay1 = new PaymentCard(null, StatusPayment.SETTLED, rq1, 3);
		rq1.setPayment(pay1);
		
		Payment pay2 = new PaymentWithBoleto(null,StatusPayment.PENDING, rq2, sdf.parse("2020/01/10 12:30"), null);
		rq2.setPayment(pay2);
		cli1.getRequests().addAll(Arrays.asList(rq1, rq2));
		
		requestRepository.saveAll(Arrays.asList(rq1, rq2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		ItemRequest ir1 = new ItemRequest(rq1, p1, 0.00, 1, 2000.00);
		ItemRequest ir2 = new ItemRequest(rq1, p3, 0.00, 2, 80.00);
		ItemRequest ir3 = new ItemRequest(rq2, p2, 100.00, 1, 800.00);
		
		rq1.getItens().addAll(Arrays.asList(ir1, ir2));
		rq2.getItens().addAll(Arrays.asList(ir3));
		
		p1.getItens().addAll(Arrays.asList(ir1));
		p2.getItens().addAll(Arrays.asList(ir3));
		p3.getItens().addAll(Arrays.asList(ir2));
		
		itemRequestRepository.saveAll(Arrays.asList(ir1, ir2, ir3));
	}
}