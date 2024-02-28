package com.laksh;

import java.time.Duration;
//import java.time.Duration;
import java.time.LocalTime;

public class AirConditioner implements Devices {
	
	double temp;
	 boolean turnOn;
	LocalTime lastTurnOffTime;
	LocalTime lastTurnOnTime;
/////////////////////////////////---->>Constructors<<------//////////////////////////////

	public AirConditioner() {
		
	}

	public AirConditioner(double temp) {
		super();
		this.temp = temp;
	}
	
/////////////////////////////////---->>Setters-Getters<<------//////////////////////////////
	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}


	@Override
	public void turnOnDevice() {
		
		turnOn=true;
		lastTurnOnTime=LocalTime.now();
		System.out.println("Device turned On successfullly");
	}

	@Override
	public void turnOffDevice() {
		turnOn=false;
		lastTurnOffTime=LocalTime.now();
		System.out.println("Device turned Off successfullly");
	}


	@Override
	public void checkStatusOfDevice() {
		if(turnOn) {
			System.out.println("device is turned on");
		}
		else {
			System.out.println("device is off");
		}
	}


	
	
	 /*  If both conditions are true, it means the device was turned off at some point, 
	   and we can calculate the time span.*/
	@Override
	public Duration checkTimeSpanOfCurrentStatus() {
        if (turnOn && lastTurnOffTime == null) {
            return Duration.between(lastTurnOnTime, LocalTime.now());
        } else if (lastTurnOnTime != null && lastTurnOffTime != null) {
            return Duration.between(lastTurnOffTime, LocalTime.now());
        } else {
            System.out.println("Light is not turned on or turned off yet.");
            return null;
        }
    
    }

/////////////////////////////////---->>Display<<------//////////////////////////////
	public void display() {
	System.out.println("Temperature of AC :" + this.temp);
	System.out.println("Status: "+ this.turnOn);
	}
	
}
