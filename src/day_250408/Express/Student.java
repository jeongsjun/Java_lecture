// 학생 클래스의 속성과 입력 메소드 생성
package day_250408.Express;

import java.util.Scanner;

public class Student {
	String name;
	String gender;
	String address;
	
	public void inputStudent() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생의 이름 : ");
		String temp = scanner.nextLine();
		this.name = temp;
		
		System.out.print("학생의 성별 : ");
		temp = scanner.nextLine();
		this.gender = temp;
		
		System.out.print("학생의 주소 : ");
		temp = scanner.nextLine();
		this.address = temp;
	}
}
