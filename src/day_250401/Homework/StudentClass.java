package day_250401.Homework;

import java.util.Scanner;

public class StudentClass {
	// 1. 반 객체 배열 5개 선언
	StudentMethod[] studentMethod = new StudentMethod[5];

	// 2. 전체 반의 총합과 평균 변수, 전체 반 평균 점수의 순위와 전체 반 등수를 담을 리스트 선언.
	int totalSum = 0;
	double totalAvg;
	double[] rank = new double[5];
	String[] rankClass = new String[5];

	// 3. 반의 이름을 정하고 반의 학생 이름과 점수를 입력 후 반의 총점과 평균을 출력하는 메소드
	public void makeClass() {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < studentMethod.length; i++) {
			studentMethod[i] = new StudentMethod();
			System.out.print("반의 이름을 정해주세요 : ");
			String className = scanner.nextLine();
			studentMethod[i].name = className;

			System.out.println(studentMethod[i].name + "반의 학생 이름 10명과 각 학생의 중간고사 점수와 기말고사 점수를 입력해주세요.");
			studentMethod[i].inputStudent();

			System.out.println();
			System.out.println(studentMethod[i].name + "반의 총점");
			studentMethod[i].outputTotal();

			System.out.println();
			System.out.println(studentMethod[i].name + "반의 평균");
			studentMethod[i].outputAvg();

			System.out.println();
			System.out.println(studentMethod[i].name + "반의 등수");
			studentMethod[i].sortRanking();

			System.out.println();
		}
	}

	

	// 4. 전체 반의 총점을 출력하는 메소드
	public void outputTotal() {
		for (int i = 0; i < studentMethod.length; i++) {
			this.totalSum += studentMethod[i].totalSum;
		}
		System.out.println("전체 반의 총점 : " + this.totalSum);
	}

	

	// 5. 전체 반의 평균을 출력하는 메소드
	public void outputAvg() {
		this.totalAvg = (double) this.totalSum / studentMethod.length;
		System.out.println("전체 반의 평균 : " + this.totalAvg);
	}

	

	// 6. 전체 반의 등수를 계산해 출력하는 메소드
	public void sortRanking() {
		for (int i = 0; i < studentMethod.length; i++) {
			rank[i] = studentMethod[i].totalAvg;
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
			for (int j = 0; j < studentMethod.length; j++) {
				if (rank[i] == studentMethod[j].totalAvg) {
					rankClass[i] = studentMethod[j].name;
				}
			}
		}

		System.out.println("전체 반의 등수");
		for (int i = 0; i < rankClass.length; i++) {
			System.out.println("" + (i+1) + "등 : " + rankClass[i]);
		}
	}
}