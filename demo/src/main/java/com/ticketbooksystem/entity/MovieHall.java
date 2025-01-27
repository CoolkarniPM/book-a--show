package com.ticketbooksystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    
    @OneToMany(mappedBy = "movieHall", cascade = CascadeType.ALL)
    private List<Show> shows;
    
    public MovieHall() {
		super();
	}
    
    
	public MovieHall(Long id, String name, String location, List<Show> shows) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.shows = shows;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

    // Getters and Setters
}

