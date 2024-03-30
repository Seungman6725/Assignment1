package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<WeddingVenue> venueList = new ArrayList<>();
  private ArrayList<Booking> bookingList = new ArrayList<>();
  private int numberOfVenues = 0;
  private String systemDate = "";

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

    systemDate = dateInput;

    MessageCli.DATE_SET.printMessage(systemDate);
  }

  public void printSystemDate() {

    // If system date has not been set, print according message.
    if (systemDate.isEmpty()) {

      MessageCli.CURRENT_DATE.printMessage("not set");

    } else {

      MessageCli.CURRENT_DATE.printMessage(systemDate);
    }
  }

  public void makeBooking(String[] options) {

    // If the system date has not been set.
    if (systemDate.isEmpty()) {

      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();

      return;

      // If there are no venues created
    } else if (numberOfVenues == 0) {

      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();

      return;
    }

    // Initialise boolean flag for check
    boolean venueCodeFound = false;

    // If the venue code exists save it to variable and exit the for loop
    for (WeddingVenue venue : venueList) {

      if (venue.getVenueCode().equals(options[0])) {

        venueCodeFound = true;
        break;
      }
    }

    // If venue code doesn't exist, print corresponding message
    if (!venueCodeFound) {

      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);

      return;
    }

    // Check for if the inputted date is in the past

    // Split both inputted and system dates in to days,month, and year
    String[] inputDateParts = options[1].split("/");
    String[] systemDateParts = systemDate.split("/");

    // Convert both arrays so values contained are integers
    int[] intInputDateParts = new int[inputDateParts.length];
    int[] intSystemDateParts = new int[systemDateParts.length];

    for (int i = 0; i < intInputDateParts.length; i++) {

      intInputDateParts[i] = Integer.parseInt(inputDateParts[i]);
    }

    for (int i = 0; i < intSystemDateParts.length; i++) {

      intSystemDateParts[i] = Integer.parseInt(systemDateParts[i]);
    }

    // If any part of the inputted dates are lower than the system date, print according message
    if ((intInputDateParts[0] < intSystemDateParts[0])
        || (intInputDateParts[1] < intSystemDateParts[1])
        || (intInputDateParts[2] < intSystemDateParts[2])) {

      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);

      return;
    }

    // After passing all checks, add booking to arraylist and print according message

    // Find venue name according to inputted venue code
    String venueName = "";

    for (WeddingVenue venue : venueList) {

      if (venue.getVenueCode().equals(options[0])) {

        venueName = venue.getVenueName();
      }
    }

    bookingList.add(new Booking(venueName, options[1], options[3]));

    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        BookingReferenceGenerator.generateBookingReference(), venueName, options[1], options[3]);
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
