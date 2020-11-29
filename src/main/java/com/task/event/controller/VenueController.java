package com.task.event.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.event.dao.VenueDAO;
import com.task.event.entity.Venue;
import com.task.event.service.VenueService;
import com.task.event.util.VenuesSearch;

@RestController
@RequestMapping(value = "/venue")
public class VenueController {

	@Autowired
	private VenueDAO dao;

	@Autowired
	private VenueService service;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveVenueObject(@RequestBody Venue venue) {
		try {
			if (venue.getDate() == null)
				venue.setDate(LocalDate.now());
			if (venue.getTime() == null)
				venue.setTime(LocalDateTime.now());
			Venue savedVenue = dao.save(venue);
			if (Objects.nonNull(savedVenue)) {
				return new ResponseEntity<Object>(savedVenue, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY);
		}

	}

	@PostMapping(value = "/searchByDates")
	public ResponseEntity<Object> fetchAllDetailsByDates(@RequestBody VenuesSearch search) {
//		dao.fetchVenuesBasedOnDates(search.getStartDate(), search.getEndDate())

		return new ResponseEntity<>(service.getAllVenuesByDates(search), HttpStatus.OK);
	}

}
