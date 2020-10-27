import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Versiotiedot extends JFrame {

	private JPanel contentPane;

	public Versiotiedot() {
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel prog = new JLabel("JUOMA-AUTOMAATTI V. 1.0");
		prog.setForeground(new Color(255, 0, 0));
		prog.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		prog.setBounds(62, 73, 304, 29);
		contentPane.add(prog);

		JLabel builder = new JLabel("KASAAN R\u00C4PELT\u00C4NYT: TEEMU N\u00C4S\u00C4NEN");
		builder.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		builder.setBounds(62, 131, 305, 19);
		contentPane.add(builder);
	}
}
