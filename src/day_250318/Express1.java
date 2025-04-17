package day_250318;

public class Express1 {
	public static void main(String[] args) {
		// 0부터 100까지의 총 합을 구하시오.
		
		// 1. 합계 변수 생성
		int sum = 0;
		
		// 2. 100번 반복하여 합 계산
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		
		// 3. 결과 출력
		System.out.println("0부터 100까지의 총 합은 " + sum );
		
		// 4. 평균 출력
		double avg = sum / (double) 10;
		System.out.println("평균 : " + avg);
		
		
		// 이중 반복문
		for (int i = 0; i < 10; i++) { // i 0~9
			for (int j = 0; j < 5; j++) { // j 0~4
				System.out.print(j);
			}
			System.out.println();
		}
	}
}