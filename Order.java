
import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> order;
	public Order() {
		order = new ArrayList<OrderItem>();
	}
	public void addItem(String n, int nu) {
		order.add(new OrderItem(n, nu));
	}
	public ArrayList<OrderItem> getOrder(){
		return order;
	}
	public String toString() {
		String result = "";
		for(int i = 0; i<order.size();i++) {
			result+=order.get(i).toString()+" | ";
			
		}
		return result;
	}
	
}
