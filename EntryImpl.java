package com.maven.latestBank.Service;

import java.sql.SQLException;

import com.maven.latestBank.DAO.EntryDAO;
import com.maven.latestBank.DAO.EntryDAOImpl;
import com.maven.latestBank.beans.Register;

public class EntryImpl implements EntryService {

	EntryDAO entryDAO=new EntryDAOImpl();
	public int register(Register r) throws Exception, Exception {
		entryDAO.register(r);
		return 0;
	}

	public boolean login(int accountNo,String password) throws Exception {
		return entryDAO.login(accountNo,password);
	}

}