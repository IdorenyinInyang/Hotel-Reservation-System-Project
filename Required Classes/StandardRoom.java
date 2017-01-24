
public class StandardRoom 
{ 
	protected Customer customer; 
	private static int startingCost = 120;  
	
	
	public StandardRoom() 
	{ 
		customer = new Customer();  
		
	}  
	public StandardRoom(String name,String arrivalDate, String departureDate,  boolean safe) 
	{ 
		customer = new Customer(name, arrivalDate, departureDate, startingCost, safe);
	} 
	public void setCustomer(Customer customer) 
	{ 
		this.customer = customer;
	}
	public Customer getCustomer() 
	{ 
		return customer;
	} 
	
	public static int getStartingCost() 
	{
        return startingCost;
    } 
	
	public String getAnemities() 
	{ 
		return "One Queen Bed";
	}
	
	public String Display() 
	{ 
		return "Standard Room"+System.lineSeparator()+"Starting cost: $"+getStartingCost()+".00"+System.lineSeparator()+ getAnemities() + System.lineSeparator() + getCustomer().Display();
	}

}
