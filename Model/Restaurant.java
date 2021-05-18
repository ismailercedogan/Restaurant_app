package Model;
import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	
	public Restaurant() {
		initEmployees();
		initProducts();
	}
	
	private void initEmployees() {
		
		addCook("Monica", 100);
		
		addWaiter("Ross");
		addWaiter("Phobe");
		addWaiter("Rachel");
	}
	
	private void initProducts() {
		
		
		products.add(new MainDish("Pizza", 6, 2, 2));
		products.add(new MainDish("Burger", 5, 1.5, 2));
		
		products.add(new Beverage("Coke", 2, 0.5));
		products.add(new Beverage("Lemonade", 2, 0.3));
		
		products.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new Dessert("Cake", 3, 0.5, 1));
		products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		
		ArrayList<Product> HGproducts = new ArrayList<>();
		HGproducts.add(new MainDish("Pizza", 6, 2, 2));
		HGproducts.add(new Beverage("Coke", 2, 0.5));
		HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
		products.add(new MenuProduct("Hunger Games Menu", HGproducts));
		
		ArrayList<Product> Kidsproducts = new ArrayList<>();
		Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
		Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
		Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		products.add(new MenuProduct("Kids Menu", Kidsproducts));
	}
public void listEmployees() {
	for(int i=0;i<employees.size();i++) {
		System.out.println("Employee "+(i+1)+": "+employees.get(i).getName());
	}
	
}
public void addCook(String name, double salary) {
	int id=employees.size()+1;
	Employee cook=new Cook(id,name,salary);
	employees.add((Employee) cook);
}
public void addWaiter(String name) {
	int id=employees.size()+1;
	Employee waiter=new Waiter(id,name);
	employees.add((Employee)waiter);
}
public Waiter assignWaiter() {
	Random rand=new Random();
	while(true) {
		int num=rand.nextInt(employees.size());
	if(employees.get(num)instanceof Waiter) {
		return (Waiter) employees.get(num);
	}
	}
}
public double calculateExpenses() {
	double employeeExpenses=0;
	for(int i=0;i<employees.size();i++) {
		employeeExpenses+=employees.get(i).calculateExpense();
	}
	System.out.println("Employee expenses: "+employeeExpenses);
	double orderExpenses=0;
	ArrayList<Order>receivedOrders=new ArrayList<>();
	ArrayList<Waiter>waiters=new ArrayList<>();
	ArrayList<Product>receivedProduct=new ArrayList<>();
	//access to waiters
	for(Employee employee:employees) {
		if(employee instanceof Waiter) {
			waiters.add((Waiter)employee);
		}
	}
	//access to orders from each waiter who got order
	for(Waiter waiter:waiters) {
		ArrayList<Order>getOrders=waiter.getOrdersReceived();
		for(Order get:getOrders) {
			receivedOrders.add(get);
		}
	} 
	//access to products from each order which received
	for (Order order:receivedOrders) {
		ArrayList<Product>getProducts=order.gerOrderedProducts();
		for(Product get:getProducts) {
			receivedProduct.add(get);
		}
	}
	//access to expense of each product and find the total order expense
	for(Product received: receivedProduct) {
		orderExpenses+=received.calculateExpense();
	}
	System.out.println("Order Expenses: "+orderExpenses);
return employeeExpenses+orderExpenses;
}
public double calculateRevenue() {
	
	double revenue=0.0;
	ArrayList<Order>receivedOrders=new ArrayList<>();
	ArrayList<Waiter>waiters=new ArrayList<>();
	//access to waiters 
	for(Employee employee:employees) {
		if(employee instanceof Waiter) {
			waiters.add((Waiter)employee);
		}
	}
	//access to received orders from each waiter who got order
	for(Waiter waiter:waiters) {
		ArrayList<Order>getOrders=waiter.getOrdersReceived();
		for(Order get:getOrders) {
			receivedOrders.add(get);
		}
	} 
	//access to total price of each order and find the revenue
	for (Order order:receivedOrders) {
		revenue+=order.calculateTotalPrice();
	}
	return revenue;
}
public ArrayList<Product> getProducts(){
	return products;
}
}
