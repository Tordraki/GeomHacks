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


public class WelcomeScreen {
	private static JPanel welcomeScreen;
	
	public WelcomeScreen() {
		screenLayout();
		imageLoad();
		labelLoad();
		buttonLoad();
		screenAdd();
	}
	
	public static void screenLayout() {
		welcomeScreen = SwingHelper.createPanel(new Color(200, 250, 240));
	}
	
	public static void imageLoad() {
		SwingHelper.createImage("https://img.icons8.com/nolan/100/shopping-cart.png", 120, 120, aa.width-230, 40, 160, 160, welcomeScreen);
        
        SwingHelper.createImage("https://img.icons8.com/emoji/100/000000/carrot-emoji.png", 150, 150, aa.width/2-400, 500, 200, 200, welcomeScreen);
        
        SwingHelper.createImage("https://img.icons8.com/color/100/000000/lettuce.png", 150, 150, aa.width/2-200, 500, 200, 200, welcomeScreen);
        
        SwingHelper.createImage("https://img.icons8.com/cotton/100/000000/watermelon--v2.png", 150, 150, aa.width/2, 500, 200, 200, welcomeScreen);
        
        SwingHelper.createImage("https://img.icons8.com/cotton/100/000000/ham.png", 150, 150, aa.width/2+200, 500, 200, 200, welcomeScreen);
	}
	
	public static void labelLoad() {
		SwingHelper.createLabel("Order fresh produce...", new Color(86, 46, 136), new Font("Impact", Font.BOLD, 40), aa.width/2-300, 300, 400, 60, welcomeScreen);
        
        SwingHelper.createLabel("With the click of a button!", new Color(86, 46, 136), new Font("Impact", Font.BOLD, 40), aa.width/2-350, 400, 500, 60, welcomeScreen);
        
        SwingHelper.createLabel("New to the business?", new Color(85, 179, 127), new Font("Lucida Handwriting", Font.ITALIC, 20), aa.width-250, 290, 400, 70, welcomeScreen);
        
        SwingHelper.createLabel("Returning customer?", new Color(85, 179, 127), new Font("Lucida Handwriting", Font.ITALIC, 20), aa.width-250, 180, 400, 70, welcomeScreen);
        
        SwingHelper.createLabel("Grocer-E", new Color(60, 59, 195), new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 130), aa.width/2-400, 20, 800, 200, welcomeScreen);
	}
	
	public static void buttonLoad() {
		//login button
        JButton toSignIn = new JButton("Log In Here");
        toSignIn.setFont(toSignIn.getFont().deriveFont(10.0f));
        toSignIn.setBounds(aa.width-210, 240, 100, 50);
        welcomeScreen.add(toSignIn);
        
        //signup button
        JButton toSignUp = new JButton("Sign Up");
        toSignUp.setFont(toSignUp.getFont().deriveFont(10.0f));
        toSignUp.setBounds(aa.width-210, 350, 100, 50);
        welcomeScreen.add(toSignUp);
        
        toSignIn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new SignInScreen();
            }
        });

        toSignUp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new SignUpScreen();
            }
        });
	}
	public static void screenAdd() {
		aa.background.setLayout(aa.card);
        aa.background.add(welcomeScreen,"1");
        aa.card.show(aa.background, "1");
        aa.frame.setVisible(true);
	}
}
