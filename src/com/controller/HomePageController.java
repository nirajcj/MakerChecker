package com.controller;
/**
 *
 * @author niraj.kumar
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bean.User;
import com.services.UserServices;

@Controller
public class HomePageController {

 @Autowired
 UserServices userService;

 @RequestMapping("/register")
 public ModelAndView registerUser(@ModelAttribute User user,HttpServletRequest rq,HttpServletResponse rs) throws IOException {

    // System.out.println(rq.getAttribute("role"));
	 System.out.println(rq.getSession().getAttribute("name"));
     
     HttpSession hs= rq.getSession(false);
        if(hs.getAttribute("name")==null)
        {
            rs.sendRedirect(rq.getContextPath()+"/index.jsp");
        }

  Map<String, List> map = new HashMap<String, List>();
  //User user=new User();
 
  return new ModelAndView("register", "user",user);
 }

 @RequestMapping("/insert")
 public ModelAndView inserData(  @ModelAttribute("user") User user,BindingResult result,HttpServletResponse rs,HttpServletRequest rq) throws IOException {
     System.out.println(user.getCustId());
     System.out.println("HomePageController.inserData()");
     HttpSession hs= rq.getSession(false);
        if(hs.getAttribute("name")==null)
        {
            rs.sendRedirect(rq.getContextPath()+"/index.jsp");
        }
     
     if(result.hasErrors())
     {
         System.out.println("error");
         //return new ModelAndView("register","user",user);
     }
  if (user != null)
   {
      String name=(String) rq.getSession().getAttribute("name");
      userService.insertData(user,name);
   }
  return new ModelAndView("redirect:/getList","user",user);
 }

 @RequestMapping("/getList")
 public ModelAndView getUserLIst(HttpServletRequest rq,HttpServletResponse rs) throws IOException {
     
     HttpSession hs= rq.getSession(false);
        if(hs.getAttribute("name")==null)
        {
            rs.sendRedirect(rq.getContextPath()+"/index.jsp");
        }
   
  List<User> userList = userService.getUserList();
 
  return new ModelAndView("userList", "userList", userList);
 }
 
 @RequestMapping("/checker")
 public ModelAndView getcheckerLIst(HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	// System.out.printlnhs.getAttribute("name");
	 HttpSession hs= rq.getSession(false);
	 System.out.println(hs.getAttribute("name"));
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
  List<User> userList = userService.getUserMList();
 
  return new ModelAndView("checker", "userList", userList);
 }
 
 
 @RequestMapping("/getMasterList")
 public ModelAndView getMasterUserLIst(HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
   
  List<User> userList = userService.getMasterList();
 
  return new ModelAndView("masterListMaker", "userList", userList);
 }

 @RequestMapping("/edit")
 public ModelAndView editUser(@RequestParam String id,
   @ModelAttribute("user") User user,BindingResult result,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
     user = userService.getUser(id);

     if(result.hasErrors())
     {
         return new ModelAndView("edit","user",user);
     }
  user = userService.getUser(id);

  System.out.println(user.getCreatedBy());
  Map<String, Object> map = new HashMap<String, Object>();
 
  map.put("user", user);

  return new ModelAndView("edit", "map", map);

 }
 
 
 @RequestMapping("/rqedit")
 public ModelAndView editMasterUser(@RequestParam String id,
  @ModelAttribute("user") User user,BindingResult result,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
     user = userService.getUserMaster(id);
     if(result.hasErrors())
     {
         return new ModelAndView("rqedit","user",user);
     }

  user = userService.getUserMaster(id);

  Map<String, Object> map = new HashMap<String, Object>();
 
  map.put("user", user);

  return new ModelAndView("rqedit", "map", map);

 }
 

 @RequestMapping("/update")
 public String updateUser(@ModelAttribute User user,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
     System.out.println("HomePageController.updateUser()");
     
     System.out.println(user.getContact());
     String name=(String) rq.getSession().getAttribute("name");
  userService.updateData(user,name);
  return "redirect:/getList";

 }
 

 @RequestMapping("/rqupdate")
 public String updateMaster(@ModelAttribute User user,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
     System.out.println("HomePageController.updateUser()");
     
     System.out.println(user.getContact());
  userService.updateMasterData(user,(String)hs.getAttribute("name"));
  return "redirect:/getList";

 }
 
 
 
 @RequestMapping("/approve")
 public ModelAndView approveUser() {
      List<User> userList = userService.getUserListForCheck();
     
      return new ModelAndView("pending", "userList", userList);
 }

 @RequestMapping("/delete")
 public String deleteUser(@RequestParam String id,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
  System.out.println("id = " + id);
  userService.deleteData(id);
  return "redirect:/getList";
 }
 
 @RequestMapping("/rqdelete")
 public String deleteMasterUser(@RequestParam String id,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
  System.out.println("id = " + id);
  userService.masterDeleteData(id);
  return "redirect:/getList";
 }
 
 @RequestMapping("/authorize")
 public String authorizeUser(@RequestParam String id,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
     String name=(String) rq.getSession().getAttribute("name");
  userService.authorize(id,name);
  return "redirect:/checker";
 }
 
 
 
 
 
 @RequestMapping("/reject")
 public String reject(@RequestParam String id,HttpServletRequest rq,HttpServletResponse rs) throws IOException {
	 
	 HttpSession hs= rq.getSession(false);
     if(hs.getAttribute("name")==null)
     {
         rs.sendRedirect(rq.getContextPath()+"/index.jsp");
     }
  System.out.println("id = " + id);
  userService.reject(id);
  return "redirect:/checker";
 }
 
 
 
}