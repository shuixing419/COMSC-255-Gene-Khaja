package as1;

import javax.swing.JOptionPane;

public class Message {

	public static void main(String[] args) {
		String msg;

		msg="Today is a good day.\n";

		msg=msg + "I am learning Java programming.\n";

		msg=msg + "It’s a lot of fun.\n";

		JOptionPane.showMessageDialog (null, msg);

	}

}