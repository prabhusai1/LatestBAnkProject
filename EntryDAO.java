package com.maven.latestBank.DAO;

import java.sql.SQLException;

import com.maven.latestBank.beans.Register;

public interface EntryDAO {
	public int register(Register r) throws Exception, SQLException;
	public boolean login(int accountNo,String password) throws Exception;
}