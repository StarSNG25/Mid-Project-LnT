package com.Star_SNG.midProjectLnT.menu;
import java.util.Scanner;

public class Menu
{
	private Scanner scan = new Scanner(System.in);
	
	public void printSelection()
	{
		System.out.println("Pilih Submenu:");
		System.out.println("1. Input Data Karyawan");
		System.out.println("2. View Data Karyawan");
		System.out.println("3. Keluar");
		System.out.println();
	}
	
	public Integer getSelection()
	{
		System.out.print("Input: ");
		Integer select = scan.nextInt();
		System.out.println();
		
		return select;
	}
}
