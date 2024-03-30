package nz.ac.auckland.se281;

public class Booking {

  private String date;
  private String bookingReference;
  private String venueName;
  private String numberOfAtendees;

  public Booking(String date, String bookingReference, String venueName, String numberOfAtendees) {

    this.date = date;
    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.numberOfAtendees = numberOfAtendees;
  }

  public String getBookingDate() {

    return date;
  }

  public String getBookingReference() {

    return bookingReference;
  }

  public String getVenueName() {

    return venueName;
  }

  public String getNumberOfAtendees() {

    return numberOfAtendees;
  }
}
