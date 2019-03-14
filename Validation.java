package com.maven.latestBank.Service;

import com.maven.latestBank.Exception.PasswordValidation;
import com.maven.latestBank.UI.MainUI;
import com.maven.latestBank.Utility.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	Utility utility=new Utility();
	MainUI mainui=new MainUI();
	
	//email id validation
	public boolean emailValidate(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) {
			System.out.println("Incorrect email");
			return false;
		}
		
		return pat.matcher(email).matches();
	}
	
	
	//mobile number validation
	public boolean mobileValidate(long mobileNumber) {
		int length = String.valueOf(mobileNumber).length();
		if(length==10) {
			return true;
		}
		else {
			mainui.mobileStatus();
			return false;
		}
	}
	
	//aadhar validation
	public boolean aadharValidate(long adhar) {
		int length = String.valueOf(adhar).length();
		if(length==9) {
			return true;
		}
		else {
			mainui.adharStatus();
			return false;
		}
	}
	

	//password validation
	public boolean password(String str){
	
		if(str.length()>=8){
			Pattern letter = Pattern.compile("[a-zA-z]");
			Pattern digit = Pattern.compile("[0-9]");
			Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

			Matcher hasLetter = letter.matcher(str);
			Matcher hasDigit = digit.matcher(str);
			Matcher hasSpecial = special.matcher(str);

			if(hasLetter.find() && hasDigit.find() && hasSpecial.find()) {
				//utility.passwordStatus();
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
