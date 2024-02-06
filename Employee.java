import java.io.Serializable;

public class Employee implements Serializable{
	private int id;
	private String name;
	private String designation;
	double salary;
	
	public Employee(int id, String name, String designation,double salary) {

	this.id = id;
	this.name = name;
	this.designation = designation;
	this.salary=salary;
	}
	public int getId() {
	return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee id=" + id + ", name=" + name + ", Designation=" + designation+", Salary="+salary;
	}

	
}