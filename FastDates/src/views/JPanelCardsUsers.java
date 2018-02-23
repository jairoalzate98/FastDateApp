package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controllers.Controller;
import models.User;

public class JPanelCardsUsers extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final Color RED_COLOR = Color.decode("#8a1327");

	public void fullListUser(ArrayList<User> users, Controller controller) {
		removeAll();
		setBackground(RED_COLOR);
		int rows = 0;
		if (users.size()%2 != 0) {
			rows = (users.size()/2) + 1;
		}else {
			rows = users.size()/2;
		}
		setLayout(new GridLayout(rows, 2, 70, 20));
		for (User user : users) {
			add(new JPanelCard(controller, user));
		}
	}
}