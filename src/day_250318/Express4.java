package day_250318;

public class Express4 {
	public static void main(String[] args) {
		/*
		 * 999999999
		 * 	88888888
		 *   7777777
		 *    666666
		 *     55555
		 *      4444
		 *       333
		 *        22
		 *         1
		 */
		
//		// 1. 반복문 생성
//		for (int i = 9; i > 0; i--) {
//			for (int j = i; j < 9; j++) {
//				System.out.print(" ");
//			}
//			for (int j = i; j > 0; j--) {
//				System.out.print(i);
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i <= 10; i++) {
			if (i == 3) {
				return;
			}
			
			if (i == 1) {
				break;
			}
		}
		
		System.out.println("stop");
	}
}