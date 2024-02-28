package com.laksh;

import java.time.Duration;
import java.time.LocalTime;

public class Shower implements Devices{

	 boolean turnOn;
	LocalTime lastTurnOnTime;
	LocalTime lastTurnOffTime;
	
/////////////////////////////////---->>Methods<<------//////////////////////////////

	@Override
	public void turnOnDevice() {
		
		this.turnOn=true;
		lastTurnOnTime=LocalTime.now();
		System.out.println("Device turned On successfullly");
	}

	@Override
	public void turnOffDevice() {
		this.turnOn=false;
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


}
