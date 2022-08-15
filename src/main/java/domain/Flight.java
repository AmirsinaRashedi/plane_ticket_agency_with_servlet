package domain;

import base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name = Flight.TABLE_NAME)
@Where(clause = "availableSeats > 0")
public class Flight extends BaseEntity<Long> {

    public static final String TABLE_NAME = "flights";

    private String origin;

    private String destination;

    private LocalDateTime departureTime;

    private int availableSeats;

    private int price;

    @ManyToOne
    private Airline airline;

    public Flight() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void fillOneSeat() {
        availableSeats--;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {

        return "Origin: " + origin
                + " Destination: " + destination
                + " price: " + price
                + " Available seats: " + availableSeats
                + "Airline: " + airline;

    }

}
