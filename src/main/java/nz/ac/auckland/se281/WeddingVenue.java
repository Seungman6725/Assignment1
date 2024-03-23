package nz.ac.auckland.se281;

public class WeddingVenue {

  private String Venue_Name;
  private int Venue_Code;
  private int Venue_Capacity;
  private int Venue_Hire_Fee;

  public WeddingVenue(String Venue_Name, int Venue_Code, int Venue_Capacity, int Venue_Hire_Fee) {

    this.Venue_Name = Venue_Name;
    this.Venue_Code = Venue_Code;
    this.Venue_Capacity = Venue_Capacity;
    this.Venue_Hire_Fee = Venue_Hire_Fee;
  }

  public int get_Venue_Code() {

    return Venue_Code;
  }

  public String get_Venue_Name() {

    return Venue_Name;
  }

  public int get_Venue_Capacity() {

    return Venue_Capacity;
  }

  public int get_Venue_Hire_Fee() {

    return Venue_Hire_Fee;
  }
}
