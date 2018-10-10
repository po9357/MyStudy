package com.movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.movieDAO;
/**
 * Servlet implementation class Ticket
 */
@WebServlet("/toPay")
public class ToPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		String movieNo = request.getParameter("movieNo");
		String timeNo = request.getParameter("timeNo");
		String bookingDate = request.getParameter("bookingDate");
		String theaterName = request.getParameter("theaterName");
		String seatLength = request.getParameter("seatLength");
		String selTime = request.getParameter("selTime");
		String theaterNo = "";
		int length = Integer.parseInt(seatLength);
		ArrayList<String> seatList = new ArrayList<>();
		ArrayList<String> seatNoList = new ArrayList<>();
		for (int i=0; i<length; i++) {
			seatList.add(request.getParameter("seat"+i));
		}
		
		movieDAO dao = new movieDAO();
		theaterNo = dao.selThNo(movieNo, theaterName);	// 상영관 넘버 구함
		seatNoList = dao.seatNoList(seatList, theaterName);	// seatNo 리스트
		
		HttpSession session = request.getSession();
		session.setAttribute("movieNo", movieNo);
		session.setAttribute("timeNo", timeNo);
		session.setAttribute("bookingDate", bookingDate);
		session.setAttribute("theaterNo", theaterNo);
		session.setAttribute("theaterName", theaterName);
		session.setAttribute("seatNoList", seatNoList);
		session.setAttribute("seatLength", seatLength);
		session.setAttribute("seatList", seatList);
		session.setAttribute("selTime", selTime);
		
		RequestDispatcher view = request.getRequestDispatcher("pay.jsp");
		view.forward(request, response);
		
	}

}
