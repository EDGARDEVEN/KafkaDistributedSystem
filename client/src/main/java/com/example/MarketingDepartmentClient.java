package com.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import com.example.Advertisement;
import com.example.AdvertisementsInterface;

public class MarketingDepartmentClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object from the RMI registry
            AdvertisementsInterface server = (AdvertisementsInterface) Naming.lookup("//localhost/PublishingCenter");

            // Create and send an advertisement to the Publishing Center
            Advertisement advertisement = new Advertisement("Advertisement Content", "Advertiser X", "2024-04-25");
            server.receiveAdvertisement(advertisement);

            System.out.println("Advertisement sent successfully.");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
