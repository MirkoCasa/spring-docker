package com.springdocker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdocker.model.User;
import com.springdocker.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.isPresent() ? optUser.get() : null;
	}
	
	@PutMapping("/")
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("/{id}")
	public User update(@PathVariable Integer id, @RequestBody User user) {
		User userUpdated = null;
		if(userRepository.existsById(id)) {
			userUpdated = userRepository.save(user);
		}
		return userUpdated;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	

}
