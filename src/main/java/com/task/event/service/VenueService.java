package com.task.event.service;

import java.util.List;

import com.task.event.entity.Venue;
import com.task.event.util.VenueMappers;
import com.task.event.util.VenuesSearch;

public interface VenueService {

	Venue saveVenue(Venue event);

	List<VenueMappers> getAllVenuesByDates(VenuesSearch search);

}
