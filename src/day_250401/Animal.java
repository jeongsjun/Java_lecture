package day_250401;

import java.util.Scanner;

public class Animal {
	String animalName;
	
	// 1. 이름 입력 메소드 생성
	public void inputName() {
		/* 함수 정의 : 동물의 이름을 입력받고 리턴하는 메소드
		 * 입력 파라미터 : 
		 * 출력 결과 : name -> String
		 * 
		 */
		System.out.print("동물의 이름 입력 : ");
		Scanner s = new Scanner(System.in);
		
		this.animalName = s.nextLine();
		System.out.println(animalName);
	}
	
	// 2. 동물의 이름을 검사해 울음소리를 출력하는 메소드 생성
	public void outputHowling() {
//		/* 함수 정의 : 동물의 이름을 검사해 울음소리를 출력하는 메소드
//		 * 입력 파라미터 : name -> String
//		 * 출력 결과 : 
//		 */
//		String[] animalName = {"강아지", "고양이", "병아리"};
//		String[] animalSound = {"멍멍", "야옹", "삐약"};
//		
//		for (int i = 0; i < animalName.length; i++) {
//			if (animalName[i].equals(this.animalName)) {
//				System.out.println(animalSound[i]);
//			}
//		}
		
		Item[] animal= {new Item("강아지", "멍멍")
				, new Item("고양이", "야옹")
				, new Item("병아리", "삐약")
				, new Item("참새", "짹짹")};
		
		for (int i = 0; i < animal.length; i++) {
			if(animal[i].name.equals(this.animalName)) {
				System.out.println(animal[i].sound);
			}
		}
	}
}
