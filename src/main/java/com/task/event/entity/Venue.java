package com.task.event.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "venue")

public class Venue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venueid_seq")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "venueid_seq", sequenceName = "venueid_sequence")
	private Long id;
	@NotNull(message = "Speaker name must required")
	@NotBlank(message = "Speaker name is must not be blank")
	private String speaker;
	@NotNull(message = "Venue name is must required")
	@NotBlank(message = "venue name is must not be balnk")
	private String venue;
	@NotNull(message = "date must required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	@NotNull(message = "Time must required")
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", speaker=" + speaker + ", venue=" + venue + ", date=" + date + ", time=" + time
				+ "]";
	}

}
