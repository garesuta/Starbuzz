package com.example.starbuzz;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;
    //drink is an array of Drinks
    public static final Drink[] drinks ={
            new Drink("Latte", "A couple of espresso shots with steamed milk",R.drawable.latte),
            new Drink("Cappuccino","Espresso,hot mmilk,and a steamed milk foam",R.drawable.cappuccino),
            new Drink("Filter","Highest quality beans raosted and brewed fresh",R.drawable.filter)
    };
    //each drink has a name, description, and animaage resource
    private Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;

    }
    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }
    public String toString(){
        return this.name;
    }
}
