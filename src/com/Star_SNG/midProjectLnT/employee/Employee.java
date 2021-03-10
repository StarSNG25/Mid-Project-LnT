package com.Star_SNG.midProjectLnT.employee;

public class Employee
{
	private String name;
	private String gender;
	private String pos;
	private String code = "";
	private Long salary = 0L;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getPos()
	{
		return pos;
	}
	public void setPos(String pos)
	{
		this.pos = pos;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public Long getSalary()
	{
		return salary;
	}
	public void setSalary(Long salary)
	{
		this.salary = salary;
	}
}
