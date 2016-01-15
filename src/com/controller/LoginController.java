
package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.*;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.services.LoginServices;
import com.services.UserServices;


@Controller
public class LoginController {
   
   
     @Autowired
     LoginServices loginService;
   
   

@RequestMapping(value="login")
public String return_log(HttpServletRequest rq,HttpServletResponse rs)
{
    return "login";
}



@RequestMapping(value="validate")
public String log(HttpServletRequest rq,HttpServletResponse rs,ModelMap mm)
{
   
    rq.getSession().setAttribute("name", rq.getParameter("name"));
   
   
   
    LoginBean lb=new LoginBean();
    //System.out.println(rq.getMethod());
    //System.out.println(rq.getParameter("email")+"asd");
    lb.setName(rq.getParameter("name"));
    lb.setPass(rq.getParameter("pwd"));
    //System.out.println(rq.getParameter("email"));
   
   
    if(loginService.isUserValid(lb).equals("m"))
    {
       
        return "maker";
    }
    else if(loginService.isUserValid(lb).equals("c"))
            {
        return "redirect:/checker";
            }
           
               
        else
            return "null";
}



@RequestMapping(value="logout")
public String logOut(HttpServletRequest req,HttpServletResponse res) throws IOException{
    req.getSession().invalidate();
    System.out.println("logout");
    res.sendRedirect(req.getContextPath()+"/index.jsp");
    return null;
}
}