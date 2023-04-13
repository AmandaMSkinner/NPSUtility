package com.company.services;

import org.springframework.web.client.RestTemplate;


import com.company.model.Park;

public class ParkService {
    public static String API_BASE_URL = "https://developer.nps.gov/api/v1/parks";
    public static String API_KEY = "ZxjL0eqjhdM3pwzbtKCHnXMMmvLVa1RkXwOyv1mu";
    private RestTemplate restTemplate = new RestTemplate();

    public Park getPark(String parkCode) {
        try {
            String parkJSON = restTemplate.getForObject(API_BASE_URL + "?parkCode=" + parkCode + "&api_key=" + API_KEY, String.class);
            Park park = new Park();
            park = park.newJsonPark(parkJSON);
            return park;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
