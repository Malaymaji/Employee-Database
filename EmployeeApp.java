import java.util.Scanner;
public class EmployeeApp {
	public static void main(String[] args) {
		EmployeeService e=new EmployeeServiceImplementation();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Employee App");
		System.out.println("=======================================================");
		
			System.out.println("============================================");
			System.out.println("Enter Your Option \n1. Add Employee Details");
			System.out.println("2.Display all employee details\n3.Get Employee details by ID");
			System.out.println("4.Delete Employee details\n5.Update");
			System.out.println("========================================");
	
			int op=sc.nextInt();
			switch(op) {
			case 1:e.addEmployee();break;
			case 2:e.getAllDetails();break;
			case 3:System.out.println("Enter Id no.");
					int idx=sc.nextInt();
					e.getDetailsbyId(idx);
					break;
			case 4:
				System.out.println("Enter Id no.");
				int idxx=sc.nextInt();
				e.deleteEmployee(idxx);
				break;
			case 5:
				System.out.println("Enter Id for Update");
				int id=sc.nextInt();
				e.updateDetails(id);
				break;
				default:
					System.out.println("Invalid option");
			}
			
	}

}
