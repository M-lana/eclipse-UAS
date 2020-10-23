package OOP_191110136;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class menu_191110136 extends JFrame {
	/**
	* 
	* 
	*/
	private static final long serialVersionUID = 1L;
	JMenuBar menuContoh = new JMenuBar();

	JMenu View = new JMenu("View");
	JMenu OpenSubmenu = new JMenu("View table");
	JMenuItem Table = new JMenuItem("Table");
	JMenu File = new JMenu("File");
	JMenu OpenSubmenu1 = new JMenu("Open");
	JMenuItem Mhs = new JMenuItem("Input Data Mahasiswa");
	JMenuItem Exit = new JMenuItem("Exit");
	JMenu About = new JMenu("About");
	JMenuItem AboutDialog = new JMenuItem("About Us");

	menu_191110136() {
		setTitle("Menu Data");
		setLocation(300, 300);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void Layout() {
		setJMenuBar(menuContoh);
		menuContoh.add(View);
		View.add(OpenSubmenu);
		OpenSubmenu.add(Table);
		menuContoh.add(File);
		File.add(OpenSubmenu1);
		OpenSubmenu1.add(Mhs);
		File.add(Exit);
		menuContoh.add(About);
		About.add(AboutDialog);
		setVisible(true);
	}

	void Action() {
		Mhs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD_191110136 id = new CRUD_191110136();
				id.Layout();
				id.Action();
			}
		});
		Table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_191110136 tbl = new table_191110136();
				tbl.Layout();
			}
		});

		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		AboutDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"<html>Program Menu Mahasiswa <br/>" + "Nim : 191110136 <br/> Nama : Fariq Maulana Insan </a>",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	public static void main(String[] args) {
		menu_191110136 mn = new menu_191110136();
		mn.Layout();
		mn.Action();
	}
}
