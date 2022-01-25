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

public class SpecialButton {
		
	public static JLabel createNumDisplay(int x, int y) {
		 JLabel label = new JLabel("0");
	     label.setBounds(x, y, 20, 20);
	     HomeScreen.panelX.add(label);
	     return label;
	}
	public static JButton createPlus(int x, int y) {
		JButton button = new JButton("+");
		button.setFont(button.getFont().deriveFont(10.0f));
        button.setBounds(x, y, 40, 40);
        HomeScreen.panelX.add(button);
        return button;
	}
	public static JButton createMinus(int x, int y) {
		JButton button = new JButton("-");
		button.setFont(button.getFont().deriveFont(10.0f));
        button.setBounds(x, y, 40, 40);
        HomeScreen.panelX.add(button);
        return button;
	}
	public static JTextField createOrderBox(int x, int y) {
		return SwingHelper.createTextBox(x,  y,  160,  40,  HomeScreen.panelX);
	}
	public static StringInt createRow(int x, int y) {
		JTextField text = createOrderBox(x-30, y);
		JButton buttonPlus = createPlus(x+150, y);
		JLabel num = createNumDisplay(x+200, y+10);
		JButton buttonMinus = createMinus(x+220, y);
		StringInt stringInt = new StringInt(text, num);
		buttonPlus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int numA = Integer.parseInt(num.getText());
                num.setText(String.valueOf(numA+1));
            }
        });
		buttonMinus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int numA = Integer.parseInt(num.getText());
            	if(numA!=0) {
            		num.setText(String.valueOf(numA-1));
            	}
            }
            	
        });
		return stringInt;
	}
	
}
