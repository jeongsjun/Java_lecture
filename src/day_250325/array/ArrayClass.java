// 배열 개념
package day_250325.array;

import java.util.Random;

public class ArrayClass {
	public static void main(String[] args) {
		int[] a = new int[10];
		
//		a[0] = 1;
//		a[1] = 3;
//		a[2] = 9;
//		int total = a[0] + a[1] + a[2];
		
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			a[i] = r.nextInt(10000);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("a[" + i + "]의 값: " + a[i]);
		}
		
		int total = 0;
		for (int i = 0; i < 10; i++) {
			total += a[i];
		}
		
		System.out.println("총합 : " + total);
	}
}
