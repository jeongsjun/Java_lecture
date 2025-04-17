package day_250325.array;

import java.util.Arrays;
import java.util.Random;

public class Array_express3 {
	public static void main(String[] args) {
		/* 0~100까지 임의의 수를 30개 발생시켜서 배열에 넣은 후 정렬하시오.
			조건1) 정렬 전/후의 값을 화면에 출력
			조건2) 소트 알고리즘 중 사용한 알고리즘을 설명한 레포트 (형식 무관, 내용만 제출) 첨부
			비고. 정렬 알고리즘 및 이중	 루프문에 대한 공부는 따로 하셔야 합니다. 
		 */
		
		Random r = new Random();
		int[] randomArray = new int[30];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = r.nextInt(101);
		}
		// 선택 정렬 배열
		int[] selectArray = Arrays.copyOf(randomArray, randomArray.length);
		
		// 버블 정렬 배열
		int[] bubbleArray = Arrays.copyOf(randomArray, randomArray.length);
		
		// 삽입 정렬 배열
		int[] insertArray = Arrays.copyOf(randomArray, randomArray.length);
		
		System.out.println("** 정렬 전 배열 **");
		System.out.println(Arrays.toString(randomArray));
		
		// 선택 정렬
		for (int i = 0; i < selectArray.length; i++) {
			int minNum = selectArray[i];
			for (int j = i+1; j < selectArray.length; j++) {
				if (selectArray[j] < minNum) {
					minNum = selectArray[j];
					selectArray[j] = selectArray[i];
					selectArray[i] = minNum;
				}
			}
		}
		
		// 버블 정렬
		for (int i = 0; i < bubbleArray.length; i++) {
			for (int j = 0; j < bubbleArray.length-i-1; j++) {
				if (bubbleArray[j] > bubbleArray[j+1]) {
					int changeNum = bubbleArray[j];
					bubbleArray[j] = bubbleArray[j+1];
					bubbleArray[j+1] = changeNum;
				}
			}
		}
		
		// 삽입 정렬
		for (int i = 1; i < insertArray.length; i++) {
			int key = insertArray[i]; 	
			int j = i - 1; 
			while (j >= 0 && insertArray[j] > key) {
				insertArray[j + 1] = insertArray[j];
				j--;
			}	
			insertArray[j + 1] = key;
		}

		
		System.out.println();
		System.out.println("** 정렬 후 배열(선택 정렬) **");
		System.out.println(Arrays.toString(selectArray));
		
		System.out.println();
		System.out.println("** 정렬 후 배열(삽입 정렬) **");
		System.out.println(Arrays.toString(insertArray));
		
		System.out.println();
		System.out.println("** 정렬 후 배열(버블 정렬) **");
		System.out.println(Arrays.toString(bubbleArray));
	}
}
