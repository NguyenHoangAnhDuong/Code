package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://E:\\LapTrinhMang\\rootTest\\run\\Product.accdb";
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		System.out.println("Conneccting success...");
	}
	public void addProduct(int id, String name, int count, double price) throws SQLException {
		String sql = "insert into Product values (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setInt(3, count);
		statement.setDouble(4, price);
		statement.executeUpdate();
		System.out.println("Success...");
	}
	public Product findByName(String name) throws SQLException {
		String sql = "select * from Product where NameProduct = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet set = statement.executeQuery();
		if(set.next()) {
			Product product = new Product();
			product.setId(set.getInt(1));
			product.setName(set.getString(2));
			product.setCount(set.getInt(3));
			product.setPrice(set.getDouble(4));
			return product;
		}
		return null;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//new DAO().addProduct(222, "My Hanh", 1, 7000.0);
		System.out.println(new DAO().findByName("AO"));
	}

}
