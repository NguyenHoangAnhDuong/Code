package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ServerProcess extends UnicastRemoteObject implements ISeverProcess{

	protected ServerProcess() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String addProduct(int id, String name, int count, double price) throws RemoteException{
		DAO dao;
		try {
			dao = new DAO();
			dao.addProduct(id, name, count, price);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}

	@Override
	public Product findProduct(String name) throws RemoteException {
		try {
			DAO dao = new DAO();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
