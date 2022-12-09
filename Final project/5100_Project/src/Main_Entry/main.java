package Main_Entry;

import ui.Loginfrm;

public class main {
	public static void main(String args) {
		try {
			Loginfrm frame = new Loginfrm();
			//frame.getContentPane().setBackground(Color.Green);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
