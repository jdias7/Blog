package Test;

import java.util.Date;

import Base.FriendsPost;
import Base.User;

public class TestProject {

	public static void main(String[] args) {
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Date date = new Date();
		String content = "This is my first post";
		FriendsPost postFromFriends = new FriendsPost(date, content, user);
		System.out.println(postFromFriends);
		System.out.println(postFromFriends.contains("first"));
		System.out.println(postFromFriends.contains("HKUST"));	
		
	}

}
