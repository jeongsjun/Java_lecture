/*
사용자에게 9개의 숫자를 입력받아서 3*3의 이중 배열에 넣은 후 각행의 덧셈 합을
출력하시오.
조건1) 출력 시 4*4의 형식으로 출력 (4행째는 덧셈 합)
조건2) 데이터 출력시 정렬된 형식으로 출력
*/
package day_250325.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_express4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[][] inputArr = new int [3][3];
		int[][] outputArr = new int [4][4];
		int sumCol = 0;
		int sumRow = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("" + (i+1) + "행" + (j+1) + "열 번째 입력 : ");
				inputArr[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < 4; i++) {
			sumRow = 0;
			sumCol = 0;
			if (i == 3) {
				break;
			}
			for (int j = 0; j < 4; j++) {
				if (j == 3) {
					outputArr[i][j] = sumRow;
					outputArr[j][i] = sumCol;
					outputArr[j][j] += (sumRow + sumCol);
					break;
				} else {
					outputArr[i][j] = inputArr[i][j];
					sumRow += inputArr[i][j];
					sumCol += inputArr[j][i];
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			Arrays.sort(outputArr[i]);
		}
		
		System.out.println();
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(outputArr[i]));
		}
		
		
	}
}
