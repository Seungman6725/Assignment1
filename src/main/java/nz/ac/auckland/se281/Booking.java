package nz.ac.auckland.se281;

public class Booking {

  private String venueName;
  private String date;
  private String numberOfAttendees;

  public Booking(String venueName, String date, String numberOfAttendees) {

    this.venueName = venueName;
    this.date = date;
    this.numberOfAttendees = numberOfAttendees;
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
