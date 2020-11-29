package com.task.event.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.event.entity.Venue;

@Repository
public interface VenueDAO extends JpaRepository<Venue, Long> {

	String QUERY = "select ven.date,ven.id  from venue ven "
			+ " where ven.date between ?1 and ?2 order by ven.date asc";
	String USERQUERY = "select * from user_venues_table tab  where tab.venues_list_id=?1";

	@Query(nativeQuery = true, value = QUERY)
	public List<Object[]> fetchVenuesBasedOnDates(String startDate, String endDate);

	@Query(nativeQuery = true, value = USERQUERY)
	public List<Object[]> fetchUsersByVenue(Long id);

}
