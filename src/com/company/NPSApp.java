package com.company;

import com.company.model.Park;
import com.company.services.ParkService;

public class NPSApp {

    public static void main(String[] args) {
	// write your code here
        ParkService parkService = new ParkService();
        System.out.println(parkService.getPark("yose"));
    }
}
