package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.example.Advertisement;
import com.example.AdvertisementsInterface;

public class PublishingCenterServer extends UnicastRemoteObject implements AdvertisementsInterface {
    protected PublishingCenterServer() throws RemoteException {
        super();
    }

    @Override
    public void receiveAdvertisement(Advertisement advertisement) throws RemoteException {
        // Logic to process received advertisement
        System.out.println("Received advertisement from " + advertisement.getAdvertiserName());
        System.out.println("Content: " + advertisement.getContent());
        System.out.println("Publication Date: " + advertisement.getPublicationDate());
        // Further processing of the advertisement can be added here
    }

    public static void main(String[] args) {
        try {
            // Create and export the remote object
            AdvertisementsInterface server = new PublishingCenterServer();
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registry.rebind("PublishingCenter", server);

            System.out.println("Publishing Center Server ready.");
        } catch (Exception e) {
            System.err.println("Publishing Center Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
