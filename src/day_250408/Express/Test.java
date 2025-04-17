package day_250408.Express;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		/* 주사위(6면체) 숫자를 랜덤하게 발생시켜서
		주사위 1이 나오면 “멍멍”
		주사위 2가 나오면 “야옹”
		주사위 3이 나오면 “3”
		주사위 4가 나오면 “4”
		주사위 5가 나오면 “5”
		주사위 6이 나오면 “6” 을 출력하는 프로그램을 만드시오. */
		// 1. 랜덤 난수 생성
		Random r = new Random();
		int randNumber = r.nextInt(6) + 1; // 0~5
		System.out.println("주사위 눈은 " + randNumber);
		
		// 2. 조건 및 출력
		// if문 방식
		if (randNumber == 1) {
			System.out.println("멍멍");
		} else if (randNumber == 2) {
			System.out.println("야옹");
		} else if (randNumber == 3) {
			System.out.println("3");
		} else if (randNumber == 4) {
			System.out.println("4");
		} else if (randNumber == 5) {
			System.out.println("5");
		} else if (randNumber == 6) {
			System.out.println("6");
		}
		
		// switch문 방식
		switch(randNumber) {
		case 1:
			System.out.println("멍멍");
			break;
		case 2:
			System.out.println("야옹");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		case 5:
			System.out.println("5");
			break;
		case 6:
			System.out.println("6");
			break;
		}
	}
}
