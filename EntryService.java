package com.maven.latestBank.Service;

import com.maven.latestBank.beans.Register;

public interface EntryService {
	public int register(Register r) throws Exception, Exception;
	public boolean login(int accountNo,String password) throws Exception;
}