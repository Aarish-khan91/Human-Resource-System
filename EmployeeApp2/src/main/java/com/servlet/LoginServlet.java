package com.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.emp.Employee;
import com.user.User;
import com.DAO.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			String email = req.getParameter("email");
			String pword = req.getParameter("pword");

			User user = new UserDAO().retrieveUser(email, pword);
			if (user.getFname() != null) {
				//System.out.println(user.getFname());
				req.setAttribute("fname", user.getFname());
				req.getRequestDispatcher("logsuccess.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("login.html").forward(req, resp);

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	}