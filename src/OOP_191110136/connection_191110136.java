package OOP_191110136;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection_191110136 {
	String url, usr, pwd, db;

	public connection_191110136() {
		db = "db_191110136";
		url = "jdbc:mysql://localhost/" + db;
		usr = "root";
		pwd = "";
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Ok : Driver Ditemukan");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Driver Tidak Ditemukan \n" + e + "\n");
		} catch (SQLException e) {
			System.out.println("Error:Tidak Bisa Koneksi Ke Database\n" + e + "\n");
		}
		return con;
	}

	private void PembuatDialog() {
		System.out.println("Created By : " + "DnD ~ http://sidiq.mercubuana-yogya.ac.id");
		System.exit(0);
	}

	public static void main(String[] args) {
		connection_191110136 dnd = new connection_191110136();
		dnd.getConnection();
		dnd.PembuatDialog();
	}
}
