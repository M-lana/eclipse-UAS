package OOP_191110136;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class table_191110136 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] header = { "NIM", "Nama" };
	JTable siswa_191110136 = new JTable();
	JScrollPane scrollTable = new JScrollPane();
	public Object[][] isiTable = null;

	table_191110136() {
		connection_191110136 open = new connection_191110136();
		Connection mysql = (Connection) open.getConnection();

		try {
			Statement stmt = mysql.createStatement();
			String sql = "SELECT * FROM siswa_191110136";
			ResultSet res = stmt.executeQuery(sql);
			ResultSetMetaData meta = res.getMetaData();
			int kolom = meta.getColumnCount();
			int baris = 0;
			while (res.next()) {
				baris = res.getRow();
			}
			isiTable = new Object[baris][kolom];
			int x = 0;
			res.beforeFirst();
			while (res.next()) {
				isiTable[x][0] = res.getString("NIM");
				isiTable[x][1] = res.getString("Nama");
				x++;
			}
			scrollTable.setViewportView(siswa_191110136);
			siswa_191110136.setModel(new DefaultTableModel(isiTable, header));
			add(scrollTable, BorderLayout.NORTH);
			stmt.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Data Mahasiswa Error");
		}
	}

	void Layout() {
		JFrame frame = new JFrame("Data Mahasiswa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table_191110136 content = new table_191110136();
		content.setOpaque(true);
		frame.setContentPane(content);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		table_191110136 tb = new table_191110136();
		tb.Layout();
	}
}
