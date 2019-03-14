package com.maven.latestBank.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.maven.latestBank.Service.TransactionImpl;
import com.maven.latestBank.Service.TransactionService;
import com.maven.latestBank.UI.MainUI;
import com.maven.latestBank.Utility.Utility;
import com.maven.latestBank.beans.Register;

public class EntryDAOImpl implements EntryDAO{
	Utility utility=new Utility();
	TransactionService trans=new TransactionImpl();
	Scanner in=new Scanner(System.in);
	static int accNo;
	MainUI mainui=new MainUI();
	public int register(Register r) throws Exception, SQLException {
		r=new Register();
		r=utility.util();
		
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/latest_bank","root","mysqlroot1");
		
		String sql="insert into customer_details(first_name, last_name, email_id, password, pancard_no, aadhaar_no, address, mobile_no, balance) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		
		pst.setString(1, r.getFirstName());
		pst.setString(2, r.getLastName());
		pst.setString(3, r.getEmailId());
		pst.setString(4, r.getPassword());
		pst.setString(5, r.getPancardNo());
		pst.setLong(6, r.getAadhaarNo());
		pst.setString(7, r.getAddress());
		pst.setLong(8, r.getMobileNo());
		pst.setFloat(9,r.getBalance());
		
		String pwd=r.getPassword();
		
		int c,adhar=(int) r.getAadhaarNo();
		c=pst.executeUpdate();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from customer_details");
		while(rs.next()) {
			if(adhar==rs.getInt("aadhaar_no"))
				accNo=rs.getInt("account_no");
		}
			
	
			mainui.printAccountNo(accNo);
			
			utility.takeCredentials();

		return c;
	}

	public boolean login(int accountNo,String pwd) throws Exception{
		
		int amount;
		
		int ch;
		do {
			mainui.chooseTransaction();
			ch=in.nextInt();
		switch(ch) {
		case 1: mainui.askAmount();
				amount=in.nextInt();
				trans.deposit(accountNo,amount);
				break;
				
		case 2: mainui.askAmount();
				amount=in.nextInt();
				trans.withdraw(accountNo,amount);
				break;
		case 3: mainui.askAmount();
				amount=in.nextInt();
				trans.transfer(accountNo,amount);
				break;
		case 4: trans.balance(accountNo);
				break;
		default: System.out.println("Please enter correct choice");
		}
		}while(ch<=4);
		return true;
	}

}