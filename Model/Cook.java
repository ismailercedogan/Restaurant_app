package Model;

public class Cook extends Employee{
private double salary;
private double taxRate;
public Cook(int id,String name,double salary) {
	super(id,name);
	this.taxRate=0.18;
	this.salary=salary;
}
public double getSalary() {
	return this.salary;
}
public double getTaxRate() {
	return this.taxRate;
}
public double calculateExpense() {
	return (this.salary+this.salary*this.taxRate);
}
}
