package com.company.model;


public class Park {
    private String parkId;
    private String name;
    private String location;
    private String description;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name +
                "\n\tIDENTIFICATION CODE : " + parkId.toUpperCase() +
                "\n\tDESCRIPTION : " + description+
                "\n\tDIRECTIONS : " + location;
    }

    public Park newJsonPark(String jsn){
        Park park = new Park();
        park.setName(GetJSONValue(jsn,"fullName"));
        park.setDescription(GetJSONValue(jsn,"description"));
        park.setLocation(GetJSONValue(jsn,"directionsInfo"));
        park.setParkId(GetJSONValue(jsn,"parkCode"));
        return park;
    }

    public static String GetJSONValue(String JSONString, String Field)
    {
        String temp = JSONString.substring(JSONString.indexOf(Field), JSONString.indexOf("\n", JSONString.indexOf(Field))).replace(Field+"\": \"", "").replace("\"", "").replace(",","");
        temp=temp.replace(Field+":","");
        return temp;
    }
}
