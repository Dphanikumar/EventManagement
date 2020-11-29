package com.task.event.util;

import java.util.List;

import com.task.event.entity.User;

public class VenueDetails {

	private String eventname;
	private String venue;
	private List<User> users;

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "VenueDetails [eventname=" + eventname + ", venue=" + venue + ", users=" + users + "]";
	}
	
	

}
