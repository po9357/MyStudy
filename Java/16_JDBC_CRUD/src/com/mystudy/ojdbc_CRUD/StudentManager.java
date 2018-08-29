package com.mystudy.ojdbc_CRUD;

import java.util.ArrayList;

public class StudentManager {
	   private ArrayList<StudentVO> list;
	   
	   StudentManager() {
	      list = new ArrayList<>();
	   }
	   
	   StudentManager(ArrayList<StudentVO> list) {
	      this.list = list;
	   }

	   public StudentVO selectOne(String id) {
	      StudentVO result = null;
	      //list에 있는 데이타를 전달받은 id과 동일한 이름의 데이타가 있으면 리턴
	      //없으면 null 리턴
	      
	      return result;
	   }
	   public StudentVO selectOne(StudentVO vo) {
	      StudentVO result = null;
	      //list에 있는 데이타를 전달받은 vo의 id와 동일한 이름의 데이타가 있으면 리턴
	      //없으면 null 리턴
	      
	      return result;
	   }
	   
	   public ArrayList<StudentVO> selectAll() {
	      ArrayList<StudentVO> result = null;
	      //전체 데이타를 리턴 처리
	      
	      return result;
	   }
	   
	   public int insert(StudentVO vo) {
	      int result = 0;
	      //전달받은 vo의 id가 list에 없으면 list에 추가(1 리턴)
	      //전달받은 vo의 id가 list에 있으면 "이미 존재하는 데이타" 출력(0 리턴)
	      
	      
	      return result;
	   }
	   
	   public int update(StudentVO vo) {
	      int result = 0;
	      //전달받은 vo의 id가 list에 있으면 수정처리(1 리턴)
	      //  (키값인 id를 제외하고 모든 데이타를 수정처리) 
	      //전달받은 vo의 id가 list에 없으면 "데이타 없어서 수정못함" 출력(0 리턴)
	      
	      
	      
	      return result;
	   }
	   public int delete(StudentVO vo) {
	      int result = 0;
	      //전달받은 vo의 id가 list에 있으면 삭제처리(성공시 1 리턴, 실패시 0리턴)
	      //전달받은 vo의 id가 list에 없으면 "데이타 없어서 삭제 못함" 출력(0 리턴)
	      
	      
	      return result;
	   }
	   public int delete(String id) {
	      int result = 0;
	      //전달받은 id가 list에 있으면 삭제처리(성공시 1 리턴, 실패시 0리턴)
	      //전달받은 id가 list에 없으면 "데이타 없음" 출력(0 리턴)
	      
	      
	      return result;
	   }
	   
	   public void displayAll() {
	      //list에 있는 데이타를 전체 화면 출력
	      
	   }
	   public void displayOne(StudentVO vo) {
	      //list에 있는 데이타 중 vo의 id와 일치하는 데이타 화면 출력
	      //없으면 "데이타 없음" 화면 출력
	      
	   }
	   public void displayOne(String id) {
	      //list에 있는 데이타 중 id와 일치하는 데이타 화면 출력
	      //없으면 "데이타 없음" 화면 출력
	      
	   }
	   
	   public void printSungjuk() {
	      //list에 있는 데이타 전체를 양식에 맞춰 화면에 출력
	      //성명     국어    영어    수학     총점     평균
	      //------------------------------
	      //홍길동  100  90   80   270   90.0
	      //.....
	   }
}
