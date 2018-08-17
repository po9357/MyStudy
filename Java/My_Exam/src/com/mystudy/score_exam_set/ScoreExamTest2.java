package com.mystudy.score_exam_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScoreExamTest2 {

	public static void main(String[] args) {
		ScoreExamVO2 vo1 = new ScoreExamVO2("ȫ�浿", 90, 80, 70);
		ScoreExamVO2 vo2 = new ScoreExamVO2("ȫ�浿2", 50, 70, 20);
		ScoreExamVO2 vo3 = new ScoreExamVO2("ȫ�浿3", 60, 70, 20);
		ScoreExamVO2 vo4 = new ScoreExamVO2("ȫ�浿4", 70, 40, 80);
		ScoreExamVO2 vo5 = new ScoreExamVO2("ȫ�浿5", 80, 60, 90);
		
		List<ScoreExamVO2> list = new ArrayList<ScoreExamVO2>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		
		System.out.println(list.get(0));
		System.out.println("=============================================");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		for (int i=0; i<list.size(); i++) {
			list.get(i).printDataAll(list.get(i));
		}
		System.out.println("=============================================");
		System.out.println();
		
		Set<ScoreExamVO2> set = new HashSet<ScoreExamVO2>(list);
		System.out.println("ArrayList -> HashSet");
		System.out.println(set);
		Iterator<ScoreExamVO2> ite = set.iterator();
		System.out.println("=============================================");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		while (ite.hasNext()) {
			ite.next().printDataSet();
		}
		System.out.println("=============================================");
		
	}
}
