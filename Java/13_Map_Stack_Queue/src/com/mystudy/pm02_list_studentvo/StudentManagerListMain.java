package com.mystudy.pm02_list_studentvo;

public class StudentManagerListMain {

	public static void main(String[] args) {
		StudentManagerList manager = new StudentManagerList();
		StudentVO vo = new StudentVO("ȫ�浿", 80, 50, 100);
		manager.inputBasicData();
		
		manager.printScore();
		System.out.println();
		
		
		manager.getData("������");
		System.out.println("------------");
		manager.printDataAll();
		System.out.println("----------");
		manager.updateData(vo);
		manager.printDataAll();
		System.out.println("-------------");
		manager.getData(80);
		
		
	}

}
