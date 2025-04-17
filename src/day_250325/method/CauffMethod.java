// 카우프지수 메소드
package day_250325.method;

import java.util.Scanner;

public class CauffMethod {
	// 1. 입력 객체 생성
	Scanner s = new Scanner(System.in);
	
	// 2. 신장을 입력하고 리턴하는 메소드
	public double inputHeight() {
		System.out.print("신장 입력 (cm) : ");
		String inputHeight = s.nextLine();
		double height = Double.parseDouble(inputHeight);
		return height;
	}
	
	// 3. 체중을 입력하고 리턴하는 메소드
	public double inputWeight() {
		System.out.print("체중 입력 (kg) : ");
		String inputWeight = s.nextLine();
		double weight = Double.parseDouble(inputWeight);
		return weight;
	}
	
	// 4. 카우프 지수를 계산하여 리턴하는 메소드
	public int calculateCauff(double height, double weight) {
		int result = (int)Math.round(weight / Math.pow(height/100, 2));
		return result;
	}
}