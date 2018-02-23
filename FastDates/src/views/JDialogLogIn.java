package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.Events;

public class JDialogLogIn extends JDialog {

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

	public JDialogLogIn(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new FlowLayout());
		setSize(370, 220);
		setLocationRelativeTo(mainWindow);
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
		jbtnAccept.setActionCommand(Events.LOG_IN.toString());
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
	
	public String getUserName(){
		return jtfUserName.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword(){
		return jtfPassword.getText();
	}
}