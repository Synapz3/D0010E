package Extra10;

/*
 * Av: Marcus Lund
 * 911118-1153
 * TCDAA
 * Bonus 10
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.*;

public class ImageViewer extends JFrame {

	private JLabel imageLabel1;
    private JLabel imageLabel;
	private Icon image1;
	private Icon image2;
	private JButton button;
	URL url1;
	URL url2;
	boolean showFirstPicture = false;
	
	public ImageViewer() {

        try {
            url1 = new URL("http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Teatern.jpg");
            url2 = new URL("http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Vetenskapens-hus.jpg");
            image1 = new ImageIcon(ImageIO.read(url1));
            image2 = new ImageIcon(ImageIO.read(url2));
            imageLabel1 = new JLabel(image1);
            imageLabel = imageLabel1;
            button = new JButton("Change");
		    button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent arg0) {
                    if (showFirstPicture) {
                        showFirstPicture = false;
                        imageLabel.setIcon(image1);
                    } else {
                        showFirstPicture = true;
                        imageLabel.setIcon(image2);
                    }
                }

    		});

            JPanel panel = new JPanel();
            panel.add(imageLabel);
            panel.add(button);
            this.setContentPane(panel);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.pack();
		    this.setLocation(300, 650);
            this.setVisible(true);

		} catch (Exception c) {
            c.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws InterruptedException {
		ImageViewer window = new ImageViewer();
	}
}
