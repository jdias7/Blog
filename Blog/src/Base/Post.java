package Base;
import java.util.Date;

public class Post {

	private Date date;
	private String content;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	/**
	 * @return the content of the blog
	 */
	public String getContent(){
		return this.content;
	}
	
	/**
	 * @param content
	 */
	
	public void setContent(String content){
		this.content = content;
	}
	
	@Override
	/**
	 * output this object in string for;qt
	 * @return string
	 */
	public String toString(){
		return "Post dqted from : " + this.date + " and which content is ; " + this.content;
	}
	
	//@Override
	/**
	 * 
	 */
	//public boolean equals(Object o){
		
	//}
}
