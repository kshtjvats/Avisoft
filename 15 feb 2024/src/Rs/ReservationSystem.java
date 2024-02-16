package Rs;

import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.Scanner;
class ReservationSystem {
    Scanner sc=new Scanner(System.in).useDelimiter("\n");
    Scanner nc=new Scanner(System.in);
    List<Flight>flights=new ArrayList<Flight>();
    Set<String>FNo=new HashSet<String>();
    void AddFlight() throws NegativeSeatNumberException
    {
    System.out.println("Enter Flight number");
    String fNo=sc.next();
    if(FNo.contains(fNo)==false)
    {
    FNo.add(fNo);
    System.out.println("Enter Departure City");
    String depc=sc.next();
    System.out.println("Enter Destination City");
    String desc=sc.next();
    System.out.println("Enter number of seats");
    int sn=nc.nextInt();
    if(sn<0)
    throw new NegativeSeatNumberException("Invalid entry");
    else
    {
        flights.add(new Flight(fNo, depc, desc, sn));
    }
    }
    else
    System.out.println("Fligh already exists");
    }
    void SearchFlight() throws NoFlightPresentException
    {
        System.out.println("Enter Flight number");
        String fNo=sc.next();
        if(FNo.contains(fNo)==false)
        throw new NoFlightPresentException("Flight Data not present");
        else
        {
            int i=0;
            for(i=0;i<flights.size();i++)
            {
            if(flights.get(i).getFlightNumber()==fNo)
            break;
            }
            flights.get(i).DisplayDetails();
        }
    }
}

