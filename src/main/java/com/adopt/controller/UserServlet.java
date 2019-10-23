package com.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adopt.pojo.Star;
import com.adopt.pojo.StarExample;
import com.adopt.pojo.User;
import com.adopt.pojo.UserExample;
import com.adopt.pojo.UserExample.Criteria;
import com.adopt.service.StarService;
import com.adopt.service.UserService;

@Controller
public class UserServlet {
	
	@Resource 
    private UserService us;
	@Resource
	private StarService ss;
	
	@RequestMapping("/index.do")
	public String toIndex() {
		return "login";
	}
	
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login.do";
	}
	
//	@ResultMap("/login.do")
	@RequestMapping("/login.do")
	public String login(
			@Param("phone") String phone, 
			@Param("pwd") String pwd, 
			Model model,
			HttpSession session) {
		System.out.println("login.do");
		try {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneEqualTo(phone);
			criteria.andPwdEqualTo(pwd);
			
			List<User> userList = us.selectByExample(example);
			if(userList.isEmpty()) {
				model.addAttribute("msg", "用户名或密码错误");
				
				return "login";
				
			}else {
				User user = userList.get(0);
				model.addAttribute("user", user);
				session.setAttribute("user", user);
				return "index";
			}
		} catch (Exception e) {
			System.out.println("/*******************************login error**********************/");
			e.printStackTrace();
		}
		return "error";
	}
	
	@RequestMapping("toSignUp")
	public String toSignUp() {
		return "signUp";
	}
	
	@RequestMapping("signUp")
	public String signUp(
			@Param("name") String name,
			@Param("phone") String phone,
			@Param("email") String email,
			@Param("pwd") String pwd,
			Model model) {
		
		System.out.println("signUp.do");
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPwd(pwd);
		int i = us.insert(user);
		if(i>0) {
			model.addAttribute("msg", "注册成功");
			return "login";
		}else {
			model.addAttribute("msg", "注册失败，请检查所填写的信息");
			return "signUp";
		}
	}
	
	@RequestMapping("toUpdateInf")
	public String toUpdateMsg() {
		return "updateInf";
	}
	
	@RequestMapping("update.do")
	public void updateMsg(
			@Param("name") String name,
			@Param("phone") String phone,
			@Param("email") String email,
			@Param("pwd") String pwd,
			HttpSession session,
			HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException {
		System.out.println("跳转update");
		
		//int id = Integer.parseInt(req.getParameter("id"));
		User userStr = (User) session.getAttribute("user");
		int id = userStr.getId();
		System.out.println(id+name+phone+email+pwd);
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andIdEqualTo(id);
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPwd(pwd);
		int i = us.updateByExample(user, userExample);
		res.setContentType("text/html;charset=UTF-8");
		if(i>0) {
			req.getSession().setAttribute("user", user);
			res.getWriter().print("信息修改成功！");
			
		}else {
			res.getWriter().print("信息修改失败！");
		}
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("adopt.do")
	public String adopt(
			Model model, 
			HttpServletRequest req) {
		
		int starId = Integer.parseInt(req.getParameter("starId"));
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(starId + "*****" + id);
		try {
			if(0 == id) {
				model.addAttribute("msg", "请先进行登录！");
				return "login";
			}else {
				
				User user = new User();
				Star star = new Star();
//				user.setId(id);
				user.setStarid(starId);
//				star.setId(starId);
				star.setMomid(id);
				star.setAdopted(1);
				
				UserExample userExample = new UserExample();
				StarExample starExample = new StarExample();
				com.adopt.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
				com.adopt.pojo.StarExample.Criteria starCriteria = starExample.createCriteria();
				userCriteria.andIdEqualTo(id);
				starCriteria.andIdEqualTo(starId);
				
				int i = us.updateByExampleSelective(user, userExample);
				int p = ss.updateByExampleSelective(star, starExample);
				System.out.println(i + "******" + p);
				if(i>0 && p>0) {
					model.addAttribute("msg", "操作成功！");
					
					StarExample example = new StarExample();
					com.adopt.pojo.StarExample.Criteria starCriteriaAdopted = example.createCriteria();
					starCriteriaAdopted.andAdoptedEqualTo(1);
					
					List<Star> adoptedList = ss.selectByExample(example);
					req.setAttribute("List", adoptedList);
					req.setAttribute("adopted", "1");
					
					return "list";
				}else {
					model.addAttribute("msg", "操作失败！");
					return "show";
				}
				
			}
		} catch (Exception e) {
			System.out.println("/*******************************adopt部分出错哦*************************************************/");
			e.printStackTrace();
			return "error";
		}
		
		
		
	}
	
}
