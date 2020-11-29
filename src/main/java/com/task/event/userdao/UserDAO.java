package com.task.event.userdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.event.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	String QUERY = "select vUser.reserved_date,vUser.id " + " from venueuser vUser  \r\n"
			+ "where reserved_date between ?1 and ?2 order by vUser.reserved_date desc";

	@Query(nativeQuery = true, value = QUERY)
	public List<Object[]> getVenueUserByDates(String startData, String endDate);

}
