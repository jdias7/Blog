package Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable {

	protected Date date;
	protected String content;
	
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
		return "Post dated from : " + this.date + " and which content is : " + this.content;
	}
	
	@Override
	/* @param Object obj
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		return true;
	}
	
	@Override
	/* 
	 * @return int
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}
	
	/**
	 * 
	 * @param String keyword
	 * @return boolean
	 */
	public boolean contains(String keyword){

		if (this.content.contains(keyword)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int compareTo(Post p){
		if (p.date.compareTo(this.date) == 1){
			return -1;
		}
		else if (p.date.compareTo(this.date) == 0){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	
	
}
