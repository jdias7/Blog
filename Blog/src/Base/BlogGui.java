package Base;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGui implements ActionListener {
	
	private JFrame mainFrame;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	
	public BlogGui(String name, String postTextArea, String postContent, String refresh, String post, String label ){
		
		//initialization of all the components of the frame
		this.mainFrame = new JFrame(name);
		this.jLabel = new JLabel(label);
		this.jPanel = new JPanel();
		this.postTextArea = new JTextArea(postTextArea);
		this.postContent = new JTextField(postContent);
		this.refresh = new JButton(refresh);
		this.post = new JButton(post);
		
		//register the buttons for event handling
		this.post.addActionListener(this);
		this.refresh.addActionListener(this);
	}
	
	/**
	 * Creation of the window
	 */
	public void setWindow(){
	
		this.mainFrame.setSize(800, 1000);
		//two grid for the two folowwing panels
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
		
	}
	
	@Override
	/**
	 * Handle the events
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.post){
			this.postContent.setText("You clicked post");
		}
		else if (e.getSource() == this.refresh){
			this.postContent.setText("You clicked refresh");
		}
		else{
			return;
		}
	}
	
	public static void main(String[] args) {
		BlogGui blogGui = new BlogGui("Julien", "What's on your mind ?", "Here is put my post", "refresh", "post", "You can input 140 characters");
		blogGui.setWindow();
	}

}
