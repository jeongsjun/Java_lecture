package day_250401.Homework;

public class Student {
	String name;
	int midExam;
	int finalExam;
	int total;
	double avg;
	
	Student(String name, int midExam, int finalExam) {
		this.name = name;
		this.midExam = midExam;
		this.finalExam = finalExam;
		this.total = this.midExam + this.finalExam;
		this.avg = (double) this.total / 2;		
	}
}
