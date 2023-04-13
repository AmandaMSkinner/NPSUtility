package com.company.services;

import org.springframework.web.client.RestTemplate;


import com.company.model.Park;

import java.util.ArrayList;


public class ParkService {
    public static String API_BASE_URL = "https://developer.nps.gov/api/v1/parks";
    public static String API_KEY = "ZxjL0eqjhdM3pwzbtKCHnXMMmvLVa1RkXwOyv1mu";
    private RestTemplate restTemplate = new RestTemplate();
    public ArrayList<String> parkCodes = getParkCodes();//get park codes ONCE

    public Park getPark(String parkCode) {
        try {
            String parkJSON = restTemplate.getForObject(API_BASE_URL + "?parkCode=" + parkCode + "&api_key=" + API_KEY, String.class);
            Park park = new Park();
            park = park.newJsonPark(parkJSON);
            return park;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Park> getAllParks(){
      ArrayList<Park> allParks = new ArrayList<>();
      for(String parkCode:parkCodes){
          allParks.add(getPark(parkCode));
      }
      return allParks;
    }

    public ArrayList<String> getParkCodes() {
        ArrayList<String> parkCodes = new ArrayList<>();
        for (int i = 0; i <= 468; i=i+50) {
            String raw = restTemplate.getForObject(API_BASE_URL + "?start=" + i + "&api_key=" + API_KEY, String.class);
            while (raw.contains("parkCode")) {
                String snip = raw.substring(raw.indexOf("parkCode") + 11, raw.indexOf("parkCode") + 15);
                parkCodes.add(snip);
                raw = raw.replaceFirst("parkCode", "");
            }
        }
        return parkCodes;
    }

    ;

}
