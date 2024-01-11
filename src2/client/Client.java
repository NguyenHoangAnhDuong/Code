package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.ISeverProcess;

public class Client {
	public Client() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 1080);
		ISeverProcess process = (ISeverProcess) registry.lookup("Product");
	}
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Client client = new Client();
	}

}
