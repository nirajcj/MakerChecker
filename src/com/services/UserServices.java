
package com.services;
/**
 *
 * @author niraj.kumar
 */

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.User;

@Service
public interface UserServices {

 public void insertData(User user,String name);
 public List<User> getUserList();
 public void deleteData(String id);
 public User getUser(String id);
 public void updateData(User user,String name);
public List<User> getMasterList();
public void masterDeleteData(String id);
public void authorize(String id,String name);
public void reject(String id);
public List<User> getUserListForCheck();
public void updateMasterData(User user,String name);
public User getUserMaster(String id);
public List<User> getUserMList();


}


