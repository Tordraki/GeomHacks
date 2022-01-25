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
public class HomeScreen {
    public static String username;
    private static JPanel homeScreen;
    private static JTabbedPane tabbedPane;
    public static JPanel panelX;
    public static JPanel panelY;
    public static Login user;
    public static JPanel OtherOrd;
    public static JPanel Payment;
    public static Order o1;
    public static Order o2;
    public static Order o3;
    public static Order o4;
    public static Order o5;
    public static Order o6;
    public static ArrayList<Order> a;
    private static ArrayList<JCheckBox> boxes;
    private static ArrayList<JLabel> labels;

    public HomeScreen() {
        labels= new ArrayList<JLabel>();
        a = new ArrayList<Order>();
        boxes = new ArrayList<JCheckBox>();
        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order();
        Order o4 = new Order();
        Order o5 = new Order();
        Order o6 = new Order();
        o1.addItem("Ham", 1);
        o1.addItem("Whole Chicken", 2);
        o1.addItem("Bags of Rice", 4);
        o1.addItem("Loaves of Bread", 4);
        o2.addItem("Cheese", 2);
        o2.addItem("Apples", 10);
        o2.addItem("Boxes of Blackberries", 5);
        o2.addItem("Bottles of Wine", 3);
        o2.addItem("Quarts of Whole Milk", 2);
        o3.addItem("Cheese", 2);
        o3.addItem("Apples", 10);
        o3.addItem("Boxes of Blackberries", 5);
        o3.addItem("Bottles of Wine", 3);
        o3.addItem("Quarts of Whole Milk", 2);
        o4.addItem("Boxes of Blackberries", 5);
        o5.addItem("Bottles of Wine", 3);
        o6.addItem("Quarts of Whole Milk", 2);

        o4.addItem("Pancake Mixes", 3);
        o5.addItem("Grapes", 30);
        o6.addItem("Bags of Flour", 3);
        o4.addItem("Lemons", 8);
        o5.addItem("Waterbottles", 2);
        o6.addItem("Bags of Ribs", 6);
        a.add(o1);
        a.add(o2);
        a.add(o3);
        a.add(o5);
        a.add(o4);
        a.add(o6);

        screenLayout();
        tab1();
        tab2();
        tab3();
        screenAdd();
    }

    public static void screenLayout() {
        homeScreen = SwingHelper.createPanel(new Color(162, 238, 226));
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(20, 150, aa.width-80, aa.height-250);
        homeScreen.add(tabbedPane);
        user = aa.getUser(username);
        SwingHelper.createLabel("Make Your Grocery List Here!", new Color(86, 46, 136), new Font("Impact", Font.BOLD, 50), 50, 0, 800, 200, homeScreen);

        try{
            BufferedImage logo = ImageIO.read(new URL("http://img.icons8.com/nolan/100/shopping-cart.png"));
            Icon c = new ImageIcon(logo);
            JButton back = new JButton(c);
            back.setBounds(aa.width-200, 50, 120, 120);
            homeScreen.add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tab1();
                }
            });
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void ListAll() {

        if(a.size()<=4) {
            for(int j = labels.size()-1; j>=0;j--) {
                labels.get(j).setBounds(0, 0, 0, 0);
                labels.remove(j);
                System.out.println(labels.size());
            }
            for(int z = boxes.size()-1; z>=0;z--) {
                boxes.get(z).setBounds(0, 0, 0, 0);
                boxes.remove(z);
                System.out.println(boxes.size());
            }
            for(int i = 0; i<a.size();i++) {

                JLabel l1= new JLabel(a.get(i).toString());
                l1.setBounds(50, 150+50*i, 800, 60);
                labels.add(l1);
                OtherOrd.add(l1);

                //SwingHelper.createLabel(a.get(i).toString(), Color.BLACK, new Font("TimesRoman", Font.BOLD, 15), 50, 150+50*i, 800, 60, OtherOrd);
                JCheckBox box = new JCheckBox();
                boxes.add(box);
                box.setBounds(700, 168+50*i, 30, 30);
                OtherOrd.add(box);
            }
        }
        else {
            for(int j = labels.size()-1; j>=0;j--) {
                labels.get(j).setBounds(0, 0, 0, 0);
                labels.remove(j);


            }
            for(int z = boxes.size()-1; z>=0;z--) {
                boxes.get(z).setBounds(0, 0, 0, 0);
                boxes.remove(z);



            }
            for(int i = 0; i<4;i++) {


                JLabel l1= new JLabel(a.get(i).toString());
                l1.setBounds(50, 150+50*i, 800, 60);
                labels.add(l1);
                OtherOrd.add(l1);
                JCheckBox box = new JCheckBox();
                boxes.add(box);
                box.setBounds(700, 168+50*i, 30, 30);
                OtherOrd.add(box);
            }

        }
    }
    public static void tab1() {
        panelX = SwingHelper.createPanel(new Color(199, 248, 241));
        ArrayList <StringInt> stringInts = new ArrayList<>();
        for (int i = 50; i < aa.height-300; i+=50) {
            stringInts.add(SpecialButton.createRow(80, i));
            if (i < 300)
                stringInts.add(SpecialButton.createRow(500, i));
        }
        JButton button = new JButton("Validate your Order");
        button.setFont(button.getFont().deriveFont(20.0f));
        button.setBounds(500, 400, 300, 70);
        panelX.add(button);

        for (int i = 0; i < aa.width; i++) {

        }
        //SwingHelper.createImage("https://img.icons8.com/cotton/100/000000/paprika--v2.png", w, h, x, y, wid, hei, jp);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                SwingHelper.createLabel("Thanks! Your Order Has Been Submitted", new Color(246, 169, 57), new Font("Impact", Font.PLAIN, 20), 480, 350, 500, 50, panelX);

                Order listOfThings = new Order();
                for (StringInt x: stringInts) {
                    if (x.getString() != null && x.getInt() != 0)
                        listOfThings.addItem(x.getString(), x.getInt());
                    x.getTextField().setText("");
                    x.getLabel().setText("0");
                }
                if (user!= null)
                    user.addOrder(listOfThings);
            }
        });

        tabbedPane.addTab("Place Your Order", null, panelX, null);
    }


    public static void tab2() {
        //panel creation
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 247, 176));
        tabbedPane.addTab("Payment", null, panel, null);
        panel.setLayout(null);

        //label creation
        JLabel j = new JLabel("To which do you apply?");
        j.setForeground(new Color(62, 72, 188));
        j.setFont(new Font("TimesRoman", Font.BOLD, 30));
        j.setBounds(30, 30, 400, 50);
        panel.add(j);

        //cash checkbox creation
        JCheckBox buy = new JCheckBox("Buyer");
        buy.setBounds(50, 100, 100, 50);
        panel.add(buy);

        //credit checkbox creation
        JCheckBox request = new JCheckBox("Requester");
        request.setBounds(200, 100, 100, 50);
        panel.add(request);

        //continue button creation
        JButton b = new JButton("Continue");
        b.setBounds(75, 200, 200, 75);
        panel.add(b);

        //enter amount label creation
        JLabel ent = new JLabel("");
        ent.setBounds(15, 30, 100, 30);
        panel.add(ent);

        //money texbox creation
        JTextField cashs = new JTextField();
        panel.add(cashs);

        //enter name to buy
        JLabel name = new JLabel("");
        name.setBounds(15, 90, 200, 30);
        panel.add(name);

        //Textbox for name
        JTextField nam = new JTextField();
        panel.add(nam);

        //Button Continue
        JButton but = new JButton("Continue");
        panel.add(but);

        //Message
        JLabel mes = new JLabel("");
        mes.setBounds(15, 180, 500, 30);
        panel.add(mes);

        //back butoon
        JButton back = new JButton("Back");
        panel.add(back);

        //extra button
        JButton extra = new JButton("");
        panel.add(extra);
        //stupid
        JTextField stupid = new JTextField("");
        stupid.setBounds(1000,1000, 0, 0);
        panel.add(stupid);

        //picture
        SwingHelper.createImage("https://img.icons8.com/cute-clipart/100/000000/wallet.png", 200, 200, aa.width - 500, aa.height - 700, 300, 300, panel);
        SwingHelper.createImage("https://img.icons8.com/color/100/000000/grocery-bag.png", 100, 100, aa.width - 980, aa.height - 600, 300, 300, panel);
        SwingHelper.createImage("https://img.icons8.com/color/100/000000/check.png", 100, 100, aa.width - 800, aa.height - 600, 300, 300, panel);
        //background
        for (int i = 20; i < panel.getWidth(); i+= 200) {
            for(int j1 = 20; j1 < panel.getHeight(); j1+= 200) {
                if (!((i==820 && j1==20) || ((i==220 || i==420) && j1==220) || (i==220 && j1==420)))
                    SwingHelper.createImage("https://img.icons8.com/cotton/100/000000/banana.png", 50, 50, i, j1, 100, 100, panel);
            }
        }

        //button action
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //erases previous mode
                j.setBounds(0,0,0,0);
                buy.setBounds(0,0,0,0);
                request.setBounds(0, 0, 0, 0);
                b.setBounds(0, 0, 0, 0);
                mes.setBounds(15, 180, 500, 30);
                //tests checkboxes
                if(buy.isSelected() && request.isSelected()){
                    //error message and back button
                    mes.setBounds(15, 15, 500, 30);
                    mes.setForeground(new Color(255, 0, 0));
                    mes.setText("Please Select One");
                    back.setBounds(15, 45, 90, 30);
                    //back button return to main screen
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back.setBounds(0,0,0,0);
                            mes.setText("");
                            buy.setBounds(50, 100, 100, 50);
                            request.setBounds(200, 100, 100, 50);
                            b.setBounds(75, 200, 200, 75);
                            j.setBounds(30, 30, 400, 50);
                            buy.setSelected(false);
                            request.setSelected(false);
                        }
                    });
                    //buyer selection
                }else if (buy.isSelected()) {
                    //create buyer screeen
                    ent.setText("Enter Amount:");
                    cashs.setBounds(15, 60, 100, 30);
                    name.setText("Enter name of requester:");
                    nam.setBounds(15, 120, 100, 30);
                    but.setText("Continue");
                    but.setBounds(15, 150, 90, 30);
                    //test user input as buyer
                    but.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            boolean a = false;
                            //loop through users
                            for(Login i: aa.users){

                                //finds user and input amount of money from buying
                                if(i.getName().toUpperCase().equals(nam.getText().toUpperCase())){
                                    i.setMoney(Double.parseDouble(cashs.getText()));
                                    a = true;
                                    break;
                                }


                            }
                            //error message
                            if(!a){
                                mes.setForeground(new Color(255, 0, 0));
                                mes.setText("User Not Found, Try Again");
                            }
                            else{
                                //thank you message
                                mes.setForeground(new Color(79, 121, 66));
                                mes.setText("Thank You For Helping");
                            }
                        }
                    });
                    back.setBounds(100, 150, 90, 30);
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ent.setText("");
                            mes.setText("");
                            nam.setText("");
                            cashs.setBounds(0,0,0,0);
                            name.setText("");
                            nam.setBounds(0,0,0,0);
                            but.setBounds(0,0,0,0);
                            back.setBounds(0,0,0,0);
                            //
                            buy.setBounds(50, 100, 100, 50);
                            request.setBounds(200, 100, 100, 50);
                            b.setBounds(75, 200, 200, 75);
                            j.setBounds(30, 30, 400, 50);
                            //
                            buy.setSelected(false);
                            request.setSelected(false);
                        }
                    });
                    //requester part
                }else if(request.isSelected()){
                    name.setText("Enter your name:");
                    name.setBounds(15, 30, 300, 30);
                    nam.setBounds(14, 60, 100, 30);
                    but.setBounds(15, 90, 90, 30);
                    but.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mes.setText("");
                            name.setText("");
                            back.setBounds(0,0,0,0);
                            but.setBounds(0,0,0,0);
                            nam.setBounds(0,0,0,0);
                            buy.setSelected(false);
                            request.setSelected(false);
                            //REMEMBER TO CHANGE TO FALSE
                            boolean a = true;
                            int c = 0;
                            //stupid.setText(String.valueOf(c));
                            //users.get(0).setMoney(10);
	                            /*
	                            for(Login i: users){
	                                c = users.indexOf(i);
	                                if(i.getName().toUpperCase().equals(nam.getText().toUpperCase())){
	                                    stupid.setText(String.valueOf(c));
	                                    a = true;
	                                    break;
	                                }
	                            }
	                             */


                            if(!a){
                                mes.setBounds(15, 120, 300, 30);
                                mes.setForeground(new Color(255, 0, 0));
                                mes.setText("User Not Found, Try Again");
                            }
                            else{
                                mes.setText("");
                                but.setBounds(0,0,0,0);
                                j.setBounds(15, 10, 400, 30);
                                j.setText("Enter Payment Option");
                                buy.setBounds(15, 30, 100, 50);
                                request.setBounds(15, 60, 100, 50);
                                buy.setText("Cash");
                                request.setText("Credit");
                                extra.setText("Continue");
                                extra.setBounds(15, 100, 90, 30);
                                extra.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if(buy.isSelected() && request.isSelected()){
                                            mes.setForeground(new Color(255, 0, 0));
                                            mes.setBounds(15, 150, 300, 30);
                                            mes.setText("Please Choose One");
                                        }else if(buy.isSelected()){
                                            //ADD BACK BUTTON
                                            String pay = "Please pay $" + aa.users.get(Integer.valueOf(stupid.getText())).pay() + " when buyer shows up in cash.";
                                            mes.setBounds(15, 30, 600, 30);
                                            mes.setText(pay);
                                        }else if(request.isSelected()){
                                            //ADD BACK BUTTON
                                            String bal = "$" + aa.users.get(Integer.valueOf(stupid.getText())).pay() + " is deducted from your balance.";
                                            aa.users.get(Integer.valueOf(stupid.getText())).setBalance(0);
                                            mes.setBounds(15, 30, 600, 30);
                                            mes.setText(bal);
                                            aa.users.get(Integer.valueOf(stupid.getText())).dedBalance(aa.users.get(Integer.valueOf(stupid.getText())).pay());
                                        }
                                    }
                                });
                                back.setBounds(100, 100, 90, 30);
                                back.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        mes.setText("");
                                        nam.setText("");
                                        name.setBounds(15, 90, 200, 30);
                                        j.setText("Who are you?(Choose One)");
                                        buy.setText("Buyer");
                                        request.setText("Requester");
                                        extra.setBounds(0,0,0,0);
                                        buy.setBounds(0,0,0,0);
                                        request.setBounds(0,0,0,0);
                                        j.setBounds(0,0,0,0);

                                        buy.setSelected(false);
                                        request.setSelected(false);

                                    }
                                });

                            }
                        }
                    });
                    back.setBounds(100, 90, 90, 30);
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nam.setText("");
                            name.setBounds(15, 90, 200, 30);
                            mes.setText("");
                            name.setText("");
                            but.setBounds(0,0,0,0);
                            nam.setBounds(0,0,0,0);
                            back.setBounds(0,0,0,0);
                            b.setBounds(15, 100, 90, 40);
                            buy.setBounds(15, 30, 100, 50);
                            request.setBounds(15, 60, 100, 50);
                            j.setBounds(15, 10, 400, 30);
                            buy.setSelected(false);
                            request.setSelected(false);
                        }
                    });
                }else{
                    mes.setBounds(15, 20, 300, 30);
                    mes.setForeground(new Color(255, 0, 0));
                    mes.setText("Please Select a Section");
                    back.setBounds(15, 50, 90, 30);
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mes.setText("");
                            back.setBounds(0,0,0,0);
                            //
                            buy.setBounds(50, 100, 100, 50);
                            request.setBounds(200, 100, 100, 50);
                            b.setBounds(75, 200, 200, 75);
                            j.setBounds(30, 30, 400, 50);
                            //
                            buy.setSelected(false);
                            request.setSelected(false);
                        }
                    });
                }


            }
        });
    }
    public static void tab3() {
        OtherOrd = SwingHelper.createPanel(new Color(199, 248, 241));
        OtherOrd.setLayout(null);


        ListAll();



        JButton b1 = new JButton("Take this Order  (Only Choose One)");
        b1.setBounds(100, 400, 400, 20);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<boxes.size();i++) {
                    if(boxes.get(i).isSelected()) {


                        a.remove(i);
                        for(int j = 0; j<labels.size();j++) {
                            labels.get(j).setBounds(0, 0, 0, 0);
                        }
                        labels.remove(i);



                        ListAll();

                    }
                }
            }
        });

        OtherOrd.add(b1);
        SwingHelper.createLabel("Select an order that you would like to fulfill", Color.BLACK, new Font("TimesRoman", Font.BOLD, 40), 50, 50, 800, 60, OtherOrd);
        //SwingHelper.createLabel("Incorrect Password", Color.red, new Font("TimesRoman", Font.BOLD, 15), 50, 100, 140, 30, signInScreen);

        tabbedPane.addTab("Take Other Orders", null, OtherOrd, null);
    }

    public static void screenAdd() {
        aa.background.setLayout(aa.card);
        aa.background.add(homeScreen, "4");
        aa.card.show(aa.background, "4");
        aa.frame.setVisible(true);
    }
}
