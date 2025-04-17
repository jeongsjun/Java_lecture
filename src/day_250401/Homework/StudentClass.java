package day_250401.Homework;

import java.util.Scanner;

public class StudentClass {
	StudentMethod[] studentMethod = new StudentMethod[5];
	
	public void makeClass() {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < studentMethod.length; i++) {
			studentMethod[i] = new StudentMethod();
			System.out.print("반의 이름을 정해주세요 : ");
			String className = scanner.nextLine();
			
			System.out.println(className + "반의 학생 이름 10명과 각 학생의 중간고사 점수와 기말고사 점수를 입력해주세요.");
			studentMethod[i].inputStudent();
			
			System.out.println();
			System.out.println(className + "반의 총점");
			studentMethod[i].outputTotal();
			
			System.out.println();
			System.out.println(className + "반의 평균");
			studentMethod[i].outputAvg();
			
			System.out.println();
			System.out.println(className + "반의 등수");
			studentMethod[i].sortRanking();
			System.out.println();
		}
	}
}
