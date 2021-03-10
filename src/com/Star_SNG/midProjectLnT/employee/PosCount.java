package com.Star_SNG.midProjectLnT.employee;

public class PosCount
{
	private Integer managerCount = 0;
	private Integer supervisorCount = 0;
	private Integer adminCount = 0;
	
	public Integer getManagerCount()
	{
		return managerCount;
	}
	public void setManagerCount(Integer managerCount)
	{
		this.managerCount = managerCount;
	}
	public Integer getSupervisorCount()
	{
		return supervisorCount;
	}
	public void setSupervisorCount(Integer supervisorCount)
	{
		this.supervisorCount = supervisorCount;
	}
	public Integer getAdminCount()
	{
		return adminCount;
	}
	public void setAdminCount(Integer adminCount)
	{
		this.adminCount = adminCount;
	}
	public void posProcess(Employee employee)
	{
		if (employee.getPos().equals("Manager"))
		{
			employee.setSalary(8000000L);
			setManagerCount(getManagerCount() + 1);
		}
		else if (employee.getPos().equals("Supervisor"))
		{
			employee.setSalary(6000000L);
			setSupervisorCount(getSupervisorCount() + 1);
		}
		else if (employee.getPos().equals("Admin"))
		{
			employee.setSalary(4000000L);
			setAdminCount(getAdminCount() + 1);
		}
		
	}
}
