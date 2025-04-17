package day_250401.Homework;

public class MainClass {
	public static void main(String[] args) {
		// 1. 반 객체 생성
		StudentClass studentClass = new StudentClass();

		// 2. 반 객체의 각 메소드 실행
		studentClass.makeClass();
		studentClass.outputTotal();
		studentClass.outputAvg();
		studentClass.sortRanking();
	}
}