package com.Star_SNG.midProjectLnT;
import java.util.ArrayList;
import java.util.Scanner;
import com.Star_SNG.midProjectLnT.employee.Employee;
import com.Star_SNG.midProjectLnT.employee.PosCount;
import com.Star_SNG.midProjectLnT.employee.domain.EmployeeController;
import com.Star_SNG.midProjectLnT.employee.domain.EmployeeDisplay;
import com.Star_SNG.midProjectLnT.menu.Menu;
import com.Star_SNG.midProjectLnT.title.Title;

public class Main
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Integer menuSelection, dispSelection = 0;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Scanner scan = new Scanner(System.in);
		PosCount posCount = new PosCount();
		
		Title title = new Title();
		title.Print();
		
		Menu menu = new Menu();
		
		do
		{
			menu.printSelection();
			menuSelection = menu.getSelection();
			
			switch(menuSelection)
			{
				case 1:
					EmployeeController empController = new EmployeeController();
					empController.inputData();
					posCount.posProcess(empController.getEmployee());
					
					if (empController.getEmployee().getPos().equals("Manager") && posCount.getManagerCount() % 3 == 1 && posCount.getManagerCount() > 1)
						empController.addBonus(empController.getEmployee().getPos(), employeeList);
					else if (empController.getEmployee().getPos().equals("Supervisor") && posCount.getSupervisorCount() % 3 == 1 && posCount.getSupervisorCount() > 1)
						empController.addBonus(empController.getEmployee().getPos(), employeeList);
					else if (empController.getEmployee().getPos().equals("Admin") && posCount.getAdminCount() % 3 == 1 && posCount.getAdminCount() > 1)
						empController.addBonus(empController.getEmployee().getPos(), employeeList);
					
					System.out.print("ENTER to return");
					scan.nextLine();
					System.out.println();
					
					Integer pos = -1;
					Employee oldEmp, newEmp;
					
					for (int i = 0; i < employeeList.size(); i++)
					{
						oldEmp = employeeList.get(i);
						newEmp = empController.getEmployee();
						
						if (newEmp.getName().compareTo(oldEmp.getName()) < 0)
						{
							pos = i;
							break;
						}
					}
					
					if (pos >= 0)
						employeeList.add(pos, empController.getEmployee());
					else
						employeeList.add(empController.getEmployee());
					
					break;
				case 2:
					EmployeeController empUpdController = new EmployeeController();
					EmployeeDisplay empDisplay = new EmployeeDisplay(employeeList);
					Integer updSelect, delSelect;
					
					empDisplay.print();
					if (employeeList.size() != 0)
					{
						empDisplay.printSelection();
						dispSelection = empDisplay.getMenu();
					}
					else
						System.out.println();
					
					switch (dispSelection)
					{
						case 1:
							do
							{
								System.out.print("Input nomor yang ingin diupdate: ");
								updSelect = scan.nextInt();
							}
							while (updSelect > employeeList.size());
							
							if (employeeList.get(updSelect - 1).getPos().equals("Manager"))
								posCount.setManagerCount(posCount.getManagerCount() - 1);
							else if (employeeList.get(updSelect - 1).getPos().equals("Supervisor"))
								posCount.setSupervisorCount(posCount.getSupervisorCount() - 1);
							else if (employeeList.get(updSelect - 1).getPos().equals("Admin"))
								posCount.setAdminCount(posCount.getAdminCount() - 1);
							
							empUpdController.updateData(employeeList.get(updSelect - 1));
							
							if (employeeList.get(updSelect - 1).getPos().equals("Manager"))
								posCount.setManagerCount(posCount.getManagerCount() + 1);
							else if (employeeList.get(updSelect - 1).getPos().equals("Supervisor"))
								posCount.setSupervisorCount(posCount.getSupervisorCount() + 1);
							else if (employeeList.get(updSelect - 1).getPos().equals("Admin"))
								posCount.setAdminCount(posCount.getAdminCount() + 1);
							
							System.out.println();
							empDisplay.print();
							System.out.println();
							break;
						case 2:
							do
							{
								System.out.print("Input nomor yang ingin dihapus: ");
								delSelect = scan.nextInt();
							}
							while (delSelect > employeeList.size());
							
							if (employeeList.get(delSelect - 1).getPos().equals("Manager"))
								posCount.setManagerCount(posCount.getManagerCount() - 1);
							else if (employeeList.get(delSelect - 1).getPos().equals("Supervisor"))
								posCount.setSupervisorCount(posCount.getSupervisorCount() - 1);
							else if (employeeList.get(delSelect - 1).getPos().equals("Admin"))
								posCount.setAdminCount(posCount.getAdminCount() - 1);
							
							employeeList.remove(delSelect - 1);
							
							System.out.println();
							empDisplay.print();
							System.out.println();
							break;
						case 3:
							System.out.println();
							break;
					}
					
					break;
				case 3:
					System.out.print("Exit successful");
					break;
			}
		}
		while (menuSelection != 3);
	}
}
