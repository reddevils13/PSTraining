package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RestaurantDao;
import com.dao.UserDao;
import com.to.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {

			String h1 = request.getParameter("h1");
			if (h1.equals("Home")) {
				String s1 = request.getParameter("choice");
				if (s1.equals("SignUp")) {

					request.setAttribute("choice", 100);

					rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				} else if (s1.equals("SignIn")) {

					rd = request.getRequestDispatcher("Home.jsp");

					request.setAttribute("choice", 200);
					rd.forward(request, response);

				}
			}

			else if (h1.equals("NewRegister")) {
				UserDao userDao = new UserDao();

				User user = new User(request.getParameter("uid"), request.getParameter("email"),
						request.getParameter("password"), request.getParameter("name"), request.getParameter("phone"));

				userDao.insertStudent(user);

				request.setAttribute("message", "Record inserted");
				rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);

			} else if (h1.equals("Login")) {
				User user = new User(request.getParameter("uid"), null, request.getParameter("password"), null, null);

				UserDao userDao = new UserDao();

				user = userDao.getUser(user);

				rd = request.getRequestDispatcher("Restaurant.jsp");

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", user);
				rd.forward(request, response);
			}

		} catch (Exception e) {
			rd = request.getRequestDispatcher("Home.jsp");
			System.out.println(e.getMessage());
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);
		}

	}

}
