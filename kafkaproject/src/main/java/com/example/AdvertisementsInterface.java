package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface for handling advertisements
public interface AdvertisementsInterface extends Remote {
    void receiveAdvertisement(Advertisement advertisement) throws RemoteException;
}
