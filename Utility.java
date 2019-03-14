package com.maven.latestBank.Utility;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.maven.latestBank.DAO.EntryDAO;
import com.maven.latestBank.DAO.EntryDAOImpl;
import com.maven.latestBank.Exception.AadharNotValid;
import com.maven.latestBank.Exception.EmailNotValid;
import com.maven.latestBank.Exception.MobileNotValid;
import com.maven.latestBank.Exception.PasswordValidation;
import com.maven.latestBank.Service.Validation;
import com.maven.latestBank.beans.Register;

public class Utility {
	static String pwd;
	Register r=new Register();
	Scanner in=new Scanner(System.in);
	String first,last,mail,pass,pan,address;
	long aadhar,mobile,balance;
	
	public Register util() throws Exception {
		Validation valid=new Validation();
		
		boolean isEmailValid,isPasswordValidate, isAadharValid, isMobileValid ;
		
		System.out.println("please enter first name");
		first=in.next();
		r.setFirstName(first);
		
		System.out.println("please enter last name");
		last=in.next();
		r.setLastName(last);
		
		System.out.println("please enter mailId");
		mail=in.next();
		if(isEmailValid=valid.emailValidate(mail))
			r.setEmailId(mail);
		else
			throw new EmailNotValid("Email is not valid");
			
		System.out.println("please enter password");
		pass=in.next();
		if(isPasswordValidate=valid.password(pass))
			r.setPassword(pass);
		else
			throw new PasswordValidation("password is invalid");
		
		System.out.println("please enter pancard");
		pan=in.next();
		r.setPancardNo(pan);
		
		System.out.println("please enter address");
		address=in.next();
		r.setAddress(address);
		
		System.out.println("please enter aadhar number");
		aadhar=in.nextInt();
		if(isAadharValid=valid.aadharValidate(aadhar))
			r.setAadhaarNo(aadhar);
		else
			throw new AadharNotValid("Aadhar is not valid");
		
		System.out.println("please enter mobile");
		mobile=in.nextLong();
		if(isMobileValid=valid.mobileValidate(mobile))
			r.setMobileNo(mobile);
		else
			throw new MobileNotValid("Mobile number not valid");
		
		r.setBalance(500);
		return r;
	}	
	
	
	
	public int takeCredentials() throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/latest_bank","root","mysqlroot1");
		int x=0,y=0;
		
		System.out.println("please enter accountNo");
		int accntNo=in.nextInt();
		
		String sql="select * from customer_details";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		//rs.next();
		//System.out.println("account number is "+rs.getInt("account_no"));
		while(rs.next()) {
			if(rs.getInt(1)==accntNo) {
				
				x=1;
			}
		}
		if(x==1) {
			System.out.println("Please enter password");
			pwd=in.next();
		}
		
		String sql1="select password from customer_details where account_no='accntNo'";
		ResultSet rs1=pst.executeQuery();
		
		while(rs1.next()) {
			if(rs1.getString("password").contentEquals(pwd)) {
				y=1;
				EntryDAO entry=new EntryDAOImpl();
				entry.login(accntNo,pwd);
			}
		}		
		if(x==1 && y==1)
			return 1;
		else
			return 0;
	}
	
	
	
	
}