package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Class representing the advertisement data
public class Advertisement implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String content;
    private String advertiserName;
    private String publicationDate;
    // Additional advertisement attributes and methods can be added here

    public Advertisement(String content, String advertiserName, String publicationDate) {
        this.content = content;
        this.advertiserName = advertiserName;
        this.publicationDate = publicationDate;
    }

    // Getter and setter methods for advertisement attributes
    public String getContent() {
        return content;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

}