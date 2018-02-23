package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import controllers.Controller;
import controllers.Events;
import models.User;

public class MainWindow extends JFrame {

	private static final String TITLE = "Hello, I love you";
	private static final long serialVersionUID = 1L;
	private JDialogAddUser jDialogAddUser;
	private JDialogAnswers jDialogAnswers;
	private JDialogLogIn jDialogLogIn;
	public static final String URL_ICON = "/img/amor.png";
	private GridBagConstraints c;
	public static final Color RED_COLOR = Color.decode("#8a1327");
	public static final Color WHITE_COLOR = Color.decode("#e4eef2");
	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 20);
	private JPanelCardsUsers jPanelList;
	private JButton jbtnRegistry, jbtnLogIn, jbtnLogOut;
	private JDialogResult jDialogResult;
	private JLabel jlImg; 
	private JScrollPane jScrollPane;
	
	public MainWindow(Controller controller) {
		setTitle(TITLE);
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(RED_COLOR);
		pack();
		setSize(600, 700);
		Image icon = createImageIcon(URL_ICON).getImage();
		setIconImage(icon);
		jDialogAddUser = new JDialogAddUser(controller, this);
		jDialogAnswers = new JDialogAnswers(controller, this);
		jDialogLogIn = new JDialogLogIn(controller, this);
		initGrid();
		initComponents(controller);
		setVisible(true);
	}
	
	private void initComponents(Controller controller) {
		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridwidth = 8;
		JLabel img = new JLabel(new ImageIcon(getClass().getResource("/img/amor2.png")));
		add(img, c);
		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 8;
		c.gridwidth = 2;
		jbtnRegistry = new JButton("Add User");
		jbtnRegistry.setActionCommand(Events.SHOW_ADD_USER.toString());
		jbtnRegistry.addActionListener(controller);
		jbtnRegistry.setForeground(Color.WHITE);
		jbtnRegistry.setBackground(RED_COLOR);
		jbtnRegistry.setFont(FONT_UBUNTU);
		jbtnRegistry.setBorder(null);
		add(jbtnRegistry, c);
		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 10;
		c.gridwidth = 2;
		jbtnLogIn = new JButton("Log In");
		jbtnLogIn.setActionCommand(Events.SHOW_LOG_IN.toString());
		jbtnLogIn.addActionListener(controller);
		jbtnLogIn.setForeground(Color.WHITE);
		jbtnLogIn.setBackground(RED_COLOR);
		jbtnLogIn.setFont(FONT_UBUNTU);
		jbtnLogIn.setBorder(null);
		add(jbtnLogIn, c);
		c.gridy = 0;
		c.weighty = 0.1;
		c.gridx = 10;
		c.gridwidth = 2;
		jbtnLogOut = new JButton("Log Out");
		jbtnLogOut.setActionCommand(Events.LOG_OUT.toString());
		jbtnLogOut.addActionListener(controller);
		jbtnLogOut.setForeground(Color.WHITE);
		jbtnLogOut.setBackground(RED_COLOR);
		jbtnLogOut.setFont(FONT_UBUNTU);
		jbtnLogOut.setBorder(null);
		jbtnLogOut.setVisible(false);
		add(jbtnLogOut, c);
		c.gridy = 1;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridwidth = 12;
		jlImg = new JLabel(new ImageIcon(getClass().getResource("/img/fondo.jpg")));
		add(jlImg, c);
		c.gridy = 1;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridwidth = 12;
		jPanelList = new JPanelCardsUsers();
		jScrollPane = new JScrollPane(jPanelList);
		jScrollPane.setVisible(false);
		add(jScrollPane, c);
	}

	public void showDialogAddUSer(){
		jDialogAddUser.setVisible(true);
	}
	
	public void setVisibleResult(Controller controller, int value, String img){
		jDialogResult = new JDialogResult(controller, this, value, img);
		jDialogResult.setVisible(true);
	}
	
	public void showDialogAnswers(){
		jDialogAnswers.setVisible(true);
	}
	
	public void showDialogLogIn(){
		jDialogLogIn.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void clearCamps(){
		jDialogAddUser.clearCamps();
	}
	
	public void setVisibleList(){
		jbtnLogIn.setVisible(false);
		jbtnRegistry.setVisible(false);
		remove(jlImg);
		jScrollPane.setVisible(true);
		jbtnLogOut.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setWindowDefault(){
		jScrollPane.setVisible(false);
		jbtnLogOut.setVisible(false);
		jbtnLogIn.setVisible(true);
		jbtnRegistry.setVisible(true);
		c.gridy = 1;
		c.weighty = 0.9;
		c.gridx = 0;
		c.gridwidth = 12;
		add(jlImg, c);
		revalidate();
		repaint();
	}
	
	public void fullListUser(ArrayList<User> users, Controller controller){
		jPanelList.fullListUser(users, controller);
		revalidate();
		repaint();
	}
	
	public String getUserNameToLogIn(){
		jDialogLogIn.setVisible(false);
		revalidate();
		repaint();
		return jDialogLogIn.getUserName();
	}
	
	public String getPasswordToLogIn(){
		String password = jDialogLogIn.getPassword();
		jDialogLogIn.clearCamps();
		revalidate();
		repaint();
		return password;
	}
	
	public User getNewUser(){
		jDialogAddUser.setVisible(false);
		revalidate();
		repaint();
		return jDialogAddUser.getNewUser();
	}
	
	public boolean getCheckBoxPets(){
		return jDialogAnswers.getCheckBoxPets();
	}
	
	public boolean getCheckBoxDrinkOrSmoke(){
		return jDialogAnswers.getCheckBoxDrinkOrSmoke();
	}
	
	public boolean getCheckBoxTravel(){
		return jDialogAnswers.getCheckBoxTravel();
	}	
	
	public void setVisibleFalseDialogAnswer(){
		jDialogAnswers.defaultCheckBox();
		jDialogAnswers.setVisible(false);
	}
	
	protected ImageIcon createImageIcon(String path) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	
	public void initGrid() {
		for (int i = 0; i < 12; i++) {
		c.gridx = i;
		add(new JLabel(""), c);
		}
	}
	
	public void setVisibleFileChooser(){
		jDialogAddUser.setVisibleFileChooser();
	}
}