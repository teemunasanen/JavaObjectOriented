
public class GUI_automaatin_testaus {

	public static void main(String[] args) {
		
		// Huomaa, ett� Juoma-automaatti-luokkaa voidaan k�ytt�� my�s toisesta luokasta k�sin
		
		JuomaAutomaatti ja = new JuomaAutomaatti();
		GUI_Automaatti x = new GUI_Automaatti( ja );
		x.setVisible(true);
		

	}

}
