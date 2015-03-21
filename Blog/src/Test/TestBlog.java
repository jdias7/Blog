package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import Base.*;

public class TestBlog {

	public String getInput(){
		String line = "";
		System.out.println("Enter the prompt");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;			
	}
		
	public static void main(String[] args) {
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		while(!(prompt = testBlog.getInput()).equals("exit")){
			if (prompt.startsWith("list")){
				myblog.list();
			}
			else if(prompt.startsWith("post")){
				Date today = new Date();
				Post p = new Post(today, prompt.substring(5));
				myblog.post(p);
			}
			else if(prompt.startsWith("delete")){
				String[] parts = prompt.split(" ");
				myblog.delete(Integer.parseInt(parts[1]));
			}
		}

	}

}
