package com.joaodavid.springmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodavid.springmongodb.domain.User;
import com.joaodavid.springmongodb.dto.UserDTO;
import com.joaodavid.springmongodb.repository.UserRepository;
import com.joaodavid.springmongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado!!"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(),obj.getEmail());
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
}
