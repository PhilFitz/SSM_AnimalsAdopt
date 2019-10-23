package com.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adopt.pojo.Star;
import com.adopt.pojo.StarExample;
import com.adopt.pojo.StarExample.Criteria;
import com.adopt.pojo.User;
import com.adopt.service.StarService;
import com.adopt.service.UserService;


@Controller
public class StarServlet {
	
	@Resource 
    private UserService us;
	@Resource
	private StarService ss;
	
	
	
	@RequestMapping("catList.do")
	public String catList(HttpServletRequest req) {
		
		try {
			StarExample example = new StarExample();
			Criteria criteria = example.createCriteria();
			criteria.andTypeEqualTo(2);
			criteria.andAdoptedEqualTo(0);
			
			List<Star> catList = ss.selectByExample(example);
			req.setAttribute("List", catList);
			req.setAttribute("adopted", "0");
			return "list";
		} catch (Exception e) {
			System.out.println("catList.do出错");
			return "error";
		}
		
	}
	
	@RequestMapping("dogList.do")
	public String dogList(HttpServletRequest req) {
		System.out.println("dogList.do");
		try {
			StarExample example = new StarExample();
			Criteria criteria = example.createCriteria();
			criteria.andTypeEqualTo(1);
			criteria.andAdoptedEqualTo(0);
			
			List<Star> dogList = ss.selectByExample(example);
			req.setAttribute("List", dogList);
			req.setAttribute("adopted", "0");
			return "list";
		} catch (Exception e) {
			System.out.println("dogList.do出错");
			return "error";
		}
		
	}
	
	@RequestMapping("otherList.do")
	public String otherList(HttpServletRequest req) {
		
		try {
			StarExample example = new StarExample();
			Criteria criteria = example.createCriteria();
			criteria.andTypeEqualTo(3);
			criteria.andAdoptedEqualTo(0);
			
			List<Star> otherList = ss.selectByExample(example);
			req.setAttribute("List", otherList);
			req.setAttribute("adopted", "0");
			return "list";
		} catch (Exception e) {
			System.out.println("otherList.do出错");
			return "error";
		}
		
	}
	
	@RequestMapping("addStar.do")
	public void addStar(String name, String photo, String age, String sex, String address,
			String phone, String type, String breed, HttpSession session,HttpServletResponse resp) throws IOException{
		int ageInt = 0; 
		int sexInt = 0;
		int typeInt = 0;
		User user = (User) session.getAttribute("user");
		int momid = user.getId();
		if(age!=null) {ageInt = Integer.parseInt(age);}
		if(sex!=null) {sexInt = Integer.parseInt(sex);}
		if(type!=null) {typeInt = Integer.parseInt(type);}
		
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("addStar.do");
		
		Star star = new Star();
		star.setName(name);
		star.setPhoto(photo);
		star.setAge(ageInt);
		star.setSex(sexInt);
		star.setAddress(address);
		star.setPhone(phone);
		star.setType(typeInt);
		star.setAdopted(0);
		star.setBreed(breed);
		star.setMomid(momid);
		
		int i = ss.insertSelective(star);
//		resp.setContentType("text/html;charset=UTF-8");
		if(i>0) {
//			model.addAttribute("msg", "添加成功！");
			resp.getWriter().print("添加成功！");
		}else {
//			model.addAttribute("msg", "添加失败！");
			resp.getWriter().print("添加失败！");
		}
		
		
	}
	
	@RequestMapping("showStar.do")
	public String showStar(HttpServletRequest req) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			StarExample example = new StarExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			
			List<Star> starList = ss.selectByExample(example);
			Star star = starList.get(0);
			
			req.setAttribute("showStar", star);
			return "showStar";
		} catch (Exception e) {
			
			System.out.println("showStar.do 出错");
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("adoptStar.do")
	public String adoptStar(HttpServletRequest req) {
		
		StarExample example = new StarExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdoptedEqualTo(1);
		
		List<Star> adoptedList = ss.selectByExample(example);
		req.setAttribute("List", adoptedList);
		req.setAttribute("adopted", "1");
		
		return "list";
		
	}
	
	@RequestMapping("toAddStar")
	public String toAddStar() {
		return "addStar";
	}
	
	@RequestMapping("toList")
	public String toList() {
		return "list";
	}
	
	@RequestMapping("toShowStar")
	public String toShowStar() {
		return "showStar";
	}
	
}
