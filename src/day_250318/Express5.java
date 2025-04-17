package day_250318;

import java.util.Random;
import java.util.Scanner;

public class Express5 {
	public static void main(String[] args) {
		/* 1. 한게임
		 * 사용자가 가위 바위 보
		 * 컴퓨터가 가위 바위 보 중 하나
		 * 누가 이겼음(비겼음) 출력
		 * 
		 * 2. 게임을 여러번 할 수 있게
		 */
		
		// 1. 랜덤 객체, 입력 객체 생성
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		// 승리 횟수 변수
		int userWin = 0;
		int comWin = 0;
		
		// 한게임
//		// 2. 사용자 선택 변수와 컴퓨터 선택 변수 생성
//		System.out.print("가위바위보 중 하나를 입력해주세요 (가위 : 0, 바위 : 1, 보 : 2, 종료 : 10) : ");
//		int userPick = s.nextInt();
//		
//		int comPick = r.nextInt(3);
//		
//		// 3. 사용자의 선택이 어떤 것인지 출력
//		if (userPick == 0) {
//			System.out.println("당신의 선택은 가위입니다.");
//		} else if (userPick == 1) {
//			System.out.println("당신의 선택은 바위입니다.");
//		} else if (userPick == 2) {
//			System.out.println("당신의 선택은 보입니다.");
//		} else {
//			System.out.println("올바른 선택을 입력해주세요.");
//			return;
//		}
//		
//		// 4. 컴퓨터의 선택이 어떤 것인지 출력
//		if (comPick == 0) {
//			System.out.println("컴퓨터의 선택은 가위입니다.");
//		} else if (comPick == 1) {
//			System.out.println("컴퓨터의 선택은 바위입니다.");
//		} else {
//			System.out.println("컴퓨터의 선택은 보입니다.");
//		}
//		
//		// 5. 사용자와 컴퓨터의 선택을 비교해 결과를 출력
//		if (userPick == 0) {
//			if (comPick == 0) {
//				System.out.println("비겼음");
//			} else if (comPick == 1) {
//				System.out.println("졌음");
//			} else {
//				System.out.println("이겼음");
//			}
//		} else if (userPick == 1) {
//			if (comPick == 0) {
//				System.out.println("이겼음");
//			} else if (comPick == 1) {
//				System.out.println("비겼음");
//			} else {
//				System.out.println("졌음");
//			}
//		} else {
//			if (comPick == 0) {
//				System.out.println("졌음");
//			} else if (comPick == 1) {
//				System.out.println("이겼음");
//			} else {
//				System.out.println("비겼음");
//			}
//		}
//			
//		if (userPick != comPick) {
//	         if ((userPick == 0 && comPick == 2) || (userPick == 1 && comPick == 0) || (userPick == 2 && comPick == 1)) {
//	            System.out.println("이겼습니다. " + userPick + ", " + comPick);
//	         } else {
//	            System.out.println("졌습니다. " + userPick + ", " + comPick);
//	         }
//	      } else {
//	         System.out.println("비겼습니다. " + userPick + ", " + comPick);
//	      }
					
		// 무한 게임
		while(true) {
			// 2. 사용자 선택 변수와 컴퓨터 선택 변수 생성
			System.out.print("가위바위보 중 하나를 입력해주세요 (가위 : 0, 바위 : 1, 보 : 2, 종료 : 10) : ");
			int userPick = s.nextInt();
			int comPick = r.nextInt(3);
			
			
			// 3. 사용자의 선택이 어떤 것인지 출력
			if (userPick == 0) {
				System.out.println("당신의 선택은 가위입니다.");
			} else if (userPick == 1) {
				System.out.println("당신의 선택은 바위입니다.");
			} else if (userPick == 2) {
				System.out.println("당신의 선택은 보입니다.");
			} else if (userPick == 10){
				System.out.println("게임을 종료합니다.");
				System.out.println();
				System.out.println();
				break;
			} else {
				System.out.println("올바른 선택을 입력해주세요.");
				System.out.println();
				continue;
			}
			
			// 4. 컴퓨터의 선택이 어떤 것인지 출력
			if (comPick == 0) {
				System.out.println("컴퓨터의 선택은 가위입니다.");
			} else if (comPick == 1) {
				System.out.println("컴퓨터의 선택은 바위입니다.");
			} else {
				System.out.println("컴퓨터의 선택은 보입니다.");
			}
			
			// 5. 사용자와 컴퓨터의 선택을 비교해 결과를 출력
			if (userPick == 0) {
				if (comPick == 0) {
					System.out.println("비겼음");
				} else if (comPick == 1) {
					System.out.println("졌음");
					comWin++;
				} else {
					System.out.println("이겼음");
					userWin++;
				}
			} else if (userPick == 1) {
				if (comPick == 0) {
					System.out.println("이겼음");
					userWin++;
				} else if (comPick == 1) {
					System.out.println("비겼음");
				} else {
					System.out.println("졌음");
					comWin++;
				}
			} else {
				if (comPick == 0) {
					System.out.println("졌음");
					comWin++;
				} else if (comPick == 1) {
					System.out.println("이겼음");
					userWin++;
				} else {
					System.out.println("비겼음");
				}
			}
			System.out.println();
		}
		System.out.println("전적 출력");
		System.out.println("사용자 : " + userWin + "승, 컴퓨터 : " + comWin + "승"  );
	}
}
