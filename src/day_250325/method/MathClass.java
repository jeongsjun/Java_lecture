// 메소드 개념
package day_250325.method;

public class MathClass {
	public int sumNumbers(int startNumber, int endNumber) {
		int total = 0;
		for (int i = startNumber; i <= endNumber; i++) {
			total += i;
		}
		return total;
	}
}
