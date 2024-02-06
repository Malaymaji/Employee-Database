import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
class EmployeeServiceImplementation implements EmployeeService{
	
	ArrayList<Employee>list=new ArrayList<Employee>();
	Scanner sc=new Scanner(System.in);
	
	
	@Override
	public void addEmployee()
	{	
		try {
			FileInputStream fis=new FileInputStream("emp.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			list=(ArrayList<Employee>)ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
			System.out.println("Enter employee id");
			int id=sc.nextInt();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter Designation");
			String des=sc.next();
			System.out.println("Enter Salary");
			double sal=sc.nextDouble();
			list.add(new Employee(id, name, des,sal));
			try {
				
				FileOutputStream fos=new FileOutputStream("emp.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(list);
				fos.close();
				oos.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("\nEmployee Details added successfully");
			
	}
	@Override
	public void getAllDetails()
	{	
		try {
		FileInputStream fis=new FileInputStream("emp.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(ArrayList<Employee>)ois.readObject();
			for(Employee emp:list)
			{
				System.out.println(emp);
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getDetailsbyId(int id)
	{
		try {
			boolean flag=false;
			FileInputStream fis=new FileInputStream("emp.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			list=(ArrayList<Employee>)ois.readObject();
			for(Employee emp:list)
			{
				if(emp.getId()==id)
				{
					System.out.println(emp);
					flag=true;
				}
			}
			if(flag==false)
			{
				System.out.println("\nId is invalid");
			}
		} 
		catch (Exception e) {
				e.printStackTrace();
		}
	}
	public void deleteEmployee(int id)
	{	
		try {
			boolean flag=false;
		FileInputStream fis=new FileInputStream("emp.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(ArrayList<Employee>)ois.readObject();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getId()==id)
			{
				list.remove(i);
				System.out.println("Delete successfully");
				flag=true;
				FileOutputStream fos=new FileOutputStream("emp.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(list);
				fos.close();
				oos.flush();
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("Not found");
		}
	} 
	catch (Exception e) {
			e.printStackTrace();
	}
	}
	public void updateDetails(int id)
	{	try {
		FileInputStream fis=new FileInputStream("emp.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		list=(ArrayList<Employee>)ois.readObject();
		
		boolean flag=false;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getId()==id)
			{
				System.out.println("1.designation\n2.Salary");
				int op=sc.nextInt();
				switch(op)
				{
				case 1:System.out.println("Enter Designation");
				String ds=sc.next();
				list.get(i).setDesignation(ds);
				
				FileOutputStream fos=new FileOutputStream("emp.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(list);
				fos.close();
				oos.flush();
				break;
				case 2:System.out.println("Enter salary");
				double sal=sc.nextDouble();
				list.get(i).setSalary(sal);
				FileOutputStream fos1=new FileOutputStream("emp.txt");
				ObjectOutputStream oos1=new ObjectOutputStream(fos1);
				oos1.writeObject(list);
				fos1.close();
				oos1.flush();
				}
				flag=true;
			}
		}
		if(flag==false)
			System.out.println("Id not found");
		else
			System.out.println("Id successfully Updated");
	} 
	catch (Exception e) {
			e.printStackTrace();
	}
	
	}
	
}
