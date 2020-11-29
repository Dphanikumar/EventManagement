package com.task.event.util;

import java.util.List;

import com.task.event.entity.User;

public class VenueMappers {

	private String date;
	private List<VenueDetails> venueDetails;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<VenueDetails> getVenueDetails() {
		return venueDetails;
	}

	public void setVenueDetails(List<VenueDetails> venueDetails) {
		this.venueDetails = venueDetails;
	}

	@Override
	public String toString() {
		return "VenueMappers [date=" + date + ", venueDetails=" + venueDetails + "]";
	}

}
