package day_250401.Class;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceMethod {
	// 1. 랜덤, 입력, 주사위 객체 생성
	Dice dice = new Dice();
	
	// 2. 승패 결과를 담을 배열, 사용자 승리 수, 컴퓨터 승리 수, 게임 수 변수 생성
	ArrayList<String> historyArray = new ArrayList<>();
	int userWin = 0;
	int comWin = 0;
	int gameCount = 1;
	
	// 3. 컴퓨터 주사위 굴리는 메소드 생성
	public void rollComDice() {
		Random r = new Random();
		dice.comDice = r.nextInt(6) + 1;
	}
	
	// 4. 사용자 주사위 굴리는 메소드 생성
	public void rollUserDice() {
		Random r = new Random();
		dice.userDice = r.nextInt(6) + 1;
	}
	
	// 5. 게임 결과 이력 출력 메소드 생성
	public void printHistory() {
		System.out.println();
		System.out.println("** 승패 이력 **");
		

		for (int i = 0; i < this.historyArray.size(); i++) {
			System.out.println(this.historyArray.get(i));
		}
		System.out.println();
	}
	
	// 6. 게임 매니저 출력 메소드 생성
	public void gameManager() {
		if (dice.userDice > dice.comDice) {
			// 1. 게임 결과 출력
			System.out.println("게임 결과 : 사용자 승리");
			System.out.println();

			userWin++;

			System.out.println("** 현재 승률 **");
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
			
			this.historyArray.add(gameCount + "게임 사용자 승");
			System.out.println();
			
		} else if (dice.userDice < dice.comDice) {
			System.out.println("게임 결과 : 컴퓨터 승리");
			System.out.println();
			
			comWin++;
			
			System.out.println("** 현재 승률 **");
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
			
			this.historyArray.add(gameCount + "게임 컴퓨터 승");
			System.out.println();
			
		} else {
			System.out.println("게임 결과 : 무승부");
			System.out.println();
			
			System.out.println("** 현재 승률 **");
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
			

			this.historyArray.add(gameCount + "게임 무승부");
			System.out.println();
		}
	}
	
	// 6. 게임 결과 처리 메소드 생성
	public void gameResult() {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("" + gameCount + " 번째 게임");
			System.out.print("주사위를 굴리시겠습니까?(y/n) 승패 이력 출력(p) : ");
			String input = s.nextLine();

			if (input.equals("y")) {
				this.rollComDice();
				this.rollUserDice();

				System.out.println();
				System.out.println("사용자 주사위의 눈 : " + dice.userDice);
				System.out.println("컴퓨터 주사위의 눈 : " + dice.comDice);
				System.out.println();

				gameManager();
				gameCount++;
			} else if (input.equals("n")){

				System.out.println("게임을 종료합니다.");
				gameCount--;

				break;
				
				
			} else if (input.equals("p")) {
				printHistory();
			} else {
				System.out.println("잘못된 입력입니다. 올바른 입력을 해주세요.");
				System.out.println();
				
				continue;
			}
		}
		System.out.println("최종 승률");
		if (gameCount == 0) {
			System.out.println("사용자 : 0%, 컴퓨터 : 0%");
			
		} else {
			System.out.println("사용자 : " + String.format("%.1f", (double)userWin / gameCount * 100) + "%, 컴퓨터 : " + String.format("%.1f", (double)comWin / gameCount * 100) + "%");
		}
	}
}
