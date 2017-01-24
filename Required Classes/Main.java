import java.util.*; 

public class Main {

	static Hotel hotel; 
	static int index = 0, roomNum = 0;
	public static void main(String[] args) 
	{ 
		Scanner scan = new Scanner(System.in);
		int numInput;
		int cost = 0;
		 
		StandardRoom sr;
		hotel = new Hotel();    
		String strInput = "";
		String name = "";
		String ad = "";
		String dd = "";
		String room = ""; 
		boolean safe = false;  
		hotel.HotelName("Hilton Garden Inn");
		System.out.println("Please select one of the following choices: "
				+ "1.) Display Current Rooms "
				+ "2.) Add Customer "
				+ "3.) Exit");  
		numInput = scan.nextInt();
		while(numInput < 3) 
		{ 
			switch(numInput) 
			{ 
				case 1:  
					System.out.println(hotel.Display());
					break; 
				case 2: 
					
					System.out.println("Enter customer's name"); 
					name = scan.next();  
					
					roomNum = isReserved(); 
					if(roomNum == -1)
					{ 
						System.out.println("Sorry, there are no currently available rooms.");
						break;
					} 
					
					System.out.println("Room #"+roomNum+" available");
					System.out.println("Enter customer's arrival date (format: ##/##/####)"); 
					ad = scan.next(); 
					System.out.println("Enter customer's departure date (format: ##/##/####)"); 
					dd = scan.next();  
					System.out.println("Do you wish to have a safe in your room?"); 
					strInput = scan.next(); 
						if(strInput.equals("yes")|| strInput.equals("y")) safe = true;
					System.out.println("What room would the customer like?");  
					room = scan.next();
					switch(room) 
					{ 
						case "standard": 
					
							hotel.setRoom(index, new StandardRoom(name, ad, dd, safe)); 
							break; 
						case "suite":  

							hotel.setRoom(index, new SuiteRoom(name, ad, dd, safe)); 
							break; 
						case "deluxe": 
							
							hotel.setRoom(index, new DeluxeRoom(name, ad, dd, safe)); 
							break;
						
					}  
					System.out.println(hotel.getRoom(index).Display()); 
					index++;
			} 
			System.out.println("\nPlease select one of the following choices: "
			+ "1.) Display Current Rooms "
			+ "2.) Add Customer "
			+ "3.) Exit");  
			numInput = scan.nextInt();
		}

	} 
	
	public static int isReserved()
	{ 
		
		if (hotel.getNumRooms() == 30) return -1;  
		return hotel.getRoomNum(index);
		
		
	} 

}
