package com.Star_SNG.midProjectLnT.employee.domain;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.Star_SNG.midProjectLnT.employee.Employee;

public class EmployeeController
{
	private Employee employee;
	private Scanner scan;
	private Random rand;
	
	public EmployeeController()
	{
		employee = new Employee();
		scan = new Scanner(System.in);
		rand = new Random();
	}

	private char alphRand()
	{
		return (char)(rand.nextInt(26) + 'A');
	}
	
	private int numRand()
	{
		return (int)(rand.nextInt(9));
	}
	
	public void inputData()
	{
		do
		{
			System.out.print("Input nama karyawan [>= 3]: ");
			employee.setName(scan.nextLine());
		}
		while (employee.getName().length() < 3);
		
		do
		{
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			employee.setGender(scan.nextLine());
		}
		while (!(employee.getGender().equals("Laki-laki") || employee.getGender().equals("Perempuan")));
		
		do
		{
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			employee.setPos(scan.nextLine());
		}
		while (!(employee.getPos().equals("Manager") || employee.getPos().equals("Supervisor") || employee.getPos().equals("Admin")));
		
		for (int i = 0; i < 2; i++)
			employee.setCode(employee.getCode() + alphRand());
		employee.setCode(employee.getCode() + '-');
		for (int i = 0; i < 4; i++)
			employee.setCode(employee.getCode() + numRand());
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + employee.getCode());
	}
	
	public void updateData(Employee emp)
	{
		System.out.print("Input kode karyawan [Asli: " + emp.getCode() + "]: ");
		emp.setCode(scan.nextLine());
		
		do
		{
			System.out.print("Input nama karyawan [>= 3] [Asli: " + emp.getName() + "]: ");
			emp.setName(scan.nextLine());
		}
		while (emp.getName().length() < 3);
		
		do
		{
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] [Asli: " + emp.getGender() + "] (Case Sensitive): ");
			emp.setGender(scan.nextLine());
		}
		while (!(emp.getGender().equals("Laki-laki") || emp.getGender().equals("Perempuan")));
		
		do
		{
			System.out.print("Input jabatan [Manager | Supervisor | Admin] [Asli: " + emp.getPos() + "] (Case Sensitive): ");
			emp.setPos(scan.nextLine());
		}
		while (!(emp.getPos().equals("Manager") || emp.getPos().equals("Supervisor") || emp.getPos().equals("Admin")));
		
		System.out.print("Input gaji karyawan [Asli: " + emp.getSalary() + "]: ");
		emp.setSalary(scan.nextLong());
		
		System.out.println("Berhasil mengupdate karyawan dengan id " + emp.getCode());
	}
	
	public Employee getEmployee()
	{
		return employee;
	}

	public void addBonus(String pos, ArrayList<Employee> employeeList)
	{
		Integer isPrinted = 0, bonusPercentage = 0;
		
		if (pos.equals("Manager"))
		{
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
			bonusPercentage = 100;
		}
		else if (pos.equals("Supervisor"))
		{
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
			bonusPercentage = 75;
		}
		else if (pos.equals("Admin"))
		{
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
			bonusPercentage = 50;
		}
		
		for (int i = 0; i < employeeList.size(); i++)
			if (employeeList.get(i).getPos().equals(pos))
			{
				Long salary = employeeList.get(i).getSalary();
				employeeList.get(i).setSalary(salary + (salary * bonusPercentage / 1000));
				
				if (isPrinted == 1)
					System.out.print(", ");
				System.out.print(employeeList.get(i).getCode());
				isPrinted = 1;
			}
		
		System.out.println();
	}
}
