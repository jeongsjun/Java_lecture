package searchweather;

import java.util.Random;
import java.util.Scanner;

// 한달(30일)에 대한 클래스
public class Month {
	// 월
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

	// 30일에 대한 객체 배열 생성
	Day[] day = new Day[30];

	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);

	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();

	// 각 날짜에 대한 정보 생성 메소드
	public void makeDay(int referenceTemp) {
		for (int i = 0; i < day.length; i++) {
			// 하루 객체 생성
			day[i] = new Day();

			// 날짜 삽입
			day[i].date = i + 1;

			// 온도 삽입
			int randTemper;

			// 기준 온도에 맞춰 +-10의 온도 범위를 생성
			// 기준 온도가 0이라면 -> -10 ~ 10 사이의 랜덤 온도 생성
			if (referenceTemp == 0) {
				randTemper = random.nextInt(21) - 10; // -10 ~ 10
				day[i].temper = randTemper;
			}

			// 기준 온도가 10이라면 -> 0 ~ 20 사이의 랜덤 온도 생성
			else if (referenceTemp == 10) {
				randTemper = random.nextInt(21); // 0 ~ 20
				day[i].temper = randTemper;
			}

			// 기준 온도가 20이라면 -> 10 ~ 30 사이의 랜덤 온도 생성
			else if (referenceTemp == 20) {
				randTemper = random.nextInt(21) + 10; // 10 ~ 30
				day[i].temper = randTemper;
			}

			// 기상 상태 삽입
			int randWeather = random.nextInt(100) + 1;

			// 확률에 따라 기상 상태 삽입
			// 맑음(50%), 흐림(30%), 비(20%)
			if (randWeather <= 50) {
				day[i].weather = "맑음";
			} else if (randWeather <= 80) {
				day[i].weather = "흐림";
			} else {
				day[i].weather = "비";
			}
		}
	}

	// 계절별로 기준 온도에 맞춰 월 객체 생성
	Month(int month) {
		this.month = month;

		// 봄 (3~5)
		if (this.month == 3 || this.month == 4 || this.month == 5) {
			makeDay(10);
		}

		// 여름 (6~8)
		else if (this.month == 6 || this.month == 7 || this.month == 8) {
			makeDay(20);
		}

		// 가을 (9~11)
		else if (this.month == 9 || this.month == 10 || this.month == 11) {
			makeDay(10);
		}

		// 겨울 (12~2)
		else if (this.month == 12 || this.month == 1 || this.month == 2) {
			makeDay(0);
		}

	}

	// 특정 날짜를 입력하여 해당 날짜의 정보 출력 메소드
	public void printDay() {
		// 날짜 입력
		System.out.print("조회할 날짜를 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectDay = Integer.parseInt(temp);

		System.out.println();

		// 30일 중에 입력한 날짜를 찾았다면 -> 입력한 날짜의 정보 출력 후 메소드 종료
		for (int i = 0; i < day.length; i++) {
			if (selectDay == day[i].date) {
				System.out.println("조회한 날짜 : " + day[i].date);
				System.out.println("조회한 날짜의 온도 : " + day[i].temper);
				System.out.println("조회한 날짜의 기상 상태 : " + day[i].weather);

				return;
			}
		}

		// 찾지 못했다면 입력한 날짜가 잘못된 날짜라는 문구 출력
		System.out.println("해당 날짜는 잘못된 날짜입니다. 다시 입력해주세요");
	}

	// 평균 온도 계산 메소드
	public void calcMonthAvgTemp() {
		// 총 합계를 저장할 변수 선언
		int sumTemp = 0;

		// 한달(30일)의 길이만큼 반복해 합계 변수에 더하기
		for (int i = 0; i < day.length; i++) {
			sumTemp += day[i].temper;
		}

		// 한달의 평균 계산
		this.avgTemp = Math.round(((double) sumTemp / day.length) * 100) / 100.0;
	}

	// 최대 온도 계산 메소드
	public void calcMonthMaxTemp() {
		// 현재 한달의 최대 온도는 기본 최저 온도인 -10으로 선언되어 있으므로
		// 한달(30일)의 길이만큼 반복해 현재 최대 온도보다 높은 최대 온도가 있다면 값 삽입
		for (int i = 0; i < day.length; i++) {
			if (day[i].temper > this.maxTemp) {
				this.maxTemp = day[i].temper;
			}
		}
	}

	// 최소 온도 계산 메소드
	public void calcMonthMinTemp() {
		// 현재 한달의 최저 온도는 기본 최대 온도인 30으로 선언되어 있으므로
		// 한달(30일)의 길이만큼 반복해 현재 최저 온도보다 낮은 최저 온도가 있다면 값 삽입
		for (int i = 0; i < day.length; i++) {
			if (day[i].temper < this.minTemp) {
				this.minTemp = day[i].temper;
			}
		}
	}

	// 월별 기상 상태 계산 메소드
	public void calcMonthWeat() {
		// 한달(30일)의 길이만큼 반복해 '맑음', '흐림', '비'의 기상 상태 카운트
		for (int i = 0; i < day.length; i++) {
			if (day[i].weather.equals("맑음")) {
				this.clearCnt++;
			} else if (day[i].weather.equals("흐림")) {
				this.cloudCnt++;
			} else if (day[i].weather.equals("비")) {
				this.rainCnt++;
			}
		}
	}
}
