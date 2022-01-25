import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingHelper {
	public static void createLabel(String mes, Color c, Font f, int x, int y, int len, int hei, JPanel jp) {
    	JLabel message = new JLabel(mes);
    	message.setForeground(c);
    	message.setFont(f);
    	message.setBounds(x, y, len, hei);
    	jp.add(message);
    }
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    public static void createImage(String url, int w, int h, int x, int y, int wid, int hei, JPanel jp) {
    	BufferedImage image;
    	try {
    		image = ImageIO.read(new URL(url));
    		image = resize(image, w, h);
    		JLabel pic = new JLabel(new ImageIcon(image));
    		pic.setBounds(x, y, wid, hei);
    		jp.add(pic);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public static JPanel createPanel(Color color) {
    	JPanel x = new JPanel();
    	x.setLayout(null);
    	x.setBackground(color);
    	return x;
    }
    
    public static JTextField createTextBox(int x, int y, int wid, int hei, JPanel jp) {
    	JTextField p = new JTextField();
    	p.setBounds(x,  y,  wid,  hei);
    	jp.add(p);
    	return p;
    }
}
