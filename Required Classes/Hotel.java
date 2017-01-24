import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Hotel {

    private String hotelName;
    private StandardRoom[] rooms; 

    //sets each property of the class to it's default value
    public Hotel() {
        hotelName = "";
        rooms  = new StandardRoom[30]; //instantiating 30 rooms for availability
    }

    /**
     * @return the hotelName
     */
    public String getHotelName() {
        return hotelName+"\n";
    }

    /**
     * @param storeName the hotelName to set
     */
    public void HotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * @return the rooms
     */
    public StandardRoom[] getRooms() {
        return rooms;
    }

    /**
     * @param mowers the rooms to set
     */
    public void setRooms(StandardRoom[] rooms) {
        this.rooms = rooms;
    }

    //Return the number of items in the Arraylist rooms
    public int getNumRooms() {  
    	int items = 0;
    	for(int i = 0; i < rooms.length; i++) 
    	{ 
    		if (rooms[i] != null) items++;
    	}
        return items;
    }

    //get the widget at location index in the ArrayList rooms
    public int getRoomNum(int index) {
        return index + 1;
    }

    public StandardRoom getRoom(int index) 
    { 
    	return rooms[index];
    }
    //store item at location index in the Array rooms
    public void setRoom(int index, StandardRoom item) {
        rooms[index] = item;
    }



//remove and return the mower at location index
    public StandardRoom removeRoom(int index) {
        rooms[index] = null; //deallocate that space
        return rooms[index];

    }

    //after the user has added a mower allows them to save the mower by adding it to the arrayList and printing
    //it to a new file using printwrtier through the toString method 
    public void saveHotelData(String outputFileName) throws IOException {

        try {

            PrintWriter pw = new PrintWriter(new FileOutputStream(outputFileName, false));

            //prints the hotelName as the first thing in the new file that is created
            pw.println(hotelName);

            //loops through the arraylist including the new mower that that was added and prints each element
            for (StandardRoom r : rooms) {
                pw.print(r.toString());
            }

            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening the output file");
        }
    } 

    //traverses through the arrraylist and prints each thing on a different line and apphends the hotelName
    //to the beginning of the list 
 
    public String Display() {

        String hotelProperties = getHotelName(); 
        int i; 
        

        for (i = 0; i < rooms.length;  i++) {
        	if(rooms[i] == null){ 
        		hotelProperties +=System.lineSeparator()+"Room available"; 
        	} 
        	else hotelProperties += System.lineSeparator() +"Room Number: "+getRoomNum(i)+ System.lineSeparator()+rooms[i].Display(); 
        	hotelProperties += System.lineSeparator()+"------------------------------------------------"; //separate space
           
        }
        return hotelProperties;
    } 
    

}
