package Base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userEmail=" + userEmail + "]";
	}

	private int userID;
	private String userName;
	private String userEmail;
	
	public User(int i, String string, String string2) {
		this.userID = i;
		this.userName = string;
		this.userEmail = string2;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public int compareTo(User u){
		if (this.userID > u.userID){
			return 1;
		}
		else if (this.userID == u.userID){
			return 0;
		}
		else{
			return -1;
		}
	}

}
