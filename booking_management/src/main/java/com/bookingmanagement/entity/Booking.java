package com.bookingmanagement.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId; // ID of the user who made the booking

    @Column(nullable = false)
    private Long showId; // ID of the show for which the booking is made

    @Column(nullable = false)
    private LocalDateTime bookingTime;

    @Column(nullable = false)
    private int numberOfSeats;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private String status; // Status (e.g., CONFIRMED, CANCELLED)

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Seat> seats;

	public Booking() {
		super();
	}

	public Booking(Long userId, Long showId, LocalDateTime bookingTime, int numberOfSeats, double totalPrice,
			String status, List<Seat> seats) {
		super();
		this.userId = userId;
		this.showId = showId;
		this.bookingTime = bookingTime;
		this.numberOfSeats = numberOfSeats;
		this.totalPrice = totalPrice;
		this.status = status;
		this.seats = seats;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
    
    
}
