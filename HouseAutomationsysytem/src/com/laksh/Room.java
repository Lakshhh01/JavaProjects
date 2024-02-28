package com.laksh;
import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
public class Room {
	Scanner sc=new Scanner(System.in);
	String roomType;
	List<Devices> devicesList=new ArrayList<Devices>();
	

/////////////////////////////////////////////////----->>Constructors<<----/////////////////////////////////////////	

	public Room() {
		
	}
	
	public Room(String roomType) {
		super();
		
		this.roomType = roomType;
		this.devicesList = new ArrayList<>();
	}


/////////////////////////////////////////////----->>Setters-Getters<<----/////////////////////////////////////////	


	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public List<Devices> getDevicesList() {
		return devicesList;
	}
	
	public void setDevicesList(List<Devices> devices) {
		this.devicesList = devices;
	}

	
////////////////////////////////////////////////----->>Display<<----///////////////////////////////////////////////
	
	public void display() {
		System.out.println("Room Type:" + this.roomType);
		System.out.println("Devices in " + this.roomType + " :");
		for(Devices ref:devicesList) {
			System.out.println(ref.getClass().getSimpleName());
		}
		
		
	}

	
///////////////////////////////////////////--------->>Add Device in Room<<--------//////////////////////////////////
	
	public void addDevice(Devices device) {
		//--add into devices list--//
		devicesList.add(device);
       
    }

	
	
///////////////////////////////////--------->>Search Device in Room<<--------//////////////////////////////////

	public static Devices searchDeviceInRoom(String deviceName,List<Devices> deviceList) {
		for(Devices deviceptr:deviceList) {
			if(deviceptr.getClass().getSimpleName().equalsIgnoreCase(deviceName)){
				return deviceptr;
			}
		}
		return null;
	}
//----------------------------------device operations-------------------------------------------------------//
	
////////////////////////////////////////turnon//////////////////////////////////////////
	
	public void turnOnfromRoom(String deviceName ) {
		
		Devices deviceref=searchDeviceInRoom(deviceName, devicesList);
		if(deviceref!=null) {
			deviceref.turnOnDevice();
			
		}else {
			System.out.println("device not found in room ");
		}
			
		
	}
	
/////////////////////////////////////////turnoff////////////////////////////////////////////////////

	public void turnOfffromRoom(String deviceName ) {
			
			Devices deviceref=searchDeviceInRoom(deviceName, devicesList);
			if(deviceref!=null) {
				deviceref.turnOffDevice();
				
			}else {
				System.out.println("device not found in room ");
			}
				
			
		}
//////////////////////////////////////////checkstatus///////////////////////////////////////////////////

	
	public void checkStatusfromRoom(String deviceName ) {
		
		Devices deviceref=searchDeviceInRoom(deviceName, devicesList);
		if(deviceref!=null) {
			deviceref.checkStatusOfDevice();
			
		}else {
			System.out.println("device not found in room ");
		}
				
	}
	
/////////////////////////////////////timespan////////////////////////////////////////////////////////

	public Duration checkTimeSpanfromRoom(String deviceName ) {
		
		Devices deviceref=searchDeviceInRoom(deviceName, devicesList);
		if(deviceref!=null) {
			return deviceref.checkTimeSpanOfCurrentStatus();
			
		}else {
			System.out.println("device not found in room ");
			return null;
		}
	}
}
