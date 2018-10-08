package com.movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.movieDAO;
/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;");
		HttpSession session = request.getSession();
		
		String movieName = (String) session.getAttribute("movie"); 
		
		movieDAO dao = new movieDAO();
		HashMap<String, Integer> seatMap = dao.cntSeat("1관");
		HashMap<String, ArrayList<String>> mvThMap = dao.mvNothName(movieName);
		session.setAttribute("theater", mvThMap);
		request.setAttribute("mapSize", seatMap.size());
		request.setAttribute("map", seatMap);
		
		RequestDispatcher view = request.getRequestDispatcher("bookingTest2.jsp");
		view.forward(request, response);
		
		
		
		
//		Iterator<String> ite = seatMap.keySet().iterator();
//		int cnt = 0;
//		int colNum = 0;
//		String rowName = "";
//		ArrayList<String> rowList = new ArrayList<>();
//		ArrayList<Integer> colList = new ArrayList<>();
//		HashMap<String, Integer> map = new HashMap<>();
//		while(ite.hasNext()) {
//			rowName = ite.next();
//			colNum = seatMap.get(rowName);
//			
//			rowList.add(rowName);
//			colList.add(colNum);
//		}
//		request.setAttribute("rowName", rowList);
//		request.setAttribute("colNum", colList);
		
		
		
		
	}

}
