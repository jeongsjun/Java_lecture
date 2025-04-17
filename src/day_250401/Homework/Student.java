package day_250401.Homework;

public class Student {
	// 1. 학생의 이름, 중간고사 점수, 기말고사 점수, 학생 개인의 총점과 평균 변수 선언
	String name;
	int midExam;
	int finalExam;
	int total;
	double avg;

	// 2. 생성자 생성
	Student(String name, int midExam, int finalExam) {
		this.name = name;
		this.midExam = midExam;
		this.finalExam = finalExam;
		this.total = this.midExam + this.finalExam;
		this.avg = (double) this.total / 2;		
	}
}