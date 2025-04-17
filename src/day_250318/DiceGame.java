package day_250318;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	public static void main(String[] args) {
		// 주사위 대결 게임
		
		// 1. 랜덤 객체, 입력 객체 생성
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		// 2. 사용자 승리, 컴퓨터 승리, 게임 횟수 변수 생성
		int userWin = 0;
		int comWin = 0;
		int gameCount = 1;
		
		// 무한 반복
		while(true) {
			// 3. 기본 조작 (게임 진행/종료)
			System.out.println("" + gameCount + " 번째 게임");
			System.out.print("주사위를 굴리시겠습니까?(y/n)");
			String input = s.nextLine();
			
			// 조건 : 게임 진행 시
			if (input.equals("y")) {
				// 4. 사용자, 컴퓨터 주사위 눈 생성
				int userDice = r.nextInt(6) + 1;
				int comDice = r.nextInt(6) + 1;
				
				// 확률 조작
				int manipulRate = r.nextInt(2);
				if(manipulRate == 0) {
					comDice = 6;
				}
				
				// 5. 사용자, 컴퓨터 주사위 눈 출력
				System.out.println("사용자 주사위의 눈 : " + userDice);
				System.out.println("컴퓨터 주사위의 눈 : " + comDice);
				System.out.println();
				
				// 조건 : 사용자가 승리했을 때
				if (userDice > comDice) {
					// 게임 결과 출력
					System.out.println("게임 결과 : 사용자 승리");
					System.out.println();
					userWin++;
					System.out.println("현재 승률");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");

					System.out.println();
					
				// 조건 : 컴퓨터가 승리했을 때
				} else if (userDice < comDice) {
					// 게임 결과 출력
					System.out.println("게임 결과 : 컴퓨터 승리");
					System.out.println();
					comWin++;
					System.out.println("현재 승률");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
					System.out.println();
					
				// 조건 : 무승부일 때
				} else {
					// 게임 결과 출력
					System.out.println("게임 결과 : 무승부");
					System.out.println();
					System.out.println("현재 승률");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
					System.out.println();
				}
				gameCount++;
			// 조건 : 게임 종료 시
			} else if (input.equals("n")){
				System.out.println("게임을 종료합니다.");
				gameCount--;
				break;
			// 조건 : 잘못된 입력일 때
			} else {
				System.out.println("잘못된 입력입니다. 올바른 입력을 해주세요.");
				System.out.println();
				continue;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 6. 최종 결과 출력
		System.out.println("최종 승률");
		// 조건 : 게임을 한판도 진행하지 않았을 때
		if (gameCount == 0) {
			System.out.println("사용자 : 0%, 컴퓨터 : 0%");
			
		} else {
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
		}
	}
}
