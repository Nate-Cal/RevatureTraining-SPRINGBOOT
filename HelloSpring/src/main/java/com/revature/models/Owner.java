package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Owner {

    private int ownerID;
    private String ownerName;

    public Owner() {
    }

    public Owner(int ownerID, String ownerName) {
        this.ownerID = ownerID;
        this.ownerName = ownerName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
