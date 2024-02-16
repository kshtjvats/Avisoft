package Rs;

class Flight {
    private String flightNumber,departureCity,destinationCity;
    private int availableSeats;
    Flight(String flightNumber,String departureCity,String destinationCity,int availableSeats)
    {
        this.flightNumber=flightNumber;
        this.departureCity=departureCity;
        this.destinationCity=destinationCity;
        this.availableSeats=availableSeats;
    }
    String getFlightNumber()
    {
        return flightNumber;
    }
    String getDepartureCity()
    {
        return departureCity;
    }
    String getDestinationCity()
    {
        return destinationCity;
    }
    int getAvailableSeats()
    {
        return availableSeats;
    }
    void DisplayDetails()
    {
    System.out.println("*****DETAILS ARE-*****");
    System.out.println("Flight Number : "+getFlightNumber());
    System.out.println("Going From : "+getDepartureCity()+" to : "+getDestinationCity());
    System.out.println("Available Number of seats are :"+getAvailableSeats());
    }
}
