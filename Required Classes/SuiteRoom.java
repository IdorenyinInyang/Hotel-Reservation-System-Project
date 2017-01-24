
public class SuiteRoom extends StandardRoom {
    
    private static final int startingCost = 180;
    
    //sets each of the properties to its default values
    public SuiteRoom() {
        customer = new Customer();
    }
    
    public SuiteRoom(String name,String arrivalDate, String departureDate, boolean safe) 
	{ 
		customer = new Customer(name, arrivalDate, departureDate, startingCost, safe); 
		customer.DateCost(arrivalDate, departureDate);
	} 
    
    public static int getStartingCost() {
        return startingCost;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
   
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    //allows you to add an customer which is a private property
    public void addCustomer(String name, String arrivalDate, String departureDate) {
        customer.DateCost(arrivalDate, departureDate);
    } 
    public String getAnemities() 
    { 
    	return "2 sofas";
    }

    //prints each property of the class on a seperate line as well as the properties of the class that it inherits from

    public String Display() {
        
        //take out super.toString figure it out. gets two prices for room with getStartingCost
        String finalString = "Suite Room"+System.lineSeparator()+"Starting cost: $"+getStartingCost()+".00"+System.lineSeparator() + super.getAnemities()+", "+ getAnemities()+System.lineSeparator() +getCustomer().Display();
        return finalString;
    }

    
}
