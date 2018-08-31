package com.mystudy.am02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date(): " + date);

		//�� : 0 ~ 11 - 0:1��, 1:2��, ..., 11:12��
		date = new Date(118, 7, 30); //1900 ����
		System.out.println("new Date(118, 7, 30) : " + date);
		
		//------------------------------------
		System.out.println("--------- Calendar ------------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println("�⵵: " + cal.get(Calendar.YEAR));
		System.out.println("��: " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("��: " + cal.get(Calendar.DATE));
		
		System.out.println("��������: " + cal.get(Calendar.AM));
		System.out.println("��(12�ð�): " + cal.get(Calendar.HOUR));
		System.out.println("��(24�ð�): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("��: " + cal.get(Calendar.MINUTE));
		System.out.println("��: " + cal.get(Calendar.SECOND));
		
		//��-��-�� ��:��:��  �Ǵ� ��/��/�� ��:��:��
		String dateTime = cal.get(Calendar.YEAR) 
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("��-��-�� ��:��:�� >> " + dateTime);
		
		System.out.println("======== SimpleDateFormat ============");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("yyyy-MM-dd hh:mm:ss : " + sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy/MM/dd a h:m:s");
		System.out.println("yyyy/M/d a h:m:s : " + sdf.format(date));
	}

}






