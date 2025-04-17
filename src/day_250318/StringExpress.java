package day_250318;

import java.util.Scanner;

public class StringExpress {
	public static void main(String[] args) {
		// Q. 사용자로부터 동물 이름을 입력 받으면 해당 동물의 울음소리를 출력하는 프로그램을 만드세요.
		
		// 1. 입력 객체 생성
		Scanner s = new Scanner(System.in);
		
		// 2. 동물 이름 변수 생성
		System.out.print("동물의 이름 입력 : ");
		String animalName = s.nextLine();
		
		// 3. 조건에 맞게 처리
		// if문 방식
		if (animalName.equals("강아지")) {
			System.out.println("멍멍!");
		} else if (animalName.equals("고양이")) {
			System.out.println("야옹~");
		} else if (animalName.equals("소")) {
			System.out.println("음메~");
		} else if (animalName.equals("말")) {
			System.out.println("히히히힝~");
		} else if (animalName.equals("닭")) {
			System.out.println("꼬끼오!~");
		} else if (animalName.equals("병아리")) {
			System.out.println("삐약삐약!");
		} else if (animalName.equals("쥐")) {
			System.out.println("찍찍!");
		} else {
			System.out.println("아직 알 수 없는 동물입니다.");
		}
		
		// switch문 방식
		switch (animalName) {
		case "강아지":
			System.out.println("멍멍!");
			break;
		case "고양이":
			System.out.println("야옹~");
			break;
		// 로직은 똑같음
		// ```
		}
	}
}