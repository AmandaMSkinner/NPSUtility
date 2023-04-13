package com.company;

import com.company.model.Park;
import com.company.services.ParkService;

import java.util.Scanner;

public class NPSApp {

    public static void main(String[] args) {
	// write your code here
        ParkService parkService = new ParkService();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a 4-letter park code");
        String pc = scan.nextLine();
        while(pc.length()!=4){
            System.out.println("Invalid: Enter a park code");
            pc = scan.nextLine();
        }
        System.out.println(parkService.getPark(pc));
    }
}
