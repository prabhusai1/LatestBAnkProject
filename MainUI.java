package com.maven.latestBank.UI;

import java.util.Scanner;

import com.maven.latestBank.Service.EntryImpl;
import com.maven.latestBank.Service.EntryService;
import com.maven.latestBank.Utility.Utility;
import com.maven.latestBank.beans.Register;

public class MainUI {
	public static void main(String args[]) throws Exception {
		Utility utility=new Utility();
		EntryService entry=new EntryImpl();
		Scanner in=new Scanner(System.in);
		
		int accountNo;
		
		System.out.println("please enter your choice \n1.Registration \n2.Login");
		int choice=in.nextInt();
		
		switch(choice) {
		case 1:  Register r=new Register();
				 entry.register(r);
				 break;
		case 2:  
				 utility.takeCredentials();
				 break;
		default: System.out.println("please enter correct choice");
		}
	}
	
	public void chooseTransaction() {
		System.out.println("please enter \n1.deposit \n2.withdraw \n3.transfer \n4.view balance");
	}
	
	public void askAmount() {
		System.out.println("please enter amount");
	}
	
	public void printAccountNo(int no) {
		System.out.println("The account number is "+no);
	}
	
	public void adharStatus() {
		System.out.println("aadhar is in valid");
	}
	
	public void mobileStatus() {
		System.out.println("mobile number is in valid");
	}
	
	public int printBalance(float bal) {
		System.out.println("balance amount is :"+ bal);
		return 0;
	}
	
}