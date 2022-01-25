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
public class SignUpScreen {
	
	private static JPanel signUpScreen;
	private static JTextField userBox;
	private static JTextField passBox;
	private static JTextField nameBox;
	public SignUpScreen() {
		screenLayout();
		createTextBox();
		imageLoad();
		buttonLoad();
		labelLoad();
		screenAdd();
	}
	
	public static void screenLayout() {
		signUpScreen = SwingHelper.createPanel(new Color(249, 250, 176));
	}
	
	public static void imageLoad() {
		for (int i = 20; i < aa.width; i+= 200) {
        	for(int j = 20; j < aa.height; j+= 200) {
        		if (!(i==820 && j==20) && !((i==20||i==220) && j==420))
        			SwingHelper.createImage("https://img.icons8.com/cotton/64/000000/orange--v1.png", 50, 50, i, j, 100, 100, signUpScreen);
        	}
        }
	}
	
	public static void labelLoad() {
		SwingHelper.createLabel("ENTER A USERNAME:", new Color(145, 135, 207), new Font("Courier", Font.BOLD, 20), aa.width/2-420, 425, 300, 40, signUpScreen);
        
        SwingHelper.createLabel("ENTER A PASSWORD:", new Color(145, 135, 207), new Font("Courier", Font.BOLD, 20), aa.width/2-420, 495, 300, 40, signUpScreen);
        
        SwingHelper.createLabel("FIRST & LAST NAME:", new Color(145, 135, 207), new Font("Courier", Font.BOLD, 20), aa.width/2-420, 355, 300, 40, signUpScreen);
        
        SwingHelper.createLabel("Welcome To The App!", new Color(60, 59, 195), new Font("TimesRoman", Font.BOLD + Font.ITALIC, 70), aa.width/2-400, 50, 800, 200, signUpScreen);
        
        SwingHelper.createLabel("Grocer-E lets you order produce and other foods online, with no hassle", new Color(0, 0, 0), new Font("Apple Casual", Font.BOLD, 20), aa.width/2-400, 200, 800, 50, signUpScreen);
        
        SwingHelper.createLabel("Due to the COVID-19 pandemic, Grocer-E has adapted its business efforts", new Color(200, 50, 50), new Font("Apple Casual", Font.BOLD, 15), aa.width/2-320, 290, 800, 50, signUpScreen);
        
        SwingHelper.createLabel("to encourage communal aid in buying groceries.", new Color(200, 50, 50), new Font("Apple Casual", Font.BOLD, 15), aa.width/2-230, 310, 800, 50, signUpScreen);
	}
	
	public static void buttonLoad() {
		//signup button
        JButton button = new JButton("Sign up");
        button.setFont(button.getFont().deriveFont(30.0f));
        button.setBounds(aa.width/2-120, 600, 200, 50);
        signUpScreen.add(button);
        
        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr = userBox.getText();
				String addr = passBox.getText();
    			String name = new String(nameBox.getText());

				aa.users.add(new Login(usr, addr, name));
				// THIS TELLS YOU ALL THE USERS SIGNED UP, WE CAN DELETE IT IF WE WANT TO
				new SignInScreen();
			}
		});
        
        try{
            BufferedImage logo = ImageIO.read(new URL("http://img.icons8.com/nolan/100/shopping-cart.png"));
            Icon c = new ImageIcon(logo);
            JButton back = new JButton(c);
            back.setBounds(aa.width-200, 50, 120, 120);
            signUpScreen.add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passBox.setText("");
                    userBox.setText("");
                    new WelcomeScreen();
                }
            });
        }catch (IOException e){
            System.out.println(e);
        }
	}
	
	public static void createTextBox() {
		userBox = SwingHelper.createTextBox(aa.width/2-200, 430, 300, 40, signUpScreen);
        nameBox = SwingHelper.createTextBox(aa.width/2-200, 360, 300, 40, signUpScreen);
        passBox = SwingHelper.createTextBox(aa.width/2-200, 500, 300, 40, signUpScreen);
	}
	
	public static void screenAdd() {
		aa.background.setLayout(aa.card);
        aa.background.add(signUpScreen,"3");
        aa.card.show(aa.background, "3");
        aa.frame.setVisible(true);
	}
}
