package com.bookappcore.controller;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookappcore.dao.UserDAO;
import com.bookappcore.user.User;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		 
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPsw(psw);
		
		UserDAO userdao = new UserDAO();
		try {
			if(userdao.register(user))
				response.sendRedirect("menu.jsp");
			else
				response.getWriter().println("This username or Email-ID alreay Exists");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}
}


