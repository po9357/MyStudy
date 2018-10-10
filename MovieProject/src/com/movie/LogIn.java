package com.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.movieDAO;
/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;");
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		out.println("hi");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<script>");
		movieDAO dao = new movieDAO();
		boolean check = dao.logIn(id, password);
		RequestDispatcher view = request.getRequestDispatcher("MovieMain2.jsp");
		if (check) {
			out.println("alert('로그인에 성공하였습니다')");
			session.setAttribute("Id", id);
			session.setAttribute("Password", password);
			view.forward(request, response);
		} else {
			out.println("alert('[로그인 실패] 아이디와 비밀번호를 확인하여 주십시오')");
			out.println("history.back()");
		}
		
		out.println("</script>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("</body>");
		out.println("</html>");
		
	}


}
