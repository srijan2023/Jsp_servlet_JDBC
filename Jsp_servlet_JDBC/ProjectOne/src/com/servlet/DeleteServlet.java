package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		int id = Integer.parseInt(userId);
		//response.getWriter().print("You have selected user Id : "+id);
		UserDao userDao = new UserDaoImpl();
		com.model.User del = userDao.getUserById(id);
		if(del!=null)
		{
			boolean b = userDao.deleteUserByid(id);
			PrintWriter out = response.getWriter();
			out.println("Entry has been deleted successful");
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
