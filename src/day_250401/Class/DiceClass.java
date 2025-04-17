package day_250401.Class;

public class DiceClass {
	public static void main(String[] args) {
		/* 주사위 게임을 만드세요. 객체 형식으로
		 * 각 게임별로 객체를 만들면 되며
		 * 각 게임은 컴퓨터 주사위 굴리는 메소드
		 * 사용자 주사위 굴리는 메소드
		 * 게임 결과를 처리하는 메소드로 구성되며
		 * 각 게임 결과 이력을 조회할 수 있도록 구성되어야 합니다.
		 */
		
		DiceMethod diceMethod = new DiceMethod();
		
		diceMethod.gameResult();
	}
}
