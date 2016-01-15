package com.dao;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import com.bean.LoginBean;





public interface LoginDao {
   
    public String isUserValid(LoginBean lb);

}  

