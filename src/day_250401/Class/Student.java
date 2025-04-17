package day_250401.Class;

import java.util.Scanner;

public class Student {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	
	public void inputData() {
		Scanner s = new Scanner(System.in);	
		
		System.out.print("학생의 이름 : ");
		this.name = s.nextLine();
		System.out.print("입력한 학생의 국어 점수 : ");
		String tmpString = s.nextLine();
		this.korScore = Integer.parseInt(tmpString);
		System.out.print("입력한 학생의 영어 점수 : ");
		tmpString = s.nextLine();
		this.engScore = Integer.parseInt(tmpString);
		System.out.print("입력한 학생의 수학 점수 : ");
		tmpString = s.nextLine();
		this.mathScore = Integer.parseInt(tmpString);
	}
}
