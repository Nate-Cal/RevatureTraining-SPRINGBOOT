package com.revature.models;

import org.springframework.stereotype.Component;

@Component // This makes a class a bean! No need to do it in XML
public class Cat {

    private int catID;
    private String catColor;
    private String catName;
    // Owner is a DEPENDENCY of Cat
    // With Spring we can "wire beans together" to accomplish DEPENDENCY INJECTION
    private Owner owner;

    public Cat() {
    }

    public Cat(int catID, String catColor, String catName, Owner owner) {
        this.catID = catID;
        this.catColor = catColor;
        this.catName = catName;
        this.owner = owner;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catID=" + catID +
                ", catColor='" + catColor + '\'' +
                ", catName='" + catName + '\'' +
                ", owner=" + owner +
                '}';
    }
}
