// 속성과 메소드 개념
package day_250325.method;

public class Savebox {
	int coins;
	
	public void deposit(int coin) {
		coins = coins + coin;
	}
	
	public void withdraw() {
		System.out.println("가지고 있는 모든 금액 : " + coins);
	}
}
