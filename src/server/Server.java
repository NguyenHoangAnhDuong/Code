package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server() throws RemoteException {
		Registry registry = LocateRegistry.createRegistry(1080);
		ServerProcess process = new ServerProcess();
		registry.rebind("Product", process);
	}
	public static void main(String[] args) throws RemoteException {
	Server server = new Server();
	}
	

}
