package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.po.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import common.servlet.RequestUtil;
import common.servlet.ServletRequestUtil;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request , HttpServletResponse response) {
        
        
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getUserList(0, 0, 20);
        
        //Integer.parseInt(null);
        
//        model.addAttribute("userList", userList);
        
        request.setAttribute("userList", userList);
        request.setAttribute("action", "index");
        
        return "user/index";
    }
    
    @RequestMapping(value = "addUser")
    public String addUser(HttpServletRequest request) {
    	
    	RequestUtil reqeustUtil = new ServletRequestUtil();
    	
    	int userId = reqeustUtil.getInt("uid", request);
    	
    	User user = new User();
    	
    	
    	if (userId > 0) {
    		UserDao userDao = new UserDao();
    		user = userDao.getUserById(userId);
    	}
    	
    	request.setAttribute("user", user);
    	request.setAttribute("action", "add");
    	
    	return "user/add";
    }
    
    @RequestMapping(value = "addUserPost")
    public String addUserPost(@RequestParam("name") String name , @RequestParam("birthday") String birthday ,@RequestParam("sex") int sex){
    	
    	
    	User user = new User();
    	user.setName(name);
    	user.setBirthday(birthday);
    	user.setSex(sex);

    	UserDao userDao = new UserDao();
    	int userId = userDao.insertUser(user);
    	
    	
    	
    	return "redirect:/user/index.do?uid=" + userId;
    }
    
    
    
}
