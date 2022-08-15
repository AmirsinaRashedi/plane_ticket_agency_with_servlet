package domain;

import base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Ticket.TABLE_NAME)
public class Ticket extends BaseEntity<Long> {

    public static final String TABLE_NAME = "ticket";

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    public Ticket() {
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {

        return passenger.toString()
                + "   "
                + flight.toString();

    }
}
