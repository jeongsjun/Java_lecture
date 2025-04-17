package day_250401.Homework;

import java.util.Scanner;

public class StudentMethod {
	// 1. 학생 객체 배열 10개 생성
	Student[] student = new Student[10];

	// 2. 10명의 학생의 총합과 평균의 변수, 평균 점수 순위와 학생 순위 리스트 선언
	int totalSum = 0;
	double totalAvg;
	double[] rank = new double[10];
	String[] rankStudent = new String[10];

	// 3. 반의 이름을 담을 변수 선언
	String name;

	// 4. 학생 개인의 정보를 넣을 메소드
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

	

	// 5. 전체 학생의 총합을 출력하는 메소드
	public void outputTotal() {
		for (int i = 0; i < student.length; i++) {
			this.totalSum += student[i].midExam + student[i].finalExam;
		}
		System.out.println("총점 : " + this.totalSum);
	}

	
	// 6. 전체 학생의 평균을 출력하는 메소드
	public void outputAvg() {
		this.totalAvg = (double) this.totalSum / student.length;
		System.out.println("평균 : " + this.totalAvg);
	}

	// 7. 등수를 계산해 출력하는 메소드
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