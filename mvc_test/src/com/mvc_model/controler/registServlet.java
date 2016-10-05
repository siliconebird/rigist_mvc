package com.mvc_model.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.mvc_model.domain.Users;
import com.mvc_model.exception.UserHasExistException;
import com.mvc_model.service.BussnisService;
import com.mvc_model.service.BussnisServiceImpl;
import com.mvc_model.util.beanUtil;
import com.mvc_model.web.formatbean.FormatBean;

import sun.text.resources.cldr.en.FormatData_en_BE;

/**
 * Servlet implementation class registServlet
 */
@WebServlet("/servlet/registServlet")
public class registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BussnisService bservice= new BussnisServiceImpl(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		FormatBean bean = null;
		try {
			bean= beanUtil.fillBean(request, FormatBean.class);
			if(!bean.validate()){
				request.setAttribute("formatbean", bean);
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
			}else{
				Users user = new Users();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, bean);
				bservice.regist(user);
				response.sendRedirect(request.getContextPath());
			}
		} catch (UserHasExistException e) {
			// TODO Auto-generated catch block
			bean.getErrors().put("username", e.getMessage());
			request.setAttribute("formatbean", bean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
