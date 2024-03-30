package nz.ac.auckland.se281;

public class Booking {

  private String venueName;
  private String date;
  private String numberOfAtendees;

  public Booking(String venueName, String date, String numberOfAtendees) {

    this.venueName = venueName;
    this.date = date;
    this.numberOfAtendees = numberOfAtendees;
  }

  public String getVenueName() {

    return venueName;
  }

  public String getBookingDate() {

    return date;
  }

  public String getNumberOfAtendees() {

    return numberOfAtendees;
  }
}
