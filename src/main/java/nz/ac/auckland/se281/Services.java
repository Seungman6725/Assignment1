package nz.ac.auckland.se281;

public abstract class Services {

  protected String cateringTypeName;
  protected int cateringTypeCost;

  // Constructor for services
  public Services(String cateringTypeName, int cateringTypeCost) {

    this.cateringTypeName = cateringTypeName;
    this.cateringTypeCost = cateringTypeCost;
  }
}
