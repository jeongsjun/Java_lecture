package day_250325.method;

import java.util.Scanner;

public class Method_express1 {
	public static void main(String[] args) {
		/* 저금통 다시 만들기
		 * 금액
		 * 입금, 출금 메소드
		 * (입금: 현재 저금된 금액 출력)
		 * (출금: 리턴 값으로 저금한 총 금액을 리턴)
		 * 
		 * +a
		 * 저금통 이름을 지정할 수 있게
		 * 출금 후에는 더이상 저금 못하게
		 * */
		
		// 1. 메소드 객체, 입력 객체 생성
		Method_express1_savebox testSavebox = new Method_express1_savebox();
		Scanner s = new Scanner(System.in);
		
		// 2. 저금통 이름 설정
		System.out.print("내 저금통 이름 : ");
		String mySaveboxName = s.nextLine();
		System.out.println("내 저금통의 이름은 : " + testSavebox.writeName(mySaveboxName));
		System.out.println();
		System.out.println();
		
		// 3. 입금
		testSavebox.inputCoin(1000);
		testSavebox.inputCoin(2000);
		
		// 4. 출금
		int outputCoin = testSavebox.outputCoin();
		
		// 5. 저금한 총 금액 출력
		System.out.println();
		System.out.println("** 저금한 총 금액 **");
		System.out.println("" + outputCoin + "원");
		System.out.println();
		
		// 6. 출금 후 저금
		testSavebox.inputCoin(10000);
	}
}
