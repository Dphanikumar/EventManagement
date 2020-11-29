package com.task.event.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity(name = "venueuser")

@Data
public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Seq")
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "user_Seq", sequenceName = "user_sequence")
	private Long id;
	@ManyToMany
	@JoinTable(name = "user_venuesTable")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Venue> venuesList;
	@CreatedDate
	private LocalDate reservedDate;

	private String eventName;


}
