package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import controllers.Controller;

public class JDialogResult extends JDialog {

	private static final long serialVersionUID = 1L;
	public static final Color RED_COLOR = Color.decode("#8a1327");
	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 25);

	public JDialogResult(Controller controller, MainWindow mainWindow, int value, String img) {
		super(mainWindow, true);
		setLayout(new FlowLayout());
		setSize(370, 320);
		getContentPane().setBackground(RED_COLOR);
		setLocationRelativeTo(mainWindow);
		JLabel jlImg = new JLabel();
		ImageIcon fot = new ImageIcon(img);
		jlImg.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jlImg.setPreferredSize(new Dimension(200, 200));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		jlImg.setIcon(icono);
		add(jlImg);
		JLabel jlInformation = new JLabel("its compatibility is");
		jlInformation.setFont(FONT_UBUNTU);
		jlInformation.setForeground(Color.WHITE);
		add(jlInformation, BorderLayout.CENTER);
		JProgressBar jProgressBar = new JProgressBar(0, 100);
		jProgressBar.setValue(value);
		add(jProgressBar);
		JLabel jlProgressValue = new JLabel(value + "%");
		jlProgressValue.setFont(FONT_UBUNTU);
		jlProgressValue.setForeground(Color.WHITE);
		add(jlProgressValue);
	}
}