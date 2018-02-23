package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import persistence.FileManager;
import views.MainWindow;
import models.Manager;

public class Controller implements ActionListener{

	private Manager manager;
	private MainWindow mainWindow;
	private FileManager fileManager;
	
	public Controller() {
		fileManager = new FileManager();
		try {
			manager = new Manager(fileManager.fileReader());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		mainWindow = new MainWindow(this);
		mainWindow.setLocationRelativeTo(null);
	}
	
	public void addNewUser(){
		manager.addUser(mainWindow.getNewUser());
		mainWindow.clearCamps();
		mainWindow.showDialogAnswers();
		JOptionPane.showMessageDialog(mainWindow, "User add", "Correct", JOptionPane.INFORMATION_MESSAGE);
		mainWindow.fullListUser(manager.getUserList(), this);
		try {
			fileManager.writeFile(manager.getUserList());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD_USER:
			addNewUser();
			break;
		case SHOW_ADD_USER:
			showAddUser();
			break;
		case ACCEPT_ANSWERS:
			acceptAnswers();
			break;
		case SHOW_LOG_IN:
			showLogIn();
			break;
		case LOG_IN:
			logIn();
			break;
		case COMPARE:
			compare(String.valueOf(((JButton)(e.getSource())).getName()));
			break;
		case LOG_OUT:
			logOut();
			break;
		case PHOTO_USER:
			photoUser();
			break;
		}
	}

	private void photoUser() {
		mainWindow.setVisibleFileChooser();
	}

	private void logOut() {
		mainWindow.setWindowDefault();
		manager.setIdInLine(-1);
	}

	private void compare(String id) {
		int value = manager.getCompatibities(Integer.parseInt(id));
		mainWindow.setVisibleResult(this, value, manager.getImgUser(Integer.parseInt(id)));
	}

	private void logIn() {
		boolean verify = manager.verifyUserToLogIn(mainWindow.getUserNameToLogIn(), mainWindow.getPasswordToLogIn());
		if (verify) {
			JOptionPane.showMessageDialog(mainWindow, "Log In", "Correct", JOptionPane.INFORMATION_MESSAGE);
			mainWindow.fullListUser(manager.getUserList(), this);
			mainWindow.setVisibleList();
		}else{
			JOptionPane.showMessageDialog(mainWindow, "UserName or Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void showLogIn() {
		mainWindow.showDialogLogIn();
	}

	private void acceptAnswers() {
		manager.setAnswers(mainWindow.getCheckBoxPets(), mainWindow.getCheckBoxDrinkOrSmoke(), mainWindow.getCheckBoxTravel());
		mainWindow.setVisibleFalseDialogAnswer();
	}

	private void showAddUser() {
		mainWindow.showDialogAddUSer();
	}
}