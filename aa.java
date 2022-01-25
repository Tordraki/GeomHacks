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

public class aa{
	
    public static ArrayList<Login> users;
    public static JPanel background;
    public static JFrame frame;
    public static CardLayout card;
    public static JPanel panelX;
    
    public static final int width = 1000;
    public static final int height = 800;
    
    public static Order x;
    public static Login getUser(String user) {
    	for (Login x: users) {
    		if (x.getUsername().equals(user))
    			return x;
    	}
    	return null;
    }
    
    public static void init() {
        
    	
    	users = new ArrayList<Login>();
		
    	x = new Order();
        x.addItem("Carrots", 4);
        x.addItem("Lettuce", 3);
        
        users.add(new Login("Tim", "123111"));
        users.add(new Login("Ron", "1671261356263"));
		users.add(new Login("Johnson", "273645"));

        //BACKGROUND SETUP
        background = SwingHelper.createPanel(new Color(71, 161, 164));
        background.setBounds(400, 400, 850, 400);
        card = new CardLayout(10, 10);

        //FRAME SETUP
        frame = new JFrame("The Grocer-E App");
        frame.setBounds(200, 400, 850, 400);
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        frame.setLocation((bounds.width-width)/2, (bounds.height-height)/2);
        frame.setSize(width, height);
        frame.add(background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    

    public static void main(String[] args) {
        init();
        //new WelcomeScreen();
        new HomeScreen();
    }




}
