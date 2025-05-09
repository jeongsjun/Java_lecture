package searchweather;

import java.util.Random;
import java.util.Scanner;

public class Year {
	int year;
	
	// 년도의 평균 온도
	double avgTemp;
	
	// 최대 온도
	int maxTemp;
	
	// 최저 온도
	int minTemp;
	
	// 기상 상태 카운트
	int clearCnt = 0;
	int cloudCnt = 0;
	int rainCnt = 0;
		
	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);
		
	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();
	
	Month[] month = new Month[12];
	
	Year(int year) {
		this.year = year;
		
		for (int i = 0; i < month.length; i++) {
			month[i] = new Month(i + 1);
			
			month[i].calcMonthAvgTemp();
			month[i].calcMonthMaxTemp();
			month[i].calcMonthMinTemp();
			month[i].calcMonthWeat();
		}
	}
	
	public void printMonth() {
		System.out.print("조회할 월을 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectDay = Integer.parseInt(temp);
		
		System.out.println();
		
		for (int i = 0; i < month.length; i++) {
			if (selectDay == month[i].month) {
				month[i].printDay();
				
				return;
			}
		}
		
		System.out.println("해당 월는 잘못된 월입니다. 다시 입력해주세요");
	}
	
	public void printMonthInfo() {
		System.out.print("조회할 월을 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectMonth = Integer.parseInt(temp);
		
		System.out.println();
		
		for (int i = 0; i < month.length; i++) {
			if (selectMonth == month[i].month) {
				System.out.println("==== " + month[i].month + "월의 정보 ====");
				System.out.println("평균 온도 : " + month[i].avgTemp);
				System.out.println("최대 온도 : " + month[i].maxTemp);
				System.out.println("최저 온도 : " + month[i].minTemp);
				System.out.println("맑은날 : " + month[i].clearCnt + "(일), 흐린날 : " + month[i].cloudCnt + "(일), 비온날 : " + month[i].rainCnt);
				return;
			}
		}
		
		System.out.println("해당 월는 잘못된 월입니다. 다시 입력해주세요");
	}
	
	// 평균 온도 계산
	public void calcYearAvgTemp() {
		double sumTemp = 0.0;
		
		for (int i = 0; i < month.length; i++) {
			sumTemp += month[i].avgTemp;
		}
		
		this.avgTemp  = Math.round(((double) sumTemp / month.length) * 100) / 100.0;
	}
	
	// 최대 온도 계산
	public void calcYearMaxTemp() {
		// 최대 온도를 1월의 최대 온도로 초기화
		int maxTemp = month[0].maxTemp;
		
		for (int i = 0; i < month.length; i++) {
			if (month[i].maxTemp > maxTemp) {
				this.maxTemp = month[i].maxTemp;
			} 
		}
	}
	
	// 최소 온도 계산
	public void calcYearMinTemp() {
		// 최소 온도를 1월의 최소 온도로 초기화
		int minTemp = month[0].minTemp;
		
		for (int i = 0; i < month.length; i++) {
			if (month[i].minTemp < minTemp) {
				this.minTemp = month[i].minTemp;
			} 
		}
	}
	
	// 월별 기상 상태 출력 함수
	public void calcYearWeat() {
		for (int i = 0; i < month.length; i++) {
			this.clearCnt += month[i].clearCnt;
			this.cloudCnt += month[i].cloudCnt;
			this.rainCnt += month[i].rainCnt;
		}
	}
}
