package com.dev.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.course.domain.Request;
import com.dev.course.repositories.RequestRepository;
import com.dev.course.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {
	@Autowired
	private RequestRepository repo;

	public Request findById(Integer id) {
		Optional<Request> req = repo.findById(id);
		return req.orElseThrow(
				() -> new ObjectNotFoundException("Not found id: " + id + " type: " + Request.class.getSimpleName()));
	}

}
