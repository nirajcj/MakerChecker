


package com.services;
/**
*
* @author niraj.kumar
*/


import org.springframework.stereotype.Service;

import com.bean.LoginBean;


@Service
public interface LoginServices {

    public String isUserValid(LoginBean lb);
   
   
   

}



