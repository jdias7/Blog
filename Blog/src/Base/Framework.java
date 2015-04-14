package Base;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Framework{

	private JFrame mainFrame;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTextArea postTextArea, postContent;
	private JButton refresh;
	private JButton post;
	private Blog myBlog;
	
	public Framework(){
			
	}
	
	public void setFramework(){
		//initialization of all the components of the frame
		this.mainFrame = new JFrame("Julien Dias");
		this.jLabel = new JLabel("You can still input 140 characters");
		this.jPanel = new JPanel();
		this.postTextArea = new JTextArea("");
		this.postContent = new JTextArea("");
		this.refresh = new JButton("refresh");
		this.post = new JButton("post");
		
		this.myBlog = new Blog(new User(1, "", ""));
		this.mainFrame.setSize(800, 1000);
		//two grid for the two following panels
		this.mainFrame.setLayout(new GridLayout(2,0));
		//the first panel
		this.mainFrame.add(this.jPanel);	
		this.jPanel.setLayout(new BorderLayout());
		this.jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.jPanel.add(this.jLabel, BorderLayout.NORTH);
		this.jPanel.add(this.postTextArea, BorderLayout.CENTER);
		//We create a panel for the buttons
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(0, 2));		
		boutons.add(this.refresh);
		boutons.add(this.post);
		//And we add it to the existing panel
		this.jPanel.add(boutons,BorderLayout.SOUTH);
		//the second panel
		JPanel postC = new JPanel();
		postC.setLayout(new BorderLayout());
		postC.add(this.postContent);
		postC.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		this.mainFrame.add(postC);
		//We make the window visible
		this.mainFrame.setVisible(true);
		
		//register the buttons for event handling
		this.post.addActionListener(new postListener());
		this.refresh.addActionListener(new refreshListener());
		this.postTextArea.addKeyListener(new lengthListener());
	}
	
	class postListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			String content = postTextArea.getText();
			String savefilepath="C:\\Users\\Public\\"+myBlog.getUser().getUserName()+".blog.txt";
			if (postTextArea.getText().length() < 140 && postTextArea.getText().length() > 0) {
				myBlog.load(savefilepath);
				Post p = new Post(new Date(), content);
				myBlog.post(p);
				myBlog.save(savefilepath);
				postContent.setWrapStyleWord(true);
				postContent.setLineWrap(true);
				postContent.append(content);
				postTextArea.setText(null);
			}		
		}
	}
	
	class refreshListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			String savefilepath="C:\\Users\\Public\\"+myBlog.getUser().getUserName()+".blog.txt";
			myBlog.load(savefilepath);
			postContent.setText(myBlog.toString());
			
		}
	}
	
	class lengthListener implements KeyListener{
		
		@Override
		public void keyTyped(KeyEvent e){
			
		}
		
		@Override
		public void keyPressed(KeyEvent e){
			
		}
		
		@Override
		public void keyReleased(KeyEvent e){
			int nbChar = 0;
			if (postTextArea.getText().length() > 140){
				jLabel.setText("Your post length has exceed 140 !");
			}
			else{
				nbChar = 140 - postTextArea.getText().length();
				jLabel.setText("Your can still input " + nbChar);
			}
		}
		
	}
	
}
