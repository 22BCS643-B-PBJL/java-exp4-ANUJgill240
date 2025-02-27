package exp43;
import java.util.*;
public class TicketBookingSystem {
    private final boolean[] seats; // true = booked, false = available

    public TicketBookingSystem(int totalSeats) {
        seats = new boolean[totalSeats];
    }

    public synchronized boolean bookSeat(int seatNumber, String customerName) {
        if (seatNumber < 0 || seatNumber >= seats.length || seats[seatNumber]) {
            System.out.println(customerName + " tried to book seat " + seatNumber + " but it's already booked!");
            return false;
        }
        seats[seatNumber] = true;
        System.out.println(customerName + " successfully booked seat " + seatNumber);
        return true;
    }
}
