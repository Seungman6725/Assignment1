package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;




public class VenueHireSystem {

  ArrayList<WeddingVenue> venueList = new ArrayList<>();

  int numberOfVenues = 0;

  public VenueHireSystem() {}

  public void printVenues() {
    
    switch(numberOfVenues){

      case 0:
        System.out.println("There are no venues in the system. Please create a venue first.");
        break;
      
      case 1:
        System.out.println("There is one venue in the system:");
        MessageCli.VENUE_ENTRY.printMessage()

    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    if(venueName.isEmpty()){

      System.out.println("Venue not created: venue name must not be empty.");
      
    }

    for (WeddingVenue venue: venueList){

      if ((venue.get_Venue_Code()).equals(venueCode)){

        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage();
      }
    }


     
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
