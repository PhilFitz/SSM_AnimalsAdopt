package com.adopt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adopt.pojo.User;
import com.adopt.service.StarService;
import com.adopt.service.UserService;

@Controller
@MultipartConfig
public class UtilServlet {

	@Resource
	private UserService us;
	@Resource
	private StarService ss;

	
	@RequestMapping("/upload.do")	
	protected void upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("upload.do");
		
		req.setCharacterEncoding("utf-8");
		User user = (User) req.getSession().getAttribute("user");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String createdate = sdf.format(date);
		Part part = req.getPart("img");
		InputStream is = part.getInputStream();
		String realFileName = user.getPhone()+ "@" + createdate + ".jpg";
		System.out.println(realFileName);
		OutputStream os = new FileOutputStream(new File("E:/JAVA/ego/adopt_ssm/src/main/webapp/img", realFileName));
		int len = 0;
		byte[] buff = new byte[1024*8];
		
		while((len = is.read(buff)) > -1) {
			os.write(buff, 0, len);
			
		}
		is.close();
        os.close();
        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().print("/adopt-web/img/"+ realFileName);
        resp.getWriter().print(realFileName);
	}

	@RequestMapping("download.do")
	public void download(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String fileName = req.getParameter("file");
//		File img = new File("/usr/java/tomcat/apache-tomcat-9.0.24/webapps" + fileName);
		File img = new File("E:/JAVA/ego/adopt_ssm/src/main/webapp/img/" + fileName);
		InputStream is = new FileInputStream(img);
		copy(is, res.getOutputStream());
		is.close();
	}

	public static void copy(InputStream in, java.io.OutputStream out) throws IOException {
		byte[] buffer = new byte[1024 * 10];
		while ((in.read(buffer)) != -1) {
			out.write(buffer);
		}
	}
}
