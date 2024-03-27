package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<WeddingVenue> venueList = new ArrayList<>();

  private int numberOfVenues = 0;

  // A method to convert the number of venues to words when the number of venues if from
  // 2 to 9.
  public String intToWord(int numberOfVenues) {

    switch (numberOfVenues) {
      case 2:
        return "two";

      case 3:
        return "three";

      case 4:
        return "four";

      case 5:
        return "five";

      case 6:
        return "six";

      case 7:
        return "seven";

      case 8:
        return "eight";

      case 9:
        return "nine";

      default:
        return "Invalid number";
    }
  }

  public void printVenues() {

    switch (numberOfVenues) {
      case 0:
        MessageCli.NO_VENUES.printMessage();
        break;

      case 1:
        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
        MessageCli.VENUE_ENTRY.printMessage(
            venueList.get(0).getVenueName(),
            venueList.get(0).getVenueCode(),
            venueList.get(0).getVenueCapacity(),
            venueList.get(0).getVenueHireFee(),
            "TODO");
        break;
    }

    // When the number of venues is > 1 but < 10
    if (numberOfVenues > 1 && numberOfVenues < 10) {

      MessageCli.NUMBER_VENUES.printMessage("are", intToWord(numberOfVenues), "s");

      for (WeddingVenue venue : venueList) {

        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getVenueCapacity(),
            venue.getVenueHireFee(),
            "TODO");
      }
    }

    // When the number of venues is 10 or more
    else if (numberOfVenues >= 10) {

      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(numberOfVenues), "s");

      for (WeddingVenue venue : venueList) {

        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getVenueCapacity(),
            venue.getVenueHireFee(),
            "TODO");
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // If the venue name is empty
    if (venueName.isEmpty()) {

      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // If there are two instances of the same venue code in the system
    for (WeddingVenue venue : venueList) {

      if ((venue.getVenueCode()).equals(venueCode)) {

        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
            venue.getVenueCode(), venue.getVenueName());

        return;
      }
    }

    // If the capacity isnt a whole integer, isnt negative, isnt zero
    try {

      int intVenueCapacity = Integer.parseInt(capacityInput);

      if (intVenueCapacity <= 0) {

        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }

    } catch (Exception e) {

      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    // If the hire fee isnt a whole integer, isnt negative, isnt zero
    try {

      int intVenueHireFee = Integer.parseInt(hireFeeInput);

      if (intVenueHireFee <= 0) {

        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }

    } catch (Exception e) {

      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    // If none of these conditions are met, add to arraylist
    venueList.add(new WeddingVenue(venueName, venueCode, capacityInput, hireFeeInput));

    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);

    numberOfVenues++;
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
