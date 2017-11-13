package modules;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class AppScreen extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public AppScreen(int w, int h){
		super();
		
		this.setSize(w, h);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setupComponents();
		this.setupComponents();
		this.setupComponents();
		this.setupComponents();
		
		this.setVisible(true);
	}
	
	public void setupComponents(){
		
		JTextField name = new JTextField();
		name.setText("Robert");
		name.setSize(200, 50);
		name.setBounds(this.getWidth()/2 - name.getWidth()/2, 50, 200, 50);
		
		name.setVisible(true);
		
		this.add(name);
		
	}

}
