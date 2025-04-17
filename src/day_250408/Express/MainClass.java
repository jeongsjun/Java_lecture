// 메인 클래스
package day_250408.Express;

public class MainClass {
	public static void main(String[] args) {
		// 1. 학생 메소드 객체 생성
		StudentMethod studentMethod = new StudentMethod();
		
		// 2. 학생 메소드 객체의 각 메소드 실행
		studentMethod.inputData();
		System.out.println();
		studentMethod.countGender();
		System.out.println();
		studentMethod.countSeoul();
	}
}
