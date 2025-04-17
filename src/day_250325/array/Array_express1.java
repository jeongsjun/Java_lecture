// 학생의 점수를 랜덤으로 발생시켜 넣어주고 각각의 점수, 총합, 평균 출력
package day_250325.array;

import java.util.Random;
import java.util.Scanner;

public class Array_express1 {
	public static void main(String[] args) {
		// 1. 랜덤 객체, 입력 객체 생성
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		// 2. 학생 배열, 점수 배열 생성
		String[] nameArray = {"홍길동", "고길동", "둘리","또치","도우너","희동이","하니","강감찬","나예리"};
		int[] scoreArray = new int[nameArray.length];
		
		// 3. 점수 배열 랜덤 생성
//		for (int i = 0; i < scoreArray.length; i++) {
//			scoreArray[i] = r.nextInt(101);
//		}
		
		// 3. 사용자로부터 점수 입력 받기
		for (int i = 0; i < scoreArray.length; i++) {
			System.out.print("" + nameArray[i] + " 학생의 점수 입력: " );
			scoreArray[i] = s.nextInt();
		}
		
		System.out.println();
		
		// 4. 각각의 점수 출력
		for (int i = 0; i < nameArray.length; i++) {
			System.out.println("" + nameArray[i] + " 학생의 점수 : " + scoreArray[i]);
		}
		
		// 5. 전체 학생의 총합 계산 및 출력
		int sum = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			sum += scoreArray[i];
		}
		System.out.println();
		System.out.println("전체 학생의 총합 : " + sum);
		
		// 6. 전체 학생의 평균 계산 및 출력
		System.out.println();
		double avg = sum / (double) scoreArray.length;
		System.out.println("전체 학생의 평균 : " + String.format("%.2f", avg));
	}
}
