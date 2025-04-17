// 카우프 지수를 이용해 사용자에게 체중과 신장을 입력받고 카우프지수 결과를 출력하세요
package day_250325.method;

public class Cauff {
	public static void main(String[] args) {
		// 1. 카우프 클래스 생성
		CauffMethod cauff = new CauffMethod();
		
		// 2. 신장과 체중 변수 생성
		double height, weight;
		
		// 3. 신장과 체중 사용자에게 입력받음
		height = cauff.inputHeight();
		weight = cauff.inputWeight();
		
		// 4. 카우프지수 메소드를 이용하여 카우프지수 계산
		int outputCauff = cauff.calculateCauff(height, weight);
		
		// 5. 카우프지수를 조건에 맞게 비교하여 출력
		if (outputCauff > 30) {
			System.out.println("비만");
		} else if (outputCauff > 24 && outputCauff <= 29) {
			System.out.println("과체중");
		} else if (outputCauff > 20 && outputCauff <= 24) {
			System.out.println("정상");
		} else if (outputCauff > 15 && outputCauff <= 20) {
			System.out.println("저체중");
		} else if (outputCauff > 13 && outputCauff <= 15) {
			System.out.println("여윔");
		} else if (outputCauff > 10 && outputCauff <= 13) {
			System.out.println("영양 실조증");
		} else if (outputCauff <= 10) {
			System.out.println("소모증");
		}
	}
}