package com.maven.latestBank.beans;

public class Transactions {
	long fromAccountNumber,toAccountNumber,amountTransfer;

	public Transactions(long fromAccountNumber, long toAccountNumber, long amountTransfer) {
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amountTransfer = amountTransfer;
	}

	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public long getAmountTransfer() {
		return amountTransfer;
	}

	public void setAmountTransfer(long amountTransfer) {
		this.amountTransfer = amountTransfer;
	}
}
