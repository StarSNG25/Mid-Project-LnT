package com.Star_SNG.midProjectLnT.employee.domain;
import java.util.ArrayList;
import java.util.Scanner;
import com.Star_SNG.midProjectLnT.employee.Employee;

public class EmployeeDisplay
{
	ArrayList<Employee> employeeList;
	private Scanner scan = new Scanner(System.in);
	
	public EmployeeDisplay(ArrayList<Employee> empList)
	{
		employeeList = empList;
	}

	public void print()
	{
		printTop();
		printData();
		printBottom();
	}
	
	private void printTop()
	{
		//                  01234501234567890123456701234567890123456789012345678901012345678901234501234567890123012345678901230
		System.out.println("|-----|-----------------|-------------------------------|---------------|-------------|-------------|");
		System.out.println("| No. |  Kode Karyawan  |         Nama Karyawan         | Jenis Kelamin |   Jabatan   |Gaji Karyawan|");
		System.out.println("|-----|-----------------|-------------------------------|---------------|-------------|-------------|");
	}
	
	private void printData()
	{
		String space;
		
		for (int i = 0; i < employeeList.size(); i++)
		{
			Employee emp = employeeList.get(i);
			
			space = "    " + (i + 1);
			System.out.print('|' + space.substring(space.length() - 5));
			space = "                 " + emp.getCode();
			System.out.print('|' + space.substring(space.length() - 17));
			space = "                               " + emp.getName();
			System.out.print('|' + space.substring(space.length() - 31));
			space = "               " + emp.getGender();
			System.out.print('|' + space.substring(space.length() - 15));
			space = "             " + emp.getPos();
			System.out.print('|' + space.substring(space.length() - 13));
			space = "             " + emp.getSalary();
			System.out.print('|' + space.substring(space.length() - 13) + '|');
			System.out.println();
		}
	}
	
	private void printBottom()
	{
		System.out.println("|-----|-----------------|-------------------------------|---------------|-------------|-------------|");
	}

	public void printSelection()
	{
		System.out.println();
		System.out.println("Pilih Aksi:");
		System.out.println("1. Update Data Karyawan");
		System.out.println("2. Delete Data Karyawan");
		System.out.println("3. Kembali ke Menu");
		System.out.println();
	}
	
	public Integer getMenu()
	{
		System.out.print("Input: ");
		Integer select = scan.nextInt();
		System.out.println();
		
		return select;
	}
}
