import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package majorprogramtwo;

/**
 * Customer.java
 *
 * @author kailabillie GEEN 165 Section 2 October 28. 2015 Function: Keeps track
 * of the properties of engine
 */
public class Customer {

    private String name;
    private String arrivalDate;
    private String departureDate;
    private long totalCharge; 
    private boolean safe;

    //no arg constructor that sets all the properties to their default value
    public Customer() {
        name = "";
        arrivalDate = "";   
        departureDate = "";
        totalCharge = 0;
        
    }

    //constructor that takes all the fields as a parameter and sets the fields to the parameters
    public Customer(String name, String arrivalDate, String departureDate, int dayCharge, boolean safe) {
        super();
        this.name = name;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.totalCharge = dayCharge;
        
        DateCost(arrivalDate, departureDate);
        
        if(safe) totalCharge += 20; 
    }

    

    //prints each of the properties on a seperate line as well as the properties from the class that it inherits from
    public String Display() {

        String finalString = "Name: "+getName() + System.lineSeparator() + "Arrival Date: "+getArrivalDate()
                + System.lineSeparator() + "Departure Date: "+getDepartureDate() + System.lineSeparator() + "Total Charge: $"+getTotalCharge()+".00";

        return finalString;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the arrivalDate
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    } 
    
    public void DateCost(String ad, String dd) 
    { 
    	DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	LocalDate arr = LocalDate.parse(ad, format);
    	LocalDate dep = LocalDate.parse(dd, format);
    	
    	totalCharge *= ChronoUnit.DAYS.between(arr, dep);
    }

    /**
     * @return the totalCharge
     */
    public long getTotalCharge() {
        return totalCharge;
    }

    /**
     * @param totalCharge the totalCharge to set
     */
    public void setTotalCharge(int totalCharge) {
        this.totalCharge = totalCharge;
    }

}
