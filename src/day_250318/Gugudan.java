// 구구단
package day_250318;

public class Gugudan {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int  j = 1; j <=9; j++) {
				System.out.println("" + i + " x " + j + " = "+ (i*j));
			}
			System.out.println();
		}
	}
}
