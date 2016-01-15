package com.services;
/**
*
* @author niraj.kumar
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.dao.UserDao;

	@Transactional
	@Service("loginService")
	public class LoginServicesImpl implements LoginServices {

	 @Autowired
	 LoginDao logindao;

	@Override
	public String isUserValid(LoginBean lb) {
		return logindao.isUserValid(lb);
		
	}
	 
	 
	 
	 
	 
	 

}
