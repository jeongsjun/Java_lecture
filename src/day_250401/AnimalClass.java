package day_250401;

import java.util.Random;
import java.util.Scanner;

public class AnimalClass {
	public static void main(String[] args) {
		// 1. 동물 객체, 문자열 배열 생성
		Animal a = new Animal();
		
		// 2.이름 입력
		a.inputName();

		// 3. 이름 검사 및 해당하는 이름의 출력문 출력
		a.outputHowling();
		
		Scanner scanner = new Scanner(System.in);
		
		scanner.next();
		
		Random random = new Random();
		
		random.doubles();
	}
}
