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
 * Servlet implementation class PrintTicket
 */
@WebServlet("/PrintTicket")
public class PrintTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;");

		HttpSession session = request.getSession();
		
		String theaterNo = (String) session.getAttribute("theaterNo");
		ArrayList seatNoList = (ArrayList) session.getAttribute("seatNoList");
		String movieNo = (String)session.getAttribute("movieNo");
		String memberId = (String) session.getAttribute("Id");
		String bookingDate = (String) session.getAttribute("bookingDate");
		String timeNo = (String)session.getAttribute("timeNo");
		String priceStr = request.getParameter("price");
		int price = Integer.parseInt(priceStr);
//		int price = Integer.parseInt(request.getParameter("price"));
		
		String payType = request.getParameter("pay");
		if (payType.equalsIgnoreCase("card")) {
			payType = "카드";
		}else {
			payType = "현금";
		}
		
		
		movieDAO dao = new movieDAO();
		dao.insBooking_seat(bookingDate, timeNo, seatNoList);	// Booking_Seat 인서트
		String ticketNo = dao.insTicket(theaterNo, seatNoList, movieNo, memberId, timeNo, bookingDate, price);	// ticketing 인서트
		dao.insBank(payType, price);	// Bank 인서트
		
		session.setAttribute("ticketNo", ticketNo);
		
		
		RequestDispatcher view = request.getRequestDispatcher("thankyou.jsp");
		view.forward(request, response);
		
	}


}
