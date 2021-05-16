package Model;
import java.util.ArrayList;

public class MenuProduct extends Product{
private ArrayList<Product> products=new ArrayList<>();
	public MenuProduct(String name,ArrayList <Product> products) {
	super(name);
	this.products=products;
}
public double calculateExpense() {
	double totalExpense=0.0;
	for(Product product:this.products) {
		if(product instanceof MainDish) {
			totalExpense+=((MainDish)product).calculateExpense();
		}
		if(product instanceof Dessert) {
			totalExpense+=((Dessert)product).calculateExpense();
		}	
		if(product instanceof Beverage) {
			totalExpense+=((Beverage)product).calculateExpense();
		}
	}
return totalExpense;
}
public double getSellingPrice() {
	double totalPrice=0.0;
	for(Product product:this.products) {
		if(product instanceof MainDish) {
			totalPrice+=(((MainDish)product).getSellingPrice())-(((MainDish)product).getSellingPrice()*0.1);
		}
		if(product instanceof Dessert) {
			totalPrice+=(((Dessert)product).getSellingPrice())-(((Dessert)product).getSellingPrice()*0.2);
		}	
		if(product instanceof Beverage) {
			totalPrice+=(((Beverage)product).getSellingPrice())-(((Beverage)product).getSellingPrice())*0.5;
		}
	}
return totalPrice;
}
}
