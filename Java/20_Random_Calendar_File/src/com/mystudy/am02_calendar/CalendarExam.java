package com.mystudy.am02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date(): " + date);

		//월 : 0 ~ 11 - 0:1월, 1:2월, ..., 11:12월
		date = new Date(118, 7, 30); //1900 기준
		System.out.println("new Date(118, 7, 30) : " + date);
		
		//------------------------------------
		System.out.println("--------- Calendar ------------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println("년도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일: " + cal.get(Calendar.DATE));
		
		System.out.println("오전오후: " + cal.get(Calendar.AM));
		System.out.println("시(12시간): " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: " + cal.get(Calendar.MINUTE));
		System.out.println("초: " + cal.get(Calendar.SECOND));
		
		//년-월-일 시:분:초  또는 년/월/일 시:분:초
		String dateTime = cal.get(Calendar.YEAR) 
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("년-월-일 시:분:초 >> " + dateTime);
		
		System.out.println("======== SimpleDateFormat ============");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("yyyy-MM-dd hh:mm:ss : " + sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy/MM/dd a h:m:s");
		System.out.println("yyyy/M/d a h:m:s : " + sdf.format(date));
	}

}






