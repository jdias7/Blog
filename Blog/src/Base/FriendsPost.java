package Base;

import java.util.Date;

public class FriendsPost extends Post {

	private User friend;
	
	public FriendsPost(Date date, String content) {
		super(date, content);
	}

	public FriendsPost(Date date, String content, User user) {
		super(date, content);
		// TODO Auto-generated constructor stub
	}



	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}
	
//	@Override
//	/**
//	 * @return boolean
//	 */
//	public boolean contains(String keyword) {
//		System.out.println(this.content);
//		if (this.content == keyword){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}



	
	
}
