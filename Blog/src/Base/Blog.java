package Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Blog implements Serializable {

	private User user;
	private ArrayList<Post> allPosts;
	
	public ArrayList<Post> getPosts() {
		return allPosts;
	}

	public void setPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}

	/**
	 * 
	 * @param user
	 */
	public Blog(User user){
		this.setUser(user);
		this.allPosts = new ArrayList<Post>();
	}
	
	/**
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Create a new post in your blog
	 * @param p
	 */
	public void post(Post p){
		this.allPosts.add(p);
		if (this.allPosts.contains(p)){
			System.out.println("It's OK");
		}
		
	}
	
	/**
	 * List all the post in your blog
	 */
	public void list(){

		Iterator<Post> it = this.allPosts.iterator();
 
		while (it.hasNext()) {
		Post p = it.next();
		System.out.println(p.toString());	
		}
	}
	
	/**
	 * Delete a post from your blog
	 * @param index
	 */
	public void delete(int index){
		if (index >= 0 && index <= this.allPosts.size()){
			this.allPosts.remove(index);
		}
		else{
			System.out.println("Can not delete these post, wrong index");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Iterator<Post> it = this.allPosts.iterator();
		while (it.hasNext()){
		Post p = it.next();
		result = prime * result
				+ ((p == null) ? 0 : p.hashCode());
		}
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String result;
		result = "Blog [user=" + user + "]" + "\n"; 
		Iterator<Post> it = this.allPosts.iterator();
		while (it.hasNext()){
			Post p = it.next();
			result = result + p.toString() + "\n";
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (!this.allPosts.containsAll(other.allPosts)){
			return false;
		}
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
}
