package Model;

import java.util.ArrayList;

public class Waiter extends Employee {
private double orderRate;
private ArrayList <Order> orders = new ArrayList <>();
public Waiter(int id,String name) {
		super(id,name);
		this.orderRate=0.10;
}
public double calculateExpense() {
	double total=0;
	for(int i=0;i<orders.size();i++) {
		total+=orders.get(i).calculateTotalPrice()*this.orderRate;
	}
return total;
}
public void createOrder(Order order) {
	this.orders.add(order);
}
public ArrayList<Order> getOrdersReceived(){
	return this.orders;
}	
}
