package Model;
import java.util.ArrayList;
public class Order {
private ArrayList<Product>orders=new ArrayList<>();
public Order() {
	
}
public void addProduct(Product order) {
	orders.add(order);
} 
public void listOrder() {
	if (orders.size()<1) {
		System.out.println("You have not ordered anything yet!");
	}
	else {
		for(Product order:orders) {
			System.out.println(order);
		}
	}
}
public ArrayList<Product> getOrderedProducts(){
	return orders;
}
public double calculateTotalPrice() {
	double totalPrice=0.0;
	for(Product order:orders) {
		totalPrice+=order.getSellingPrice();
	}
return totalPrice;	
}
}
