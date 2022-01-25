import java.util.*;
public class Login {

    private String username;
    private String password;
    private String address;
    private double money;
    private String name;
    private ArrayList<Order> orders;
    private double balance;


    public Login(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        balance = 0;
    }
    public Login(String username, String password) {
    	this.username = username;
        this.password = password;
    }
    public void addOrder(Order a) {
    	orders.add(a);
    }
    public String getName(){
        return name;
    }
    public double getBalance() {
    	return balance;
    }
    public void addBalance(double m) {
    	balance += m;
    }
    public void dedBalance(double m) {
    	balance -= m;
    }
    public void setBalance(double m) {
    	balance = m;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setMoney(double m){
        money = m;
    }
    public double pay(){
        return money;
    }
    public void createRandomPassword() {
        String z = "";
        for(int a = 0; a < 5; a++) {
            z+= (int)(Math.random()*10);
        }
        password = z;
    }

    public int match (ArrayList<Login> other) {
        int index = -1;
        for (int i = 0; i < other.size(); i++) {
            if (username.equals(other.get(i).getUsername()))
                index = i;
        }
        //the username is not located in the database
        if (index < 0) {
            System.out.println("User not found");
            return -1;
        }
        //the password is not matching the username
        if (!password.equals(other.get(index).getPassword())) {
            System.out.println("Incorrect password");
            return 0;
        }

        //the correct user/pass has successfully logged in
        System.out.println("Welcome to the app!");
        return 1;

    }
    
    public boolean hasOrder() {
    	return (orders.size()!=0);
    }
    
    public ArrayList<Order> getOrders(){
    	return orders;
    }
    public String toString(){
        return username+", "+password;
    }
}
