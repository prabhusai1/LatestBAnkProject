package com.maven.latestBank.Exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String s) {
		System.out.println(s);
	}
}
