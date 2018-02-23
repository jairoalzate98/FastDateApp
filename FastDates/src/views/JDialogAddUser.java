package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.Events;
import models.User;

public class JDialogAddUser extends JDialog {

	public static final String CANCEL_JBUTTON = "Cancel";
	public static final String ACCEPT_JBUTTON = "Accept";
	public static final String PASSWORD_JLABEL = "Enter your password";
	public static final String USER_NAME_JLABEL = "Enter your UserName";
	private static final long serialVersionUID = 1L;
	private JTextField jtfUserName;
	private JPasswordField jtfPassword;
	private JButton jbtnAccept;
	public static final Color RED_COLOR = Color.decode("#8a1327");
	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 20);
	private JLabel jlImg;
	private JButton jbtnImg;
	private ImageIcon fot;

	public JDialogAddUser(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new FlowLayout());
		setSize(370, 435);
		setLocationRelativeTo(mainWindow);
		jlImg = new JLabel();
		jlImg.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jlImg.setPreferredSize(new Dimension(170, 170));
		add(jlImg);
		jbtnImg = new JButton("Photo");
		jbtnImg.addActionListener(controller);
		jbtnImg.setActionCommand(Events.PHOTO_USER.toString());
		jbtnImg.setForeground(Color.WHITE);
		jbtnImg.setBackground(RED_COLOR);
		jbtnImg.setFont(FONT_UBUNTU);
		jbtnImg.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jbtnImg.setPreferredSize(new Dimension(200, 30));
		add(jbtnImg);
		JLabel jlUserName = new JLabel(USER_NAME_JLABEL);
		jlUserName.setForeground(Color.WHITE);
		jlUserName.setFont(FONT_UBUNTU);
		add(jlUserName);
		jtfUserName = new JTextField(20);
		jtfUserName.setForeground(Color.WHITE);
		jtfUserName.setFont(FONT_UBUNTU);
		jtfUserName.setOpaque(false);
		add(jtfUserName);
		JLabel jlPassword = new JLabel(PASSWORD_JLABEL);
		jlPassword.setForeground(Color.WHITE);
		jlPassword.setFont(FONT_UBUNTU);
		add(jlPassword);
		jtfPassword = new JPasswordField(20);
		jtfPassword.setForeground(Color.WHITE);
		jtfPassword.setFont(FONT_UBUNTU);
		jtfPassword.setOpaque(false);
		add(jtfPassword);
		jbtnAccept = new JButton(ACCEPT_JBUTTON);
		jbtnAccept.addActionListener(controller);
		jbtnAccept.setActionCommand(Events.ADD_USER.toString());
		jbtnAccept.setForeground(Color.WHITE);
		jbtnAccept.setBackground(RED_COLOR);
		jbtnAccept.setFont(FONT_UBUNTU);
		add(jbtnAccept);
		getContentPane().setBackground(RED_COLOR);
	}
	
	public void clearCamps(){
		jtfPassword.setText("");
		jtfUserName.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public User getNewUser(){
		return new User(jtfUserName.getText(), jtfPassword.getText(), fot.getDescription());
	}
	
	
	public String setVisibleFileChooser(){
		JFileChooser jFileChooser = new JFileChooser();
		String path="";
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			path = file.getPath();
		}
		fot = new ImageIcon(path);
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jlImg.getWidth(), jlImg.getHeight(), Image.SCALE_DEFAULT));
		jlImg.setIcon(icono);
		return path;
	}
}