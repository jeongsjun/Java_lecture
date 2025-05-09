package searchweather;

import java.util.Random;
import java.util.Scanner;

public class TenYear {
	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);
		
	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();
	
	Year[] year = new Year[10];
	
	int referenceYear = 2011;
	
	TenYear() {
		for (int i = 0; i < year.length; i++) {
			year[i] = new Year(referenceYear);
			
			year[i].calcYearAvgTemp();
			year[i].calcYearMaxTemp();
			year[i].calcYearMinTemp();
			year[i].calcYearWeat();
			
			referenceYear++;
		}
	}
	
	public void printYear() {
		System.out.print("조회할 년도을 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);
		
		System.out.println();
		
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				year[i].printMonth();
				
				return;
			}
		}
		
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}
	
	public void printYearInfo() {
		System.out.print("조회할 년도을 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);
		System.out.println();
		
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				System.out.println("==== " + year[i].year + "년의 정보 ====");
				System.out.println("평균 온도 : " + year[i].avgTemp);
				System.out.println("최대 온도 : " + year[i].maxTemp);
				System.out.println("최저 온도 : " + year[i].minTemp);
				System.out.println("맑은날 : " + year[i].clearCnt + "(일), 흐린날 : " + year[i].cloudCnt + "(일), 비온날 : " + year[i].rainCnt);
				return;
			}
		}
		
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}
	
	public void printMonthInfo() {
		System.out.print("조회할 년도을 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);
		System.out.println();
		
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				year[i].printMonthInfo();
				return;
			}
		}
		
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}
}
