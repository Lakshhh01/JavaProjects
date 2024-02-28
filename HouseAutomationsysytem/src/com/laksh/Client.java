package com.laksh;
import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Client {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	List<Room> roomsList = new ArrayList<>();
    	House myHouse = new House(roomsList);
        

        int userchoice = 0;
        MenuHandler menuHandler = new MenuHandler();

        do {
        	
            userchoice = menuHandler.getUserChoice();

            try {
                switch (userchoice) {
                    case 1:
                        myHouse = menuHandler.createHouse(myHouse);
                        break;
                    case 2:
                        menuHandler.addDevice(myHouse);
                        break;
                    case 3:
                        menuHandler.displayDevices(myHouse);
                        break;                        
                    case 4:
                    	menuHandler.performOperations(myHouse);
                    	break;
                     case 5:
                        System.out.println("Quitting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } while (userchoice != 5);

        sc.close();
    }

}
