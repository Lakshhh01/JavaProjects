package com.laksh;
import java.time.Duration;
import java.util.List;
//import java.util.ArrayList;	
import java.util.Scanner;
public class House {
	Scanner sc=new Scanner(System.in);
	List<Room> RoomsList=null;

	
//////////////////////////////----->>Constructors<<----//////////////////////////////////////////	

	
	public House(List<Room> rooms) {
		
		RoomsList = rooms;
	}

//////////////////////////////----->>Setters-Getters<<----/////////////////////////////////////////	

	public List<Room> getRooms() {
		return RoomsList;
	}

	public void setRooms(List<Room> rooms) {
		RoomsList = rooms;
	}
	
	
//////////////////////////////----->>Display<<----////////////////////////////////////////////////
	
	
	public void display() {
		
		System.out.println("List of rooms in house: ");
		for(Room ref:RoomsList) {
			//--for each reference of Room object, display its roomtype--//
			System.out.println(ref.getRoomType());
		}
		
	}

//////////////////////////////------>>SearchRoom<<-------//////////////////////////////////////////////

	public Room searchRoom(String roomType) {
		for(Room ref:RoomsList) {
			
			/*for each reference of object room->gettype of that room object*/
			if(ref.getRoomType().equalsIgnoreCase(roomType)) {
				return ref;
				
			}
		}
		
		return null;
	}
	
	
	
////////////////////////////////////Perform operations///////////////////////////////////////
	
	public void turnOnHouse(String roomtype,String deviceName) {
		
		Room roomref=searchRoom(roomtype);
		
		roomref.turnOnfromRoom(deviceName);
		
		
	}
	
	
	
	public void turnOffHouse(String roomtype,String deviceName) {
			
			Room roomref=searchRoom(roomtype);
			
			roomref.turnOfffromRoom(deviceName);
			
			
	}
	
	public void HouseCheckStatus(String roomtype,String deviceName) {
			
			Room roomref=searchRoom(roomtype);
			
			roomref.checkStatusfromRoom(deviceName);
			
			
	}
	
	public Duration HousecheckTimer(String roomtype,String deviceName) {
		
		Room roomref=searchRoom(roomtype);
		if(roomref!=null) {
			return roomref.checkTimeSpanfromRoom(deviceName);
			
		}
		return null;
		
		
}
	

}

