package com.laksh;

import java.time.Duration;
import java.time.LocalTime;

public class Light implements Devices {
    private boolean turnOn;
    private LocalTime lastTurnOffTime;
    private LocalTime lastTurnOnTime;

    // Constructors, other methods, and the rest of the class remain the same...

    @Override
    public void turnOnDevice() {
        this.turnOn = true;
        this.lastTurnOnTime = LocalTime.now();
        System.out.println("Device turned On successfully");
    }

    @Override
    public void turnOffDevice() {
        this.turnOn = false;
        this.lastTurnOffTime = LocalTime.now();
        System.out.println("Device turned Off successfully");
    }

    @Override
    public void checkStatusOfDevice() {
        if (this.turnOn) {
            System.out.println("Device is turned on");
        } else {
            System.out.println("Device is off");
        }
    }

    
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
