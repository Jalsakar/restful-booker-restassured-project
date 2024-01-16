package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    private String additionalneeds;

    private HashMap<String, Object> bookingdates;

    private String checkIn;

    private String checkOut;

//========================================================================================//

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public String getFirstName(String firstname) {
        return this.firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public int getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalprice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositpaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

    public HashMap<String, Object> getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HashMap<String, Object> bookingdates) {
        this.bookingdates = bookingdates;
    }

}
