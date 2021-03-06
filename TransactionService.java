package com.maven.latestBank.Service;

public interface TransactionService {
	public int withdraw(int accountNo,int amount) throws Exception;
	public int deposit(int accountNo,int amount) throws Exception;
	public int transfer(int accountNo,int amount);
	public int balance(int accountNo) throws Exception;
}
