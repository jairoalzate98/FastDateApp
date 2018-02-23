package models;

import java.util.ArrayList;

public class Manager {

	private ArrayList<User> userList;
	private int idInLine;
	
	public Manager(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	public static User createUser(String userName, String password, String img){
		return new User(userName, password, img);
	}
	
	public void addUser(User user){
		userList.add(user);
	}

	public int getIdInLine() {
		return idInLine;
	}

	public void setIdInLine(int idInLine) {
		this.idInLine = idInLine;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public void setAnswers(boolean pets, boolean drinkOrSmoke, boolean travel){
		userList.get(userList.size() - 1).setPets(pets);
		userList.get(userList.size() - 1).setSmokeOrDrink(drinkOrSmoke);
		userList.get(userList.size() - 1).setTravel(travel);
	}
	
	public boolean verifyUserToLogIn(String userName, String password){
		for (int i = 0; i < userList.size(); i++){
			if (userList.get(i).getUserName().equals(userName)) {
				if (userList.get(i).getPassword().equals(password)) {
					setIdInLine(userList.get(i).getId());
					return true;
				}
			}
		}
		return false;
	}
	
	public int getCompatibities(int id){
		User u = null;
		int count = 0;
		for (User user: userList) {
			if (user.getId() == idInLine) {
				u = user;
			}
		}
		for (User user: userList) {
			if (user.getId() == id) {
				if(user.isPets() == u.isPets()){
					count++;
				}
				if(user.isSmokeOrDrink() == u.isSmokeOrDrink()){
					count++;
				}
				if(user.isTravel() == u.isTravel()){
					count++;
				}
			}
		}
		return getResult(count);
	}
	
	public int getResult(int count){
		if (count == 0) {
			return 0;
		}else if(count == 1){
			return 33;
		}else if(count == 2){
			return 66;
		}else{
			return 100;
		}
	}
	
	public String getImgUser(int id){
		String img = "";
		for (User user: userList) {
			if (user.getId() == id) {
				img = user.getImg();
			}
		}
		return img;
	}
}