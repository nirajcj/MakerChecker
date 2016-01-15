package com.services;
/**
 *
 * @author niraj.kumar
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.bean.User;

@Transactional
@Service("userService")
public class UserServicesImpl implements UserServices {

 @Autowired
 UserDao userdao;

 @Override
 public void insertData(User user,String name) {
  userdao.insertData(user,name);
 }

 @Override
 public List<User> getUserList() {
  return userdao.getUserList();
 }

 @Override
 public void deleteData(String id) {
  userdao.deleteData(id);
  
 }

 @Override
 public User getUser(String id) {
  return userdao.getUser(id);
 }

 @Override
 public void updateData(User user,String name) {
  userdao.updateData(user,name);
  
 }

@Override
public List<User> getMasterList() {
	// TODO Auto-generated method stub
	return userdao.getMastreList();
}

@Override
public void masterDeleteData(String id) {
	// TODO Auto-generated method stub
	userdao.masterDeleteData(id);
	
}

@Override
public void authorize(String id,String name) {
	// TODO Auto-generated method stub
	userdao.authorize(id,name);
	
}

@Override
public void reject(String id) {
	// TODO Auto-generated method stub
	userdao.reject(id);
	
}

@Override
public List<User> getUserListForCheck() {
	// TODO Auto-generated method stub
	return userdao.getUserListForCheck();
}

@Override
public void updateMasterData(User user,String name) {
	// TODO Auto-generated method stub
	userdao.updateMasterData(user,name);
	
}

@Override
public User getUserMaster(String id) {
	// TODO Auto-generated method stub
	return userdao.getUserMaster(id);
}

@Override
public List<User> getUserMList() {
	// TODO Auto-generated method stub
	return userdao.getUserMaster();
}




 
}
