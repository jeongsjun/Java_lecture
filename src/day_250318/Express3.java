package day_250318;

public class Express3 {
	public static void main(String[] args) {
		/* 다음 출력
		 *
		 **
		 ***
		 ****
		 *****
		 ******
		 *******
		 */
		
//		// 1. 반복문 생성
//		for (int i = 7; i > 0; i--) {
//			for (int j = i; j < 8; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}