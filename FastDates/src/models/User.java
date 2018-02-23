package models;

public class User {

	private int id;
	private static int count;
	private String userName;
	private String password;
	private boolean pets;
	private boolean smokeOrDrink;
	private boolean travel;
	private String img;
	
	public User(String userName, String password, String img) {
		this.id = ++count;
		this.userName = userName;
		this.password = password;
		this.img = img;
	}

	public User(String userName, String password, boolean pets,boolean smokeOrDrink, boolean travel, String img) {
		this.id = ++count;
		this.userName = userName;
		this.password = password;
		this.pets = pets;
		this.smokeOrDrink = smokeOrDrink;
		this.travel = travel;
		this.img = img;
	}

	public int getId() {
		return id;
	}
	
	public String getImg() {
		return img;
	}
	
	public static int getCount() {
		return count;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isPets() {
		return pets;
	}
	
	public boolean isSmokeOrDrink() {
		return smokeOrDrink;
	}
	
	public boolean isTravel() {
		return travel;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}

	public void setSmokeOrDrink(boolean smokeOrDrink) {
		this.smokeOrDrink = smokeOrDrink;
	}

	public void setTravel(boolean travel) {
		this.travel = travel;
	}

	@Override
	public String toString() {
		return "UserName => " + userName;
	}
}
