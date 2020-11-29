package com.task.event.userservice;

import java.util.List;

import com.task.event.util.VenuesSearch;

public interface UserService {

	public List<Object[]> getALLUsersByDate(VenuesSearch search);

}
