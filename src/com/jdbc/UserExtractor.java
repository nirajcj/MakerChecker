
package com.jdbc;
/**
 *
 * @author niraj.kumar
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.bean.User;

public class UserExtractor implements ResultSetExtractor<User> {

 public User extractData(ResultSet resultSet) throws SQLException,
   DataAccessException {
 
  User user = new User();
 
  user.setCustId(resultSet.getInt(1));
  user.setCustCode(resultSet.getString(2));
  user.setCustName(resultSet.getString(3));
  user.setCustAddr1(resultSet.getString(4));
  user.setCustAddr2(resultSet.getString(5));
  user.setCustPin(resultSet.getString(6));
  user.setEmail(resultSet.getString(7));
  user.setContact(resultSet.getInt(8));
  user.setPrimaryContactPerson(resultSet.getString(9));
  user.setFlag(resultSet.getString(11));
  user.setRecordStatus(resultSet.getString(10));
  //user.setCreateDate(resultSet.getDate(11));
  user.setCreatedBy(resultSet.getString(13));

 // user.setModifiedDate(resultSet.getDate(13));

  user.setModifiedBy(resultSet.getString(15));
 

  //user.setAuthorizedDate(resultSet.getDate(15));

  user.setAuthorizedBy(resultSet.getString(17));
 
 
  return user;
 }

}

