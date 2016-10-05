package com.mvc_model.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc_model.domain.Users;
import com.mvc_model.service.BussnisService;
import com.mvc_model.service.BussnisServiceImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/servlet/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BussnisService bserver = new BussnisServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users user = null;
		user = bserver.login(username, password);
		if(user==null){
			out.write("account&password wrong!pls check out! retun to loginpage in 2s");
			response.setHeader("Refresh", "2;URL='"+request.getContextPath()+"/login.jsp'");
		}else{
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
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
