// 주사위 대결 게임 (승률 이력 출력)
package day_250325.array;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Array_express2 {
	public static void main(String[] args) {
		// 1. 랜덤 객체, 입력 객체, 승패 이력 배열 생성
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		ArrayList<String> historyArray = new ArrayList<>();
		
		// 2. 사용자 승리, 컴퓨터 승리, 게임 횟수 변수 생성
		int userWin = 0;
		int comWin = 0;
		int gameCount = 1;
		
		// 3. 무한 반복
		while(true) {
			// 3-1. 기본 조작 (게임 진행/종료/승패 이력 출력)
			System.out.println("" + gameCount + " 번째 게임");
			System.out.print("주사위를 굴리시겠습니까?(y/n) 승패 이력 출력(p) : ");
			String input = s.nextLine();
			
			// 조건1 : 게임 진행 시
			if (input.equals("y")) {
				// 1. 사용자, 컴퓨터 주사위 눈 생성
				int userDice = r.nextInt(6) + 1;
				int comDice = r.nextInt(6) + 1;
				
				// 2. 확률 조작
				int manipulRate = r.nextInt(2);
				if(manipulRate == 0) {
					comDice = 6;
				}
				
				// 3. 사용자, 컴퓨터 주사위 눈 출력
				System.out.println();
				System.out.println("사용자 주사위의 눈 : " + userDice);
				System.out.println("컴퓨터 주사위의 눈 : " + comDice);
				System.out.println();
				
				// 조건1 : 사용자가 승리했을 때
				if (userDice > comDice) {
					// 1. 게임 결과 출력
					System.out.println("게임 결과 : 사용자 승리");
					System.out.println();
					
					// 2. 사용자 승리 카운드 +1
					userWin++;
					
					// 3. 현재 승률 출력
					System.out.println("** 현재 승률 **");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
					
					// 4. 승패 이력 배열에 결과 입력
					historyArray.add(gameCount + "게임 사용자 승");
					System.out.println();
					
				// 조건2 : 컴퓨터가 승리했을 때
				} else if (userDice < comDice) {
					// 1. 게임 결과 출력
					System.out.println("게임 결과 : 컴퓨터 승리");
					System.out.println();
					
					// 2. 컴퓨터 승리 카운드 +1
					comWin++;
					
					// 3. 현재 승률 출력
					System.out.println("** 현재 승률 **");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
					
					// 4. 승패 이력 배열에 결과 입력
					historyArray.add(gameCount + "게임 컴퓨터 승");
					System.out.println();
					
				// 조건3 : 무승부일 때
				} else {
					// 1 게임 결과 출력
					System.out.println("게임 결과 : 무승부");
					System.out.println();
					
					// 2. 현재 승률 출력
					System.out.println("** 현재 승률 **");
					System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
					
					// 3. 승패 이력 배열에 결과 입력
					historyArray.add(gameCount + "게임 무승부");
					System.out.println();
				}
				gameCount++;
			// 조건 2: 게임 종료 시
			} else if (input.equals("n")){
				// 1. 게임 종료 안내 문구 출력
				System.out.println("게임을 종료합니다.");
				// 2. 무한 반복문 종료
				break;
				
				
			// 조건 3: 승패 이력 출력
			} else if (input.equals("p")) {
				// 1 승패 이력 문구 출력
				System.out.println();
				System.out.println("** 승패 이력 **");
				
				// 2 승패 이력 출력
				for (int i = 0; i < historyArray.size(); i++) {
					System.out.println(historyArray.get(i));
				}
				System.out.println();
				
			// 조건 4: 잘못된 입력일 때
			} else {
				// 1. 잘못된 입력이라는 문구 출력
				System.out.println("잘못된 입력입니다. 올바른 입력을 해주세요.");
				System.out.println();
				
				// 2. 다음 반복 실행
				continue;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		// 6. 최종 결과 출력
		System.out.println("** 최종 승률 **");
		// 조건 1: 게임을 한판도 진행하지 않았을 때
		if (gameCount == 0) {
			// 1. 승률 0%로 출력
			System.out.println("사용자 : 0%, 컴퓨터 : 0%");
		// 조건 2: 게임을 한판이라도 진행했다면
		} else {
			// 1. 최종 승률 출력
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
		}
	}
}
