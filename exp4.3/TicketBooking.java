package exp43;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10); // 10 seats available
        Random random = new Random();

        // Creating booking threads (some VIP and some normal)
        List<BookingThread> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            threads.add(new BookingThread(system, random.nextInt(10), "VIP_Customer_" + i, Thread.MAX_PRIORITY));
            threads.add(new BookingThread(system, random.nextInt(10), "Normal_Customer_" + i, Thread.MIN_PRIORITY));
        }

        // Start all threads
        threads.forEach(Thread::start);

        // Wait for all threads to finish
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\nAll bookings are completed!");
    }
}
