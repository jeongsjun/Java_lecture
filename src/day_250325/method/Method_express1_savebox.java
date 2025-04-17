package day_250325.method;

public class Method_express1_savebox {
	int coins;
	String name;
	int searchCoin = 1;
	
	public void inputCoin(int coin) {
		if (searchCoin == 0) {
			System.out.println();
			System.out.println("이미 저금한 금액을 모두 출금했습니다.");
			System.out.println("** 출금한 금액 **");
			System.out.println("" + coins + "원");
			return;
		}
		coins += coin;
		System.out.println("** 현재 저금된 금액 **");
		System.out.println("" + coins + "원");
		System.out.println();
	}
	
	public int outputCoin() {
		System.out.println();
		System.out.println("저금한 금액을 모두 출금합니다.");
		System.out.println();
		searchCoin = 0;
		return coins;
	}
	
	public String writeName(String saveboxName) {
		System.out.println("저금통의 이름을 " + saveboxName +"로 설정합니다.");
		name = saveboxName;
		return saveboxName;
	}
}
