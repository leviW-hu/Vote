package com.example.voteapp.data;

public class MyLocation {

    private Areas type;
    private int id;
    private String name;

    public Areas getType() {
        return type;
    }

    public void setType(Areas type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public MyLocation(Areas type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLocation(Areas type, int id, String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

   public enum Areas{
        CITY,
        SHIRE,
        COUNTRY
    }
}
