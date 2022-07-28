package com.galvanize;

public class Owner {

    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmail;
    private String ownerJobTitle;

    public Owner(String ownerFirstName, String ownerLastName, String ownerEmail, String ownerJobTitle) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerEmail = ownerEmail;
        this.ownerJobTitle = ownerJobTitle;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getOwnerJobTitle() {
        return ownerJobTitle;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
}
