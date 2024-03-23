package nz.ac.auckland.se281;

public class WeddingVenue {

  private String Venue_Name;
  private String Venue_Code;
  private String Venue_Capacity;
  private String Venue_Hire_Fee;

  public WeddingVenue(
      String Venue_Name, String Venue_Code, String Venue_Capacity, String Venue_Hire_Fee) {

    this.Venue_Name = Venue_Name;
    this.Venue_Code = Venue_Code;
    this.Venue_Capacity = Venue_Capacity;
    this.Venue_Hire_Fee = Venue_Hire_Fee;
  }

  public String get_Venue_Name() {

    return Venue_Name;
  }

  public String get_Venue_Code() {

    return Venue_Code;
  }

  public String get_Venue_Capacity() {

    return Venue_Capacity;
  }

  public String get_Venue_Hire_Fee() {

    return Venue_Hire_Fee;
  }
}
