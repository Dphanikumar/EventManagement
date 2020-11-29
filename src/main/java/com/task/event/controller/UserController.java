package com.task.event.controller;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.event.entity.User;
import com.task.event.userdao.UserDAO;
import com.task.event.userservice.UserService;
import com.task.event.util.VenuesSearch;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDAO dao;

	@Autowired
	private UserService service;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		try {
			if (user.getReservedDate() == null)
				user.setReservedDate(LocalDate.now());
			User savedUser = dao.save(user);
			if (Objects.nonNull(savedUser)) {
				return new ResponseEntity<Object>(savedUser, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY);
		}

	}

	@GetMapping(value = "/search")
	public ResponseEntity<Object> getAllUsers() {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/searchByDates")
	public ResponseEntity<Object> getAllVenuesByDates(@RequestBody VenuesSearch search) {
		return new ResponseEntity<>(service.getALLUsersByDate(search), HttpStatus.OK);
	}

}
