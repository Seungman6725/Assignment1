package nz.ac.auckland.se281;

public class Floral extends Services {

  public Floral(String cateringTypeName, int cateringTypeCost, String bookingReference) {

    super(cateringTypeName, cateringTypeCost, bookingReference);
  }

  public String getCateringTypeName() {

    return cateringTypeName;
  }

  public int getCateringTypeCost() {

    return cateringTypeCost;
  }

  public String getBookingReference() {

    return bookingReference;
  }
}
