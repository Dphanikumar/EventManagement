package com.task.event.userservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.event.userdao.UserDAO;
import com.task.event.util.VenuesSearch;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public List<Object[]> getALLUsersByDate(VenuesSearch search) {
		List<Object[]> venueUserByDates = dao.getVenueUserByDates(search.getStartDate(), search.getEndDate());

		for (Object[] obj : venueUserByDates) {
			System.out.println(Arrays.toString(obj));
		}

		return venueUserByDates;

	}

}
