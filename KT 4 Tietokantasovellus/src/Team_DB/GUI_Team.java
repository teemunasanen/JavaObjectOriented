package Team_DB;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GUI_Team extends JFrame {

	private JPanel contentPane;
	static JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Team frame = new GUI_Team();
					frame.setVisible(true);
					JDBCteam.loadPlayers();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public GUI_Team() {

		setTitle("Legends Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 84, 577, 325);

		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Front Name", "Last Name", "Classification" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Team of Legends");
		lblNewLabel.setBounds(39, 29, 317, 30);
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 23));
		contentPane.add(lblNewLabel);

		// Remove player
		JButton btnNewButton_2 = new JButton("REMOVE PLAYER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBCteam.removePlayer();
				JDBCteam.loadPlayers();
			}
		});
		btnNewButton_2.setBounds(342, 419, 210, 43);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

		// Add player
		JButton btnNewButton_1 = new JButton("ADD PLAYER");
		btnNewButton_1.setBounds(79, 419, 210, 43);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_addPlayer addNew = new GUI_addPlayer();
				addNew.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

	}

}
