import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitellään täällä jotta komponentteihin voidaan viitata mistä tahansa luokan
	// sisältä

	private JPanel contentPane;
	private JMenuItem saveMachine;
	private JMenuItem loadMachine;
	private JMenuItem info;
	private JMenuItem shutDown;
	private JMenuBar menuBar;
	private JMenu Setup;
	private JMenuItem fillCoffee;
	private JMenuItem fillCocoa;
	private JMenuItem fillTea;
	private JMenuItem versio;
	private JMenuItem howTo;

	private JButton coffeeButton;
	private JButton teaButton;
	private JButton cocoaButton;
	private JLabel coffeeLabel;
	private JLabel teaLabel;
	private JLabel cocoaLabel;
	private JLabel coffeeLeft;
	private JLabel teaLeft;
	private JLabel cocoaLeft;

	/**
	 * Main-metodi, joka käynnistää sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// Käyttöliittymä saa parametrina olion, jonka tiedot se näyttää
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan käyttöliittymä. Huomaa, että otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. Tämä siksi, että voidaan näyttää sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		Setup = new JMenu("Yll\u00E4pito");
		menuBar.add(Setup);

		fillCoffee = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		fillCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna kahvin uusi arvo: ");
						int uusiKahvi = Integer.parseInt(uusiArvo);
						if (uusiKahvi >= 0) {
							ja.setKahvi(uusiKahvi);
							coffeeLeft.setText("Kahvia: " + ja.getKahvi());
							if (ja.getKahvi() < 20) {
								coffeeLeft.setForeground(Color.red);
							} else {
								coffeeLeft.setForeground(Color.black);
							}
							break;
						} else if (uusiKahvi < 0) {
							JOptionPane.showMessageDialog(null, "Määrä ei voi olla negatiivinen!");
							continue;
						}
					}
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Error: Numbers only");
				}
			}
		});
		Setup.add(fillCoffee);

		fillTea = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		fillTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna teen uusi arvo: ");
						int uusiTee = Integer.parseInt(uusiArvo);
						if (uusiTee >= 0) {
							ja.setTee(uusiTee);
							teaLeft.setText("Teetä: " + ja.getTee());
							if (ja.getTee() < 20) {
								teaLeft.setForeground(Color.red);
							} else {
								teaLeft.setForeground(Color.black);
							}
							break;
						} else if (uusiTee < 0) {
							JOptionPane.showMessageDialog(null, "Määrä ei voi olla negatiivinen!");
							continue;
						}
					}
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Error: Numbers only");
				}
			}
		});
		Setup.add(fillTea);

		fillCocoa = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		fillCocoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna kaakaon uusi arvo: ");
						int uusiKaakao = Integer.parseInt(uusiArvo);
						if (uusiKaakao >= 0) {
							ja.setKaakao(uusiKaakao);
							cocoaLeft.setText("Kaakaota: " + ja.getKaakao());
							if (ja.getKaakao() < 20) {
								cocoaLeft.setForeground(Color.red);
							} else {
								cocoaLeft.setForeground(Color.black);
							}
							break;
						} else if (uusiKaakao < 0) {
							JOptionPane.showMessageDialog(null, "Määrä ei voi olla negatiivinen!");
							continue;
						}
					}
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Error: Numbers only");
				}
			}
		});
		Setup.add(fillCocoa);

		saveMachine = new JMenuItem("Tallenna automaatin tila");
		saveMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (Exception w) {
					System.out.println("Error: save out of options");
				}
			}
		});
		Setup.add(saveMachine);

		loadMachine = new JMenuItem("Lataa automaatti");
		loadMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					ja.setKahvi(uusi.getKahvi());
					coffeeLeft.setText("Kahvia: " + uusi.getKahvi());
					if (ja.getKahvi() < 20) {
						coffeeLeft.setForeground(Color.red);
					} else {
						coffeeLeft.setForeground(Color.black);
					}
					ja.setTee(uusi.getTee());
					teaLeft.setText("Teetä: " + uusi.getTee());
					if (ja.getTee() < 20) {
						teaLeft.setForeground(Color.red);
					} else {
						teaLeft.setForeground(Color.black);
					}
					ja.setKaakao(uusi.getKaakao());
					cocoaLeft.setText("Kaakaota: " + uusi.getKaakao());
					if (ja.getKaakao() < 20) {
						cocoaLeft.setForeground(Color.red);
					} else {
						cocoaLeft.setForeground(Color.black);
					}
				} catch (Exception l) {
					System.out.println("Error: Loading not possible");
				}
			}
		});
		Setup.add(loadMachine);

		shutDown = new JMenuItem("Lopeta");
		shutDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Setup.add(shutDown);

		info = new JMenu("Tietoja ohjelmasta");
		menuBar.add(info);

		versio = new JMenuItem("Versiotiedot");
		versio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);
			}
		});
		info.add(versio);

		howTo = new JMenuItem("Ohje");
		howTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = "";
				try {
					while (true) {
						email = JOptionPane.showInputDialog(null, "Please, insert your email: ");
						if (email.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Quit messing around");
							continue;
						}
						break;

					}
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, "Quit messing around");
				}
				JOptionPane.showMessageDialog(null, "Thank you!\nInformation will be sent to your email:\n" + email);
			}
		});

		info.add(howTo);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		coffeeButton = new JButton("Kahvi");
		coffeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKahvi();

				coffeeLeft.setText("Kahvia: " + ja.getKahvi());

				if (ja.getKahvi() < 20) {
					coffeeLeft.setForeground(Color.RED);
				}

			}
		});
		coffeeButton.setBackground(Color.WHITE);
		coffeeButton.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/coffee.jpg")));
		coffeeButton.setBounds(27, 56, 139, 132);
		contentPane.add(coffeeButton);

		teaButton = new JButton("Tee");
		teaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaTee();

				teaLeft.setText("Teetä: " + ja.getTee());

				if (ja.getTee() < 20) {
					teaLeft.setForeground(Color.RED);
				}
			}
		});
		teaButton.setBackground(Color.WHITE);
		teaButton.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/tea.jpg")));
		teaButton.setBounds(27, 246, 139, 132);
		contentPane.add(teaButton);

		cocoaButton = new JButton("Kaakao");
		cocoaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();

				cocoaLeft.setText("Kaakaota: " + ja.getKaakao());

				if (ja.getKaakao() < 20) {
					cocoaLeft.setForeground(Color.RED);
				}
			}
		});
		cocoaButton.setBackground(Color.WHITE);
		cocoaButton.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/cocoa.jpg")));
		cocoaButton.setBounds(27, 449, 139, 132);
		contentPane.add(cocoaButton);

		coffeeLeft = new JLabel("Kahvia: " + ja.getKahvi());
		coffeeLeft.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		coffeeLeft.setBounds(240, 113, 132, 16);
		contentPane.add(coffeeLeft);

		teaLeft = new JLabel("Teet\u00E4: " + ja.getTee());
		teaLeft.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		teaLeft.setBounds(240, 308, 132, 16);
		contentPane.add(teaLeft);

		cocoaLeft = new JLabel("Kaakaota: " + ja.getKaakao());
		cocoaLeft.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		cocoaLeft.setBounds(240, 506, 132, 19);
		contentPane.add(cocoaLeft);

		coffeeLabel = new JLabel("Kahvi");
		coffeeLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		coffeeLabel.setBounds(73, 200, 37, 19);
		contentPane.add(coffeeLabel);

		teaLabel = new JLabel("Tee");
		teaLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		teaLabel.setBounds(73, 394, 26, 19);
		contentPane.add(teaLabel);

		cocoaLabel = new JLabel("Kaakao");
		cocoaLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		cocoaLabel.setBounds(64, 593, 49, 19);
		contentPane.add(cocoaLabel);
	}
}
