package com.mystudy.pm01_map_score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapScoreExam {
	
	public static void main(String[] args) {
		//1. HashMap<String, Integer> Ÿ���� ���� map�� �����ϰ�
		//2. map�� �̸�:���� ������ �Ʒ��� ����Ÿ�� �Է�
		//   "ȫ�浿:100, ������:90, ��������:95, ���:87, ������:92"
		//3. �Էµ� ����Ÿ�� ��ȸ�ؼ� ������ ������ tot�� ����
		//4. ����(tot)�� ���� �ο� ���� ���� ��� ���� avg�� ����
		//5. ����Ͻÿ�.
		//   ����  ����
		//   -----------
		//   �̸�: ����
		//   �̸�: ����
		//   ...
		//   �̸�: ����
		//   ==========
		//   ����: ???
		//   ���: ???
		////////////////////////////////////////////
		int sum=0;
	
		Map<String, Integer> score = new HashMap<String, Integer>();
		score.put("ȫ�浿", 100);
		score.put("������", 90);
		score.put("��������", 95);
		score.put("���", 87);
		score.put("������", 92);

		Set<Map.Entry<String, Integer>> scoreSet = score.entrySet();
		Iterator<Map.Entry<String, Integer>> scoreIte = scoreSet.iterator();
		
		while (scoreIte.hasNext()) {
			Map.Entry<String, Integer> e = scoreIte.next();
			sum += e.getValue();
		}
		
		System.out.println("�̸� \t����");
		System.out.println("------------");
		scoreIte = scoreSet.iterator();
		while (scoreIte.hasNext()) {
			Map.Entry<String, Integer> e = scoreIte.next();
			System.out.println(e.getKey() +" :\t"+ e.getValue());
		}
		System.out.println("============");
		System.out.println("���� : \t"+ sum);
		double avg = (sum * 100) / scoreSet.size() / 100.0;
		System.out.println("��� : \t"+ avg);
		
	}
	
}
