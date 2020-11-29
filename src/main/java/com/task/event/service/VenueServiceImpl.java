package com.task.event.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.event.dao.VenueDAO;
import com.task.event.entity.User;
import com.task.event.entity.Venue;
import com.task.event.userdao.UserDAO;
import com.task.event.util.VenueDetails;
import com.task.event.util.VenueMappers;
import com.task.event.util.VenuesSearch;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDAO dao;

	@Autowired
	private UserDAO userDao;

	@Override
	public Venue saveVenue(Venue event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VenueMappers> getAllVenuesByDates(VenuesSearch search) {

		List<Object[]> fetchVenuesBasedOnDates = dao.fetchVenuesBasedOnDates(search.getStartDate(),
				search.getEndDate());
		Map<String, String> map = new LinkedHashMap<>();
		for (Object[] obj : fetchVenuesBasedOnDates) {
			String date = obj[0] + "";
			String value = obj[1] + "";
			if (map.containsKey(date)) {
				map.put(date, map.get(date) + "," + value);
			} else {
				map.put(date, value);
			}

		}
		System.out.println(map);
		List<VenueMappers> mappersList = new LinkedList<>();

		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			VenueMappers mapper = new VenueMappers();
			mapper.setDate(next.getKey());
			List<VenueDetails> venueList = new LinkedList<>();

			String value = next.getValue();
			if (value != null && !value.isEmpty()) {
				String[] split = value.split(",");
				if (split != null && split.length > 0) {
					for (String str : split) {
						venueList.add(getVenueDetails(dao.getOne(Long.valueOf(str))));
					}
				} else {
					venueList.add(getVenueDetails(dao.getOne(Long.valueOf(value))));

				}

			}
			mapper.setVenueDetails(venueList);
			mappersList.add(mapper);
		}

		for (VenueMappers mapper : mappersList) {
			System.out.println(mapper.getDate());
			System.out.println(mapper.getVenueDetails());
		}

		return mappersList;
	}

	public VenueDetails getVenueDetails(Venue venue) {
		VenueDetails details = new VenueDetails();
		details.setVenue(venue.getVenue());
		Long id = venue.getId();
		List<Object[]> fetchUsersByVenue = dao.fetchUsersByVenue(id);
		List<User> usersList = new ArrayList<>();
		for (Object[] obj : fetchUsersByVenue) {
			System.out.println(obj[0]);
			usersList.add(userDao.findById(Long.valueOf(obj[0] + "")).get());
		}
		details.setUsers(usersList);

		return details;

	}

}
