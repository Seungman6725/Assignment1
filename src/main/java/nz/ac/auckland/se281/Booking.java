package nz.ac.auckland.se281;

public class Booking {

  private String bookingReference;
  private String venueName;
  private String date;
  private String numberOfAttendees;

  public Booking(String bookingReference, String venueName, String date, String numberOfAttendees) {

    this.bookingReference = bookingReference;
    this.venueName = venueName;
    this.date = date;
    this.numberOfAttendees = numberOfAttendees;
  }

  public String getBookingReference() {

    return bookingReference;
  }

  public String getVenueName() {

    return venueName;
  }

  public String getBookingDate() {

    return date;
  }

  public String getNumberOfAtendees() {

    return numberOfAttendees;
  }
}
