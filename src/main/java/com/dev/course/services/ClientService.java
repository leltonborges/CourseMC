package com.dev.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.course.domain.Client;
import com.dev.course.repositories.ClientRepository;
import com.dev.course.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Not found with id: "+ id + " type: " + Client.class.getSimpleName()));
	}

}
