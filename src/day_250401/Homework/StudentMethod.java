package day_250401.Homework;

import java.util.Scanner;

public class StudentMethod {
	Student[] student = new Student[3];
	int totalSum = 0;
	double totalAvg;
	double[] rank = new double[3];
	String[] rankStudent = new String[3];
	
	public void inputStudent() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < student.length; i++) {
			System.out.print("학생의 이름 : ");
			String tempString = scanner.nextLine();
			String name = tempString;
			
			System.out.print("중간고사 점수 : ");
			tempString = scanner.nextLine();
			int midExam = Integer.parseInt(tempString);
			
			System.out.print("기말고사 점수 : ");
			tempString = scanner.nextLine();
			int finalExam = Integer.parseInt(tempString);
			System.out.println();
			
			student[i] = new Student(name, midExam, finalExam);
		}
	}
	
	public void outputTotal() {
		for (int i = 0; i < student.length; i++) {
			totalSum += student[i].midExam + student[i].finalExam;
		}
		System.out.println("총점 : " + totalSum);
	}
	
	public void outputAvg() {
		totalAvg = (double) totalSum / student.length;
		System.out.println("평균 : " + totalAvg);
	}
	
	public void sortRanking() {
		for (int i = 0; i < student.length; i++) {
			rank[i] = student[i].avg;
		}
		
		for (int i = 1; i < rank.length; i++) {
			double key = rank[i]; 	
			int j = i - 1; 
			while (j >= 0 && rank[j] < key) {
				rank[j + 1] = rank[j];
				j--;
			}	
			rank[j + 1] = key;
		}
		
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < student.length; j++) {
				if (rank[i] == student[j].avg) {
					rankStudent[i] = student[j].name;
				}
			}
		}
		
		for (int i = 0; i < rankStudent.length; i++) {
			System.out.println("" + (i+1) + "등 : " + rankStudent[i]);
		}
	}
}
