import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
public class SignInScreen {
	
	private static JPanel signInScreen;
	private static JTextField userBox;
	private static JPasswordField passBox;
	public SignInScreen() {
		screenLayout();
		createTextBox();
		imageLoad();
		labelLoad();
		buttonLoad();
		screenAdd();
	}
	
	public static void screenLayout() {
		signInScreen = SwingHelper.createPanel(new Color(194, 248, 198));
	}
	
	public static void imageLoad() {
		for (int i = 20; i < aa.width; i+= 200) {
        	for(int j = 20; j < aa.height; j+= 200) {
        		if (!((i==820 && j==20) || ((i==220 || i==420) && j==220) || (i==220 && j==420)))
        			SwingHelper.createImage("https://img.icons8.com/cotton/100/000000/banana.png", 50, 50, i, j, 100, 100, signInScreen);
        	}
        }
	}
	
	public static void labelLoad() {
		SwingHelper.createLabel("Welcome Back!", new Color(60, 59, 195), new Font("TimesRoman", Font.BOLD + Font.ITALIC, 80), aa.width/2-370, 50, 600, 200, signInScreen);
        
        SwingHelper.createLabel("In order to start shopping", new Color(0, 0, 0), new Font("Apple Casual", Font.BOLD, 30), aa.width/2-300, 250, 500, 50, signInScreen);
        
        SwingHelper.createLabel("you must first sign in.", new Color(0, 0, 0), new Font("Apple Casual", Font.BOLD, 30), aa.width/2-270, 300, 400, 50, signInScreen);
        
        SwingHelper.createLabel("USERNAME:", new Color(145, 135, 207), new Font("Courier", Font.BOLD, 25), aa.width/2-350, 425, 200, 40, signInScreen);
        
        SwingHelper.createLabel("PASSWORD:", new Color(145, 135, 207), new Font("Courier", Font.BOLD, 25), aa.width/2-350, 495, 200, 40, signInScreen);
	}
	
	public static void buttonLoad() {
		 
		//login button
        JButton button = new JButton("Log In");
        button.setFont(button.getFont().deriveFont(30.0f));
        button.setBounds(aa.width/2-120, 600, 200, 50);
        signInScreen.add(button);
        
        button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("Button clicked");
    			String user = userBox.getText();
    			String password = new String(passBox.getPassword());
    			System.out.println(user + password);
    			Login x = new Login(user, password);
    			
    			int a = x.match(aa.users);
    			if(a==0) {
    				SwingHelper.createLabel("Incorrect Password", Color.red, new Font("TimesRoman", Font.BOLD, 15), 50, 100, 140, 30, signInScreen);
    			}
    			else if(a==-1) 
    				SwingHelper.createLabel("User Not Found", Color.red, new Font("TimesRoman", Font.BOLD, 15), 50, 100, 140, 30, signInScreen);
    			else
    				new HomeScreen();
    		}
    	});
        
        
        try{
            BufferedImage logo = ImageIO.read(new URL("http://img.icons8.com/nolan/100/shopping-cart.png"));
            Icon c = new ImageIcon(logo);
            JButton back = new JButton(c);
            back.setBounds(aa.width-200, 50, 120, 120);
            signInScreen.add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userBox.setText("");
                    passBox.setText("");
                    new WelcomeScreen();
                }
            });
        }catch (IOException e){
            System.out.println(e);
        }
        
	}
	
	public static void createTextBox() {
		userBox = SwingHelper.createTextBox(aa.width/2-200, 430, 300, 40, signInScreen);
        
        passBox = new JPasswordField();
        passBox.setBounds(aa.width/2-200, 500, 300, 40);
        signInScreen.add(passBox);
	}
	
	public static void screenAdd() {
		 aa.background.setLayout(aa.card);
	     aa.background.add(signInScreen,"2");
	     aa.card.show(aa.background, "2");
	     aa.frame.setVisible(true);
	}
}
