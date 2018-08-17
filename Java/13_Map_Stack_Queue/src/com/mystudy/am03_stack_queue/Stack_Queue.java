package com.mystudy.am03_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//큐(Queue) 인터페이스 - LinkedList 클래스
// - 형태상 파이프 모양 (선입선출)

//스택(Stack)
//형태상으로 바닥이 막힌 통의 형태 (후입 선출)
public class Stack_Queue {

	public static void main(String[] args) {
		//큐 (Queue) : 선입선출
		System.out.println("--- 큐 (Queue) : 선입선출  ---");
		Queue que = new LinkedList();
		que.offer("1. 첫째");			//add와 동일
		que.offer("2. 둘째");
		que.offer("3. 셋째");
		que.offer("4. 넷째");
		System.out.println(que);
		System.out.println("--- que.peek() ---");
		System.out.println("que.peek() : "+ que.peek());
		System.out.println("que.peek() : "+ que.peek());
//		System.out.println("--- que.poll() ---");
//		System.out.println("que.poll() : "+ que.poll());
//		System.out.println("que.poll() : "+ que.poll());
		
		//전체 데이터 추출
		System.out.println("--- 전체 데이터 추출 ---");
		System.out.println("que.isEmpty() : "+ que.isEmpty());
		//큐가 비어있지 않은면 데이터 추출
		System.out.println("que.size() : "+ que.size());
//		while (que.isEmpty() == false) {
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
		System.out.println("que.size() : "+ que.size());
		
		/////////////////////////////////////////////////
		System.out.println("=== 스택(Stack) : LIFO (후입 선출) ===");
		Stack st = new Stack();
		st.push("1. 첫째");
		st.push("2. 둘째");
		st.push("3. 셋째");
		st.push("4. 넷째");
		System.out.println(st);
		System.out.println("st.peek() : "+ st.peek());
		System.out.println("st.size() : "+ st.size());
		
		
		//peek(), pop() 데이터를 조회 또는 꺼낼 때 비어있으면
		//EmptyStackException 예외 발생
//		System.out.println("st.pop() : "+ st.pop());
//		System.out.println("st.pop() : "+ st.pop());
//		System.out.println("st.pop() : "+ st.pop());
//		System.out.println("st.pop() : "+ st.pop());
//		System.out.println("st.pop() : "+ st.pop());		//java.util.EmptyStackException
//		System.out.println("st.peek() : "+ st.peek());		//java.util.EmptyStackException
		
		System.out.println("--- 전체 데이터 조회 ---");
		System.out.println(st.isEmpty());
		System.out.println(st.empty());
		while (!st.isEmpty()) {				//비어있지 않으면
			System.out.println(st.pop());
		}
		System.out.println("st.size() : "+ st.size());
		
	}

}
