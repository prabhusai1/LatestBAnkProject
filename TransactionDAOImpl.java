package com.maven.latestBank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.maven.latestBank.Exception.InsufficientBalanceException;
import com.maven.latestBank.UI.MainUI;
import com.maven.latestBank.Utility.Utility;

public class TransactionDAOImpl implements TransactionDAO{
	Scanner in=new Scanner(System.in);
	MainUI mainui=new MainUI();
	Utility utility=new Utility();
	int amt;
	float bal;
	
	public int withdraw(int accountNo,int amount) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/latest_bank","root","mysqlroot1");
		
		String sql="select * from customer_details";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(1)==accountNo) {
				bal=rs.getFloat(10);
				break;
			}
		}
		
		
		if(bal>amount) {
			bal=bal-amount;
			String sql1="update customer_details set balance=? where account_no=?";
			pst=con.prepareStatement(sql1);
			pst.setInt(1,(int) bal);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
		}
		else
			throw new InsufficientBalanceException("Balance is insuffiecinet to with draw");
			
		
		return mainui.printBalance(bal);
	}

	public int deposit(int accountNo,int amount) throws Exception {
		
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/latest_bank","root","mysqlroot1");
		
		String sql="select * from customer_details";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(1)==accountNo)
				bal=rs.getFloat(10);
		}
		
		
		
		bal=bal+amount;
		String sql1="update customer_details set balance=? where account_no="+accountNo;
		PreparedStatement pst1=con.prepareStatement(sql1);
		pst1.setInt(1,(int) bal);
		//pst1.setInt(2, accountNo);
		pst1.executeUpdate();
		mainui.printBalance(bal);
		return 0;
	}

	public int transfer(int accountNo,int amount) {
		mainui.askAmount();
		amt=in.nextInt();
		return 0;
	}

	public int balance(int accountNo) throws Exception {
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/latest_bank","root","mysqlroot1");
		
		String sql="select * from customer_details";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt(1)==accountNo)
				bal=rs.getFloat(10);
			mainui.printBalance(bal);
		}
		return 1;
	}

}