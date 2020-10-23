package OOP_191110136;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CRUD_191110136 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label_NIM = new JLabel("NIM");
	JTextField txt_NIM = new JTextField(30);
	JLabel label_Nama = new JLabel("Name");
	JTextField txt_Nama = new JTextField(50);
	JButton buttonSearch = new JButton("Search");
	JButton buttonInput = new JButton("Input");
	JButton buttonEdit = new JButton("Edit");
	JButton buttonDelete = new JButton("Delete");
	JButton buttonExit = new JButton("Exit");

	CRUD_191110136() {
		setTitle("Data Mahasiswa");
		setLocation(300, 300);
		setSize(320, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void Layout() {
		getContentPane().setLayout(null);
		getContentPane().add(label_NIM);
		label_NIM.setBounds(10, 10, 70, 20);
		getContentPane().add(txt_NIM);
		txt_NIM.setBounds(80, 10, 110, 20);

		getContentPane().add(label_Nama);
		label_Nama.setBounds(10, 40, 70, 20);
		getContentPane().add(txt_Nama);
		txt_Nama.setBounds(80, 40, 200, 20);

		getContentPane().add(buttonSearch);
		buttonSearch.setBounds(200, 10, 80, 20);

		getContentPane().add(buttonEdit);
		buttonEdit.setBounds(105, 80, 80, 20);

		getContentPane().add(buttonInput);
		buttonInput.setBounds(10, 80, 80, 20);
		getContentPane().add(buttonDelete);
		buttonDelete.setBounds(200, 80, 80, 20);
		getContentPane().add(buttonExit);
		buttonExit.setBounds(200, 120, 80, 20);
		setVisible(true);
	}

	void Clear() {
		txt_NIM.setText("");
		txt_Nama.setText("");
	}

	void Action() {
		// button input
		buttonInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection_191110136 open = new connection_191110136();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "INSERT INTO siswa_191110136 VALUES ('" + txt_NIM.getText() + "','" + txt_Nama.getText()
							+ "');";
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Data Mahasiswa Berhasil Disimpan");
					}
					Clear();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		// button search
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search;
				connection_191110136 open = new connection_191110136();
				Connection mysql = open.getConnection();
				try {
					search = txt_NIM.getText();
					Statement stmt = mysql.createStatement();
					String sql = "SELECT * FROM siswa_191110136 " + "WHERE NIM like '" + search + "'";
					ResultSet res = stmt.executeQuery(sql);
					if (res.next()) {
						txt_NIM.setText(res.getString(1));
						txt_Nama.setText(res.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "Data Mahasiswa sudah Ada");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		// button update
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection_191110136 open = new connection_191110136();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "UPDATE siswa_191110136 SET " + "Nama='" + txt_Nama.getText() + "'" + "WHERE " + "NIM='"
							+ txt_NIM.getText() + "'";
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Data Sudah Diedit");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				Clear();
			}
		});
		// button delete
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection_191110136 open = new connection_191110136();
				Connection mysql = open.getConnection();
				try {
					Statement stmt = mysql.createStatement();
					String sql = "DELETE FROM siswa_191110136 " + "WHERE NIM='" + txt_NIM.getText() + "'";
					int i = stmt.executeUpdate(sql);
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Data Sudah Dihapus");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		CRUD_191110136 cn = new CRUD_191110136();
		cn.Layout();
		cn.Action();
	}
}
