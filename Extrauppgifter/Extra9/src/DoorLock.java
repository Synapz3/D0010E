/**
 * 
 * @author Marcus Lund
 * 911118-1153
 * TCDAA
 * D0010E
 */
package Extra9;

import java.awt.event.*;

import javax.swing.*;

public class DoorLock {
	public static void main(String[] args) {
		FriendlyDoorLock.main(args);
	}
}

class FriendlyDoorLock {

	public static void main(String argv[]) {
		JFrame frame = new JFrame("Door Lock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(); // the "background"
		JLabel label = new JLabel("Enter PIN (4 digits):");
		JTextField text = new JTextField("", 5);
		JLabel number = new JLabel("-------------------");

		panel.add(label);
		panel.add(text);
		panel.add(number);
		frame.setContentPane(panel); // connect panel to frame
		
		text.addActionListener(new InputHandler(text, number));
		
		frame.pack();
		frame.setVisible(true);
	}
}

class InputHandler implements ActionListener {
	private JTextField text;
	private Integer pin;
	private JLabel number;

	public InputHandler(JTextField text, JLabel number) {
		this.pin = (int) (Math.random() * 10000);
		if (pin == 10000) {
			pin = 0000;
		}
		System.out.println(pin);
		this.text = text;
		this.number = number;
	}

	// called when the return key is depressed
	public void actionPerformed(ActionEvent arg0) {
		int inputPin = Integer.parseInt(text.getText());

		if (inputPin == pin) {
			System.out.println(0);
			number.setText("Thats it! :D");
		}
		if (inputPin < pin) {
			System.out.println(1);
			number.setText(" To low!");
		}
		if (inputPin > pin) {
			System.out.println(2);
			number.setText(" To high!");
		}
		System.out.println(text.getText()); // print in console
		text.setText(""); // empty the text field
	}
}
