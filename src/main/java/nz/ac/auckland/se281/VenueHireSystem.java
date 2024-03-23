package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;




public class VenueHireSystem {

  ArrayList<WeddingVenue> venueList = new ArrayList<>();

  int numberOfVenues = 0;

  

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

    //If the venue name is empty
    if(venueName.isEmpty()){

      System.out.println("Venue not created: venue name must not be empty.");

      return;
    }
    
    //If there are two instances of the same venue code in the system
    for (WeddingVenue venue: venueList){

      if ((venue.get_Venue_Code()).equals(venueCode)){

        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venue.get_Venue_Code(),venue.get_Venue_Name());
        
        return;
      }

    }

    //If the capacity isnt a whole integer, isnt negative, isnt zero
    try {
      
      int int_venue_capacity = Integer.parseInt(capacityInput);

      if(int_venue_capacity <= 0){

        System.out.println("Venue not created: capacity must be a positive number.");

        return;
      }

    }catch (Exception e){
      
      System.out.println("Venue not created: capacity must be a number.");

      return;
    }

    //If the hire fee isnt a whole integer, isnt negative, isnt zero
    try {
      
      int int_venue_hire_fee = Integer.parseInt(hireFeeInput);

      if(int_venue_hire_fee <= 0){

        System.out.println("Venue not created: hire fee must be a positive number.");

        return;
      }

    }catch (Exception e){
      
      System.out.println("Venue not created: hire fee must be a number.");

      return;
    }

    //If none of these conditions are met add to arraylist

    venueList.add(new WeddingVenue(venueName,venueCode,capacityInput,hireFeeInput));

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
