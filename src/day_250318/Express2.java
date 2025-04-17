package day_250318;

public class Express2 {
	public static void main(String[] args) {
		// 0부터 100까지 숫자 중 짝수만 출력하세요.
		
		// 1. 0부터 100까지 반복 및 조건 처리
		for (int i = 0; i <= 100; i++) {
			// 조건 : 2로 나눈 나머지가 0이면 출력
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}