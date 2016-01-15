package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.LoginBean;

public class LoginDaoImpl implements LoginDao {

    @Autowired
    DataSource dataSource;

       
   


    @Override
    public String isUserValid(LoginBean lb) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println(lb.getName());
        System.out.println(lb.getPass());
            String sql = "select role from role_112358 where name ='"+lb.getName()+"' and password='"+lb.getPass()+"'";
          
                 System.out.println("Running");
                String role=(String)jdbcTemplate.queryForObject(sql,String.class);
            System.out.println("Running222");
            System.out.println(role);
             return role;
          
    }
       
      
}

