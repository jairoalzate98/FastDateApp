package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.User;

public class FileManager {

	public ArrayList<User> fileReader() throws IOException{
		ArrayList<User> userList = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/persistence/users.txt")));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			userList.add(new User(information[0], information[1], convertToBoolean(information[2]), convertToBoolean(information[3]), convertToBoolean(information[4]), information[5]));
		}
		bufferedReader.close();
		return userList;
	}
	
	public boolean convertToBoolean(String text){
		if (text.equals("true")) {
			return true;
		}
		return false;
	}
	
	public void writeFile(ArrayList<User> userList) throws IOException{
		File file = new File("src/persistence/users.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (User user : userList) {
			bufferedWriter.write(user.getUserName() + "," + user.getPassword() + "," + String.valueOf(user.isPets()) + "," + String.valueOf(user.isSmokeOrDrink()) + "," + String.valueOf(user.isTravel()) + "," + String.valueOf(user.getImg()));
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
}