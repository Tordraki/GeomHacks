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

public class StringInt {
	public JTextField textBox;
	public JLabel label;
	
	public StringInt(JTextField textBox, JLabel label) {
		this.textBox = textBox;
		this.label = label;
	}
	
	public String getString() {
		if (textBox.getText()!=null && Integer.parseInt(label.getText())!= 0)
			return textBox.getText();
		return null;
	}
	public Integer getInt() {
		if (textBox.getText()!=null)
			return Integer.parseInt(label.getText());
		return 0;
	}
	public JTextField getTextField() {
		return textBox;
	}
	public JLabel getLabel() {
		return label;
	}
	
}
