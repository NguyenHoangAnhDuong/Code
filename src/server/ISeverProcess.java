package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISeverProcess extends Remote {
	public String addProduct(int id, String name, int count, double price) throws RemoteException;

	public Product findProduct(String name) throws RemoteException;
}
