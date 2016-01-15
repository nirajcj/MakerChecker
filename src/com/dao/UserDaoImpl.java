package com.dao;
/**
 *
 * @author niraj.kumar
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bean.User;
import com.jdbc.UserRowMapper;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

@Repository
public class UserDaoImpl implements UserDao {
   
   

 @Autowired
 DataSource dataSource;

 @Autowired
 HibernateTemplate template;   

 
 public void insertData(User user,String name) {
     
     String sql1 = "SELECT COUNT(*) FROM temp_112358";
     String sql2 = "SELECT COUNT(*) FROM master_112358";
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     
     
     Date date=new Date();
     SimpleDateFormat dt=new SimpleDateFormat("dd-MMM-yyyy");
     String bc=dt.format(date);


     int total = jdbcTemplate.queryForInt(sql1);
     total+=jdbcTemplate.queryForInt(sql2);
     int id=total+1;
     System.out.println(id);
     System.out.println(user.getContact());
    
    
/*
  String sql = "INSERT INTO temp_112358 "
    + "(cust id ,cust code,cust name,cust addr1,cust addr2,cust pin ," +
    "email,contact,primary contact person,flag,record status,create date,created by) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

 

  try
  {
  jdbcTemplate.update(
    sql,
    new Object[] { id,user.getCustCode(), user.getCustName(),user.getCustAddr1(),
      user.getCustAddr2(), user.getCustPin(),user.getEmail(),user.getContact(),
      user.getPrimaryContactPerson(),user.getFlag(),"N",bc,name});
System.out.println("Here");
  }
  catch(Exception e)
  {
      System.out.println(e.getMessage());
  }
    
 */   
    
     user.setCustId(id);
     user.setCreatedBy(name);
     user.setCreateDate(bc);
     user.setRecordStatus("N");
     template.save(user);
    
    
 }

 public List<User> getUserList() {
     try
     {
  List userList = new ArrayList();
  

  String sql = "select * from temp_112358 where recordStatus not like 'D'";

  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  return userList;
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
         return null;
     }
 }

 @Override
 public void deleteData(String id) {
     
     String rs=null;
     System.out.println("UserDaoImpl.deleteData()");
     
     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     try
     {

         List<User> userList1 = new ArrayList<User>();
         String sql1 = "select * from temp_112358 where custId= " + id;
         userList1 = jdbcTemplate.query(sql1, new UserRowMapper());
   
          System.out.println("Running Agaa");
          rs=userList1.get(0).getRecordStatus();
          System.out.println(rs);
         if(rs.equalsIgnoreCase("N"))
         {
             System.out.println("sdasdasdasd");
             String sql = "delete from temp_112358 where custId=" + id;
  
             jdbcTemplate.execute(sql);
         }
     
     
   
         
         
     else if(rs.equals("MR")||rs.equals("NR")||rs.equals("M"))
     {
         
         String sql = "delete from temp_112358 where custId=" + id;
          //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          jdbcTemplate.update(sql);
          
     }
     
     

    
    else
     {
         
     }
     
               
   
     }
    
     
     
     
     catch(org.springframework.dao.DuplicateKeyException e)
     {
         System.out.println("exception handled");
    
     }

 }

 @Override
 public void updateData(User user,String name) {
     System.out.println(user.getRecordStatus());
     
     Date date=new Date();
     SimpleDateFormat dt=new SimpleDateFormat("dd-MMM-yyyy");
     String bc=dt.format(date);
     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     List<User> userList2 = new ArrayList<User>();
     String sql2 = "select * from temp_112358 where custId= " + user.getCustId();
     userList2 = jdbcTemplate.query(sql2, new UserRowMapper());
     String rs=userList2.get(0).getRecordStatus();
     if(rs.equals("NR")||rs.equals("MR")||rs.equals("M"))
     {
     	
    	 String sql = "UPDATE temp_112358 set custName =?,custAddr1=?,custAddr2=?,custPin =?," +
    			    "email=?,contact=?,primaryContactPerson=?,flag=?,recordStatus='N',modifiedBy=?,modifiedDate=?";
    			  
    			 
    			  System.out.println("Runned");

    			  System.out.println(user.getCreatedBy());

    			 
    			  jdbcTemplate.update(
    			    sql,
    			    new Object[] { user.getCustName(),user.getCustAddr1(),
    			              user.getCustAddr2(), user.getCustPin(),user.getEmail(),user.getContact(),
    			              user.getPrimaryContactPerson(),user.getFlag(),name,bc});            
     }
     
     else if(rs.equals("N"))
     {
     
  String sql = "UPDATE temp_112358 set custName =?,custAddr1=?,custAddr2=?,custPin =?," +
    "email=?,contact=?,primaryContactPerson=?,flag=?,recordStatus='N',modifiedBy=?,modifiedDate=?";
  
 
  System.out.println("Runned");

  System.out.println(user.getCreatedBy());

 
  jdbcTemplate.update(
    sql,
    new Object[] { user.getCustName(),user.getCustAddr1(),
              user.getCustAddr2(), user.getCustPin(),user.getEmail(),user.getContact(),
              user.getPrimaryContactPerson(),user.getFlag(),name,bc});
 
 
     }

 }

 @Override
 public User getUser(String id) {
     try{
  List<User> userList = new ArrayList<User>();
  String sql = "select * from temp_112358 where custId= " + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  System.out.println("Running Agaa");
  System.out.println(userList.get(0).getRecordStatus());
  return userList.get(0);
 
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
         return null;
     }
 }

 
 
 @Override
 public User getUserMaster(String id) {
     try{
  List<User> userList = new ArrayList<User>();
  String sql = "select * from master_112358 where custId= " + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  return userList.get(0);
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
         return null;
     }
 }
 
 
 
 
@Override
public List<User> getMastreList() {
     try
     {
 List userList = new ArrayList();
 //userList.clear();

 String sql = "select * from master_112358 ";

 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
 userList = jdbcTemplate.query(sql, new UserRowMapper());
 System.out.println("Running");
 return userList;
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
         return null;
     }
}

@Override
public void masterDeleteData(String id) {
   
   
   
   
     try
     {
    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    	 

    	  String sql="insert into temp_112358 select * from master_112358 where custId= " + id;
    	  jdbcTemplate.update(sql);
    	 
         sql = "UPDATE temp_112358 set recordStatus='D' where custId=" + id;
          jdbcTemplate.update(sql);
     }
     catch(org.springframework.dao.DuplicateKeyException e)
     {
         System.out.println("exception handled");
   
     }
    // TODO Auto-generated method stub
   
}

@Override
public void authorize(String id,String name) {
    // TODO Auto-generated method stub
    Date date=new Date();
     SimpleDateFormat dt=new SimpleDateFormat("dd-MMM-yyyy");
     String bc=dt.format(date);
   
/*     List<User> userList = new ArrayList<User>();*/
   
    System.out.println("asdasd");
    System.out.println(id);

     List<User> userList2 = new ArrayList<User>();
     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     String sql2 = "select * from temp_112358 where custId= " + id;
     userList2 = jdbcTemplate.query(sql2, new UserRowMapper());
     System.out.println(userList2.get(0).getRecordStatus());
     String rs=userList2.get(0).getRecordStatus();
     if(rs.equals("N"))
     {
         
         System.out.println("Authorize N");
      String sql = "insert into master_112358 select * from temp_112358 where custId= " + id;
      jdbcTemplate.update(sql);
      sql = "UPDATE master_112358 set recordStatus='A',authorizedBy=?, authorizedDate=? where custId=" + id;
      jdbcTemplate.update(sql,new Object[]{ name,bc});
     
      sql = "delete from temp_112358 where custId=" + id;
      //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
      jdbcTemplate.update(sql);
     
     }
     
     else if(rs.equals("D"))
     {
         String sql = "delete from temp_112358 where custId=" + id;
          //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          jdbcTemplate.update(sql);
     
     sql = "delete from master_112358 where custId=" + id;
      //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
      jdbcTemplate.update(sql);}
     
     else if(rs.equals("M"))
     {
      
         
        
    	 System.out.println("Runn8ing M");
          //jdbcTemplate.update(sql);
    	 String sql = "delete from temp_112358 where custId=" + id;
         //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         jdbcTemplate.update(sql);
        
     }

     
     

     
}

@Override
public void reject(String id) {
    // TODO Auto-generated method stub
   

     try
     {
    	 List<User> userList2 = new ArrayList<User>();
     
     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     String sql2 = "select * from temp_112358 where custId= " + id;
     userList2 = jdbcTemplate.query(sql2, new UserRowMapper());
     String rs=userList2.get(0).getRecordStatus();
     if(rs.equals("N"))
     {
         String sql = "UPDATE temp_112358 set recordStatus='NR' where custId=" + id;
          jdbcTemplate.update(sql);
     }
     
     
     else if(rs.equals("M"))
     {
         String sql = "UPDATE temp_112358 set recordStatus='MR' where custId=" + id;
          jdbcTemplate.update(sql);
     }
     
     else if(rs.equals("D"))
     {
         String sql = "UPDATE temp_112358 set recordStatus='DR' where custId=" + id;
          jdbcTemplate.update(sql);
     }
     else
     {
    	 
     }
     }
     catch(Exception e)
     {
    	 e.getMessage();
     }
     
   
   
   
   
   
   
   
   
}

@Override
public List<User> getUserListForCheck() {
	try{
     List<User> userList = new ArrayList<User>();
      String sql = "select * from temp_112358 where recordStatus not like '%R'";
      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
      userList = jdbcTemplate.query(sql, new UserRowMapper());
      return userList;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
}

@Override
public void updateMasterData(User user,String name) {
    // TODO Auto-generated method stub
      try
      {
    	  Date date=new Date();
      
          SimpleDateFormat dt=new SimpleDateFormat("dd-MMM-yyyy");
          String bc=dt.format(date);
   
   
     List<User> userList2 = new ArrayList<User>();
     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     String sql2 = "select * from master_112358 where custId= " + user.getCustId();
     userList2 = jdbcTemplate.query(sql2, new UserRowMapper());
   
    
   

         String sql = "insert into temp_112358 (custId,custCode,custName ,custAddr1,custAddr2,custPin ," +
                    "email,contact,primaryContactPerson,flag,recordStatus,createDate,createdBy,authorizedBy,authorizedDate,modifiedDate,modifiedBy) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

                  System.out.println(user.getCustCode());

           
                  jdbcTemplate.update(
                    sql,
                    new Object[] { user.getCustId(),user.getCustCode(),user.getCustName(),user.getCustAddr1(),
                              user.getCustAddr2(), user.getCustPin(),user.getEmail(),user.getContact(),
                              user.getPrimaryContactPerson(),user.getFlag(),"M",bc,userList2.get(0).getCreatedBy(),bc,userList2.get(0).getAuthorizedBy(),bc,name});
                 
                 
      //           
                            
   
      }
      catch(Exception e)
      {
    	  System.out.println(e.getMessage());
      }
       
       

       

             
             
           
              //jdbcTemplate.update(sql1);
             
   
   
}

@Override
public List<User> getUserMaster() {
    try
    {
 List userList = new ArrayList();
 //userList.clear();

 String sql = "select * from temp_112358";

 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
 userList = jdbcTemplate.query(sql, new UserRowMapper());
 return userList;
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        return null;
    }
}
}
