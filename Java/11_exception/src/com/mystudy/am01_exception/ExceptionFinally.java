package com.mystudy.am01_exception;

public class ExceptionFinally {
public static int a = 0;
public int b = 1;
	public static void main(String[] args) {
		//try ~ catch  finally
		System.out.println("--- main() ���� ---");
		int num = 0;
		try {
			System.out.println(">> try�� ����");
			System.out.println(">> ����ó�� ����");
			int result = 100 / num;			//���ܹ߻� ���� : 0���� ����
			System.out.println(">> ����ó�� ���� ����");
			System.out.println(">> try�� ����");
		} catch (ArithmeticException e) {
			System.out.println(">> catch�� ����");
		} finally {
			System.out.println(">> finally : �׻� ����(������)");
		}
		System.out.println("------------------");
		System.out.println("test() ���� ��� : "+ test());
		
		
		System.out.println("--- main() ���� ---");
//		System.out.println(a);		//����ƽ �޼ҵ忡�� ����ƽ ������ ��� ����
////		System.out.println(b);		//����ƽ �޼ҵ忡�� �ν��Ͻ� ������ ��� �Ұ���
//		ExceptionFinally ef = new ExceptionFinally();
//		System.out.println(ef.b);	//����ƽ �޼ҵ忡�� �ν��Ͻ� ������ ��ü���� �� ��� ����
	}
		static String test() {
			String result = "";
			int[] num = new int[3];
			
			try {
				num[3] = 100;
				result = "<�������>";
			} catch (Exception e) {
				result = "<���ܹ߻�>"+ e.getMessage();
				e.printStackTrace();
			} finally {
				System.out.println("finally : ������ ����");
			}
		
			return result;
		}
		
		
		
		
		
		
		
		
		
	
}

