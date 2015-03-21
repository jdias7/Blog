package Base;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post>{
	
	@Override
	public int compare(Post p1, Post p2){
		if (p1.content.length() < p2.content.length()){
			return -1;
		}
		else if (p1.content.length() == p2.content.length()){
			return 0;
		}
		else{
			return 1;
		}
	}

}
