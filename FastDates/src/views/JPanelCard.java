package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.User;
import controllers.Controller;
import controllers.Events;

public class JPanelCard extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final Color RED_COLOR = Color.decode("#8a1327");
	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 23);
	public static final String COMPARE_TEXT = "Compare";

	public JPanelCard(Controller controller, User user) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(RED_COLOR);
		JLabel jlImg = new JLabel("", SwingConstants.CENTER);
		ImageIcon fot = new ImageIcon(user.getImg());
		jlImg.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jlImg.setPreferredSize(new Dimension(200, 200));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		jlImg.setIcon(icono);
		add(jlImg);
		JLabel jlUserName = new JLabel(user.getUserName(), SwingConstants.CENTER);
		jlUserName.setForeground(Color.WHITE);
		jlUserName.setBackground(RED_COLOR);
		jlUserName.setFont(FONT_UBUNTU);
		add(jlUserName);
		JButton jbtnSearch = new JButton(COMPARE_TEXT);
		jbtnSearch.setActionCommand(Events.COMPARE.toString());
		jbtnSearch.setName(String.valueOf(user.getId()));
		jbtnSearch.addActionListener(controller);
		jbtnSearch.setForeground(Color.WHITE);
		jbtnSearch.setBackground(RED_COLOR);
		jbtnSearch.setFont(FONT_UBUNTU);
		add(jbtnSearch);
	}
}