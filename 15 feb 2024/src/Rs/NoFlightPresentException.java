package Rs;

class NoFlightPresentException extends ReservationException {
    NoFlightPresentException(String message)
    {
        super(message);
    }
}
