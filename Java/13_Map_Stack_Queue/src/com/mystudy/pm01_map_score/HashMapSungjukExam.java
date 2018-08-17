package com.mystudy.pm01_map_score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapSungjukExam {
	HashMap<String, Integer> sungjuk;
	int tot;
	double avg;
	
	void printData() {
		//5. ����Ͻÿ�.
		//   ����  ����
		//   -----------
		//   ȫ�浿: 100
		//   ������: 90
		//   ...
		//   ������: 92
		//   ==========
		//   ����: ???
		//   ���: ???
		System.out.println("����\t����");
		System.out.println("--------------");
		
		//����Ÿ ���
		displayData("\t");
		
		System.out.println("==============");
		System.out.println("����\t" + tot);
		System.out.println("���\t" + avg);
		
	}

	void computeAvg() {
		//4. ����(tot)�� ���� �ο� ���� ���� ��� ���� avg�� ����
		computeTot();
		avg = (tot * 100) / sungjuk.size() / 100.0;
		
	}

	void computeTot() {
		//3. �Էµ� ����Ÿ�� ��ȸ�ؼ� ������ ������ tot�� ����
		tot = 0;
		for (String name : sungjuk.keySet()) {
			tot += sungjuk.get(name);
		}
		
	}

	void inputData() {
		//2. map�� �̸�:���� ������ �Ʒ��� ����Ÿ�� �Է�
		//   "ȫ�浿:100, ������:90, ��������:95, ���:87, ������:92"
		sungjuk.put("ȫ�浿", 100);
		sungjuk.put("������", 90);
		sungjuk.put("��������", 95);
		sungjuk.put("���", 87);
	}
	
	void displayData() {
		for (String name : sungjuk.keySet()) {
			System.out.println(name + ":" + sungjuk.get(name));
		}
	}
	void displayData(String delim) {
		for (String name : sungjuk.keySet()) {
			System.out.println(name + delim + sungjuk.get(name));
		}
	}
	
	
	
	
}
