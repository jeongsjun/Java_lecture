package searchweather;

import java.util.Random;
import java.util.Scanner;

public class Month {
	int month;
	
	// 월의 평균 온도
	double avgTemp;
	
	// 최대 온도
	int maxTemp = -10;
	
	// 최저 온도
	int minTemp = 30;
	
	// 기상 상태 카운트
	int clearCnt = 0;
	int cloudCnt = 0;
	int rainCnt = 0;
	
	Day[] day = new Day[30];
	
	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);
		
	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();
	
	// 각 날짜에 대한 정보 생성 함수
	public void makeDay(int referenceTemp) {
		for (int i = 0; i < day.length; i++) {
			day[i] = new Day();
			
			// 날짜 삽입
			day[i].date = i + 1;
			
			// 랜덤 온도 삽입
			int randTemper;
			
			if (referenceTemp == 0) {
				randTemper = random.nextInt(21) - 10; // -10 ~ 10
				day[i].temper = randTemper;
			}
			
			else if (referenceTemp == 10) {
				randTemper = random.nextInt(21); // 0 ~ 20
				day[i].temper = randTemper;
			}
			
			else if (referenceTemp == 20) {
				randTemper = random.nextInt(21) + 10; // 10 ~ 30
				day[i].temper = randTemper;
			}
			
			// 랜덤 기상 상태 삽입
			int randWeather = random.nextInt(100) + 1;
			
			if (randWeather <= 50) {
				day[i].weather = "맑음";
			}
			else if (randWeather <= 80) {
				day[i].weather = "흐림";
			}
			else {
				day[i].weather = "비";
			}
		}
	}
	
	// 월의 날짜 생성자
	Month(int month) {
		this.month = month;
		
		// 봄
		if (this.month == 3 || this.month == 4 || this.month == 5) {
			makeDay(10);
		}
		
		// 여름
		else if (this.month == 6 || this.month == 7 || this.month == 8) {
			makeDay(20);
		}
		
		// 가을
		else if (this.month == 9 || this.month == 10 || this.month == 11) {
			makeDay(10);
		}
		
		// 겨울
		else if (this.month == 12 || this.month == 1 || this.month == 2) {
			makeDay(0);
		}
		
	}
	
	// 날짜 조회
	public void printDay() {
		System.out.print("조회할 날짜를 입력해주세요 : ");
		
		String temp = scanner.nextLine();
		int selectDay = Integer.parseInt(temp);
		
		System.out.println();
		
		for (int i = 0; i < day.length; i++) {
			if (selectDay == day[i].date) {
				System.out.println("조회한 날짜 : " + day[i].date);
				System.out.println("조회한 날짜의 온도 : " + day[i].temper);
				System.out.println("조회한 날짜의 기상 상태 : " + day[i].weather);
				
				return;
			}
		}
		
		System.out.println("해당 날짜는 잘못된 날짜입니다. 다시 입력해주세요");
	}
	
	// 평균 온도 계산
	public void calcMonthAvgTemp() {
		int sumTemp = 0;
		
		for (int i = 0; i < day.length; i++) {
			sumTemp += day[i].temper;
		}
		
		this.avgTemp  = Math.round(((double) sumTemp / day.length) * 100) / 100.0;
	}
	
	// 최대 온도 계산
	public void calcMonthMaxTemp() {
		for (int i = 0; i < day.length; i++) {
			if (day[i].temper > this.maxTemp) {
				this.maxTemp = day[i].temper;
			} 
		}
	}
	
	// 최소 온도 계산
	public void calcMonthMinTemp() {
		for (int i = 0; i < day.length; i++) {
			if (day[i].temper < this.minTemp) {
				this.minTemp = day[i].temper;
			} 
		}
	}
	
	// 월별 기상 상태 출력 함수
	public void calcMonthWeat() {
		for (int i = 0; i < day.length; i++) {
			if (day[i].weather.equals("맑음")) {
				this.clearCnt++;
			} 
			else if (day[i].weather.equals("흐림")) {
				this.cloudCnt++;
			} 
			else if (day[i].weather.equals("비")) {
				this.rainCnt++;
			} 
		}
	}
}
