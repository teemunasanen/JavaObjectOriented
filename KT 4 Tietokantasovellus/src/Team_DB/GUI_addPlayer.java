package Team_DB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_addPlayer extends JFrame {

	private JPanel contentPane;
	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_addPlayer frame = new GUI_addPlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_addPlayer() {
		setTitle("Legends Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblLname = new JLabel("Front Name:");
		lblLname.setForeground(Color.WHITE);
		lblLname.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblLname.setBounds(34, 176, 94, 19);
		panel.add(lblLname);

		JLabel lblFname = new JLabel("Last Name:");
		lblFname.setForeground(Color.WHITE);
		lblFname.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblFname.setBounds(34, 228, 85, 19);
		panel.add(lblFname);

		JLabel lblShirtnr = new JLabel("Classification:");
		lblShirtnr.setForeground(Color.WHITE);
		lblShirtnr.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblShirtnr.setBounds(34, 279, 107, 19);
		panel.add(lblShirtnr);

		tfFname = new JTextField();
		tfFname.setToolTipText("Fname max 16 char");
		tfFname.setBounds(152, 175, 197, 22);
		panel.add(tfFname);
		tfFname.setColumns(10);

		tfLname = new JTextField();
		tfLname.setToolTipText("Lname max 32 char");
		tfLname.setBounds(152, 227, 197, 22);
		panel.add(tfLname);
		tfLname.setColumns(10);

		tfClass = new JTextField();
		tfClass.setToolTipText("Suberb, World Class, Outstanding...");
		tfClass.setBounds(153, 278, 196, 22);
		panel.add(tfClass);
		tfClass.setColumns(10);

		JLabel lblHeader = new JLabel("Football Legends DataBase 2020");
		lblHeader.setForeground(new Color(255, 215, 0));
		lblHeader.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 23));
		lblHeader.setBounds(34, 29, 361, 27);
		panel.add(lblHeader);

		// Add player
		JButton btnNewButton = new JButton("ADD PLAYER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player newPlayer = new Player();

				String npFname = tfFname.getText();
				String npLname = tfLname.getText();
				String npClass = tfClass.getText();

				newPlayer.setFname(npFname);
				newPlayer.setLname(npLname);
				newPlayer.setClassification(npClass);

				JDBCteam.addPlayer(newPlayer);
				JOptionPane.showMessageDialog(contentPane,
						"Database updated: " + newPlayer.getFname() + " " + newPlayer.getLname() + ", is in the Team.");
				System.out.println(newPlayer.getFname() + " " + newPlayer.getLname() + " added to the Team");
				System.out.println("");
				
				tfFname.setText("");
				tfLname.setText("");
				tfClass.setText("");
			}
		});
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton.setBounds(152, 342, 197, 25);
		panel.add(btnNewButton);

		// Show results
		JButton btnNewButton_2 = new JButton("Show Team");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_Team team = new GUI_Team();
				JDBCteam.loadPlayers();
				team.setVisible(true);
				System.out.println("");

			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(GUI_addPlayer.class.getResource("/img/trophy.png")));
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton_2.setBounds(407, 176, 220, 191);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("Team of Legends");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblNewLabel_2.setBounds(448, 385, 157, 19);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Insert values and add player to the Team of Legends");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_3.setBounds(34, 81, 481, 20);
		panel.add(lblNewLabel_3);
	}
}
