package com.laksh;

import java.time.Duration;

public interface Devices {
	
	
	/*-----Methods-----*/
	
	void turnOnDevice();
	
	void turnOffDevice();
	
	void checkStatusOfDevice();
	
	Duration checkTimeSpanOfCurrentStatus();
	
//	void addDevice();
	
	//by default all methods are abstract in interfaces//
	
}
