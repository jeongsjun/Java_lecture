// 학생 메소드 생성
package day_250401.Class;

import java.util.Scanner;

public class StudentMethod {
	Scanner s = new Scanner(System.in);	
	
	Student[] student = new Student[10]; // 배열 공간만 만든거임
	
	int korSum = 0;
	int engSum = 0;
	int mathSum = 0;
	double korAvg;
	double engAvg;
	double mathAvg;
	
	public void inputStudent() {
		for (int i = 0; i < student.length; i++) {
			student[i] = new Student();
			student[i].inputData();
			
			System.out.println("" + (i+1) + "번째 학생의 이름은 " + this.student[i].name);
			System.out.println("" + (i+1) + "번째 학생의 국어, 영어, 수학 점수는 "+ this.student[i].korScore + ", " + this.student[i].engScore + ", " + this.student[i].mathScore + " 입니다.");
		}
		
	}
	
	public void outputSum() {
		for (int i = 0; i < student.length; i++) {
			this.korSum += this.student[i].korScore;
			this.engSum += this.student[i].engScore;
			this.mathSum += this.student[i].mathScore;
		}
		System.out.println("국어의 점수 총합은 " + this.korSum + "입니다.");
		System.out.println("영어의 점수 총합은 " + this.engSum + "입니다.");
		System.out.println("수학의 점수 총합은 " + this.mathSum + "입니다.");
	}
	
	public void outputAvg() {
		this.korAvg = (double) this.korSum / student.length;
		System.out.println("국어의 점수 평균은 " + this.korAvg + "입니다.");
		
		this.engAvg = (double) this.engSum / student.length;
		System.out.println("영어의 점수 평균은 " + this.engAvg + "입니다.");
		
		this.mathAvg = (double) this.mathSum / student.length;
		System.out.println("수학의 점수 평균은 " + this.mathAvg + "입니다.");
	}
}
