package com.laksh;

import java.time.Duration;
//import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {

    Scanner sc=new Scanner(System.in);

    public MenuHandler() {
      
    }

/////////////////////////////////////////////////////////////////////////////////////
    
    public int getUserChoice() {
    	
    	
        displayMenu();//call//

        boolean input = false;
        int choice = 0;

        while (input==false) {
            try {
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                input = true;
            } catch (InputMismatchException ime) {
                System.err.println("Please enter a valid integer as input!!");
                sc.next();
            }
        }

        return choice;
    }

///////////////////////////////////////////////////////////////////////////////////////
    
    public void displayMenu() {
        System.out.println("|===========================================|");
        System.out.println("|          *Home Automation System*         |");
        System.out.println("|===========================================|");
        System.out.println("|   Option  |          Description          |");
        System.out.println("| ----------|-------------------------------|");
        System.out.println("|     1     |         Create House          |");
        System.out.println("|     2     |           Add device          |");
        System.out.println("|     3     |     Display all Devices       |");
        System.out.println("|     4     | Perform Operations on Device  |");
        System.out.println("|     5     |             Exit              |");
        System.out.println("|===========================================|");
    }
    
/////////////////////////////////////////////////////////////////////////////////////

    public House createHouse(House myHouse) {
        System.out.println("Creating a house...");
      		int c;
		do {
			System.out.println("Living room");
			System.out.println("Kitchen");
			System.out.println("bedroom");
			System.out.println("dining room");
			System.out.println("Washroom");
			System.out.println("GuestRoom");
			System.out.println("Corridors");
			String RoomType = null;
			boolean flag=false;
			while(flag==false) {
				try {
				 System.out.println("Please type Name from the list ");
				 RoomType=sc.next();
				 flag=true;
				}catch(InputMismatchException ime) {
					System.err.println("Please enter valid ***String*** as input");
				}
			}
			
	        myHouse.getRooms().add(new Room(RoomType));		
			
	        System.out.println("If you want to add more rooms press 1 else enter 0");
	        c=sc.nextInt();
		}while(c==1);
		

		myHouse.display();

		
        return  myHouse;
    }

/////////////////////////////////////////////////////////////////////////////////////

    public void addDevice(House myHouse) {
    	// write condition if house is not created , cant add device //
		try {
			if (myHouse == null) {
				throw new HouseNotFoundException("Please create house first (Option 1).");
		      
		    }
			
		    myHouse.display();
		    boolean flag=false;
		    String roomType=null;
		    
		    while(flag==false) {
		    	 try {
				    	System.out.println("Type the Room name from the list: ");
					    roomType = sc.next();
					    flag=true;
				    }catch(InputMismatchException ime) {
				    	System.err.println("Please enter valid ***String*** as input");
				    }
		    }
		   
		    
		    Room roomFound = myHouse.searchRoom(roomType);
		    
		    if (roomFound != null) {
		        System.out.println("1.Television");
		        System.out.println("2.Refrigerator");
		        System.out.println("3.WashingMachine");
		        System.out.println("4.AirConditioner");
		        System.out.println("5.Light");
		        System.out.println("6.Shower");
		        boolean flag1=false;
		        int deviceName = 0;
		        while(flag1==false) {
		        	try {
		        	System.out.println("Enter the choice to add in " + roomFound.getRoomType() + ": ");
		        	 deviceName=sc.nextInt();
		        	flag1=true;
		        	}catch (InputMismatchException ime) {
						System.err.println("Please enter valid ***INTEGER*** as input");
						sc.next();
					}
		        }
		        
		        //--creating pointer of device interface--//
		        Devices newDevice = null;
		        switch(deviceName) {
		        	case 1:{
		        		newDevice=new Television();
		        		break;
		        	}
		        	case 2:{
		        		newDevice=new Refridgerator();
		        		break;
		        	}
		        	case 3:{
		        		newDevice=new WashingMachine();
		        		break;
		        	}
		        	case 4:{
		        		newDevice=new AirConditioner();
		        		break;
		        	}
		        	case 5:{
		        		newDevice=new Light();
		        		break;
		        	}
		        	case 6:{
		        		newDevice=new Shower();
		        		break;
		        	}
		        	default:{
		        	
		        	System.out.println("Device not found");
		        	System.out.println("If you want to add a custom device, create your customized class and implement devices.");
		        	break;
		        	}
		        
		        	
		        }
		       
		        //add device to room/
		        if(newDevice !=null) {
		        	
	        		roomFound.addDevice(newDevice);
	        	}
	        
		        // Display the list of devices in the room
		        
		        System.out.println("Devices in " + roomFound.getRoomType() + ": ");
		        for (Devices device : roomFound.getDevicesList()) {
		            System.out.println(device.getClass().getSimpleName());
		        }
		        
		        
		    } else {
		        System.out.println("Room not found! Please enter room name Properly");
		    }
		}catch(Exception e) {
			System.err.println("An error occured: "+ e.getMessage());
		}
	    

        
    }
    
//----------------------------------Display devices in rooms------------------------------//
    
    public void displayDevices(House myHouse){
    	List<Room> roomsList=myHouse.RoomsList;
    	for(Room roomref:roomsList) {
    		
    		System.out.println(roomref.getRoomType());
    		
        	List<Devices>deviceList=roomref.getDevicesList();
        	
        	for(Devices deviceref:deviceList) {
        		System.out.println("- " + deviceref.getClass().getSimpleName());
        		
        		//display status as well//
        	}
    	}
    	
    	
    }
    
//----------------------------------perform operations from any room------------------------------//
    public void performOperations(House myHouse){
    	
    	displayDevices(myHouse);
    	
    	System.out.println("Enter the room name from list:");
    	String roomName=sc.next();
    	System.out.println("Enter the device name to perform operation: ");
    	String deviceName=sc.next();
    	
    	
    	
 	    int operationChoice =0;
 	    
 	    	System.out.println("-----------Operations-----------:");
 	 	    System.out.println("1.TurnOn device");
 	 	    System.out.println("2.TurnOff device");
 	 	    System.out.println("3.Check status of Device");
 	 	    System.out.println("4.Check time span of device status");
 	 	    System.out.println("5.Exit");
 	 	    
 	 	    System.out.println("- the choice to perform operation:");

 	    	operationChoice= sc.nextInt();
 	    	switch (operationChoice) {
 	    	
 			case 1:
 				myHouse.turnOnHouse(roomName, deviceName);
 				break;
 			case 2:
 				myHouse.turnOffHouse(roomName, deviceName);
 				break;
 			case 3:
 				myHouse.HouseCheckStatus(roomName, deviceName);
 				break;
 			case 4:
 				Duration Dur= myHouse.HousecheckTimer(roomName, deviceName);
 				System.out.println(Dur);
 				break;
 			case 5:{
 				System.out.println("exiting .. from operations menu...");
 			}

 			default:
 				break;
 			}
 	    	
 	    	
 	   
    	
    
    }

    

}//menuhandler class ends
    

