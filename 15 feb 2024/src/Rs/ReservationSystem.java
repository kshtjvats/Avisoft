package Rs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class ReservationSystem {
    Scanner sc = new Scanner(System.in).useDelimiter("[,\\s]");
    List<Flight> flights = new ArrayList<>();
    Set<String> flightNumberSet = new HashSet<>();

    void addFlight() throws NegativeSeatNumberException {
        try {
            System.out.println("Enter Flight number:");
            String flightNumber = sc.next();
            if (!flightNumberSet.contains(flightNumber)) {
                flightNumberSet.add(flightNumber);
                System.out.println("Enter Departure City:");
                String departureCity = sc.next();
                System.out.println("Enter Destination City:");
                String destinationCity = sc.next();
                System.out.println("Enter number of seats:");
                int sn = sc.nextInt();
                if (sn < 0)
                    throw new NegativeSeatNumberException("Invalid entry");
                else {
                    flights.add(new Flight(flightNumber, departureCity, destinationCity, sn));
                }
            } else
                System.out.println("Flight already exists.");
        } catch (InputMismatchException e) {
            System.err.println("Invalid entry. Please try again.");
            sc.nextLine();
            addFlight();
        }
    }

    void searchFlight() throws NoFlightPresentException {
        System.out.println("Enter Flight number:");
        String fNo = sc.next();
        if (!flightNumberSet.contains(fNo))
            throw new NoFlightPresentException("Flight Data not present");
        else {
            int i = 0;
            for (i = 0; i < flights.size(); i++) {
                if (flights.get(i).getFlightNumber().equals(fNo))
                    break;
            }
            flights.get(i).DisplayDetails();
        }
    }
}
