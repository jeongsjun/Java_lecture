package searchweather;

import java.util.Random;
import java.util.Scanner;

// 1년(12달)에 대한 클래스
public class Year {
	// 년
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

	// 12달에 대한 객체 배열 생성
	Month[] month = new Month[12];

	// 생성자
	Year(int year) {
		this.year = year;

		// 12달을 생성하며 각각의 평균 온도, 최대 온도, 최저 온도, 기상 상태 카운트 실행
		for (int i = 0; i < month.length; i++) {
			month[i] = new Month(i + 1);

			month[i].calcMonthAvgTemp();
			month[i].calcMonthMaxTemp();
			month[i].calcMonthMinTemp();
			month[i].calcMonthWeat();
		}
	}

	// 특정 월을 입력하여 해당 월의 printDay() 메소드를 실행하는 메소드
	public void printMonth() {
		// 월 입력
		System.out.print("조회할 월을 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectDay = Integer.parseInt(temp);

		System.out.println();

		// 12월 중에 입력한 월을 찾았다면 -> 입력한 월의 printDay() 메소드 실행 후 종료
		for (int i = 0; i < month.length; i++) {
			if (selectDay == month[i].month) {
				month[i].printDay();

				return;
			}
		}

		// 찾지 못했다면 입력한 월이 잘못된 월이라는 멘트 출력
		System.out.println("해당 월는 잘못된 월입니다. 다시 입력해주세요");
	}

	// 특정 월을 입력하여 해당 월의 정보를 출력해주는 메소드
	public void printMonthInfo() {
		// 월 입력
		System.out.print("조회할 월을 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectMonth = Integer.parseInt(temp);

		System.out.println();

		// 12월 중에 입력한 월을 찾았다면 -> 입력한 월의 평균 온도, 최대 온도, 최저 온도, 기상 상태 카운트 출력
		for (int i = 0; i < month.length; i++) {
			if (selectMonth == month[i].month) {
				System.out.println("==== " + month[i].month + "월의 정보 ====");
				System.out.println("평균 온도 : " + month[i].avgTemp);
				System.out.println("최대 온도 : " + month[i].maxTemp);
				System.out.println("최저 온도 : " + month[i].minTemp);
				System.out.println("맑은날 : " + month[i].clearCnt + "(일), 흐린날 : " + month[i].cloudCnt + "(일), 비온날 : "
						+ month[i].rainCnt);
				return;
			}
		}

		// 찾지 못했다면 입력한 월이 잘못된 월이라는 멘트 출력
		System.out.println("해당 월는 잘못된 월입니다. 다시 입력해주세요");
	}

	// 평균 온도 계산
	public void calcYearAvgTemp() {
		// 총 합계를 저장할 변수 선언
		double sumTemp = 0.0;

		// 12월의 길이만큼 반복해 합계 변수에 더하기
		for (int i = 0; i < month.length; i++) {
			sumTemp += month[i].avgTemp;
		}

		// 1년의 평균 계산
		this.avgTemp = Math.round(((double) sumTemp / month.length) * 100) / 100.0;
	}

	// 최대 온도 계산
	public void calcYearMaxTemp() {
		// 최대 온도를 1월의 최대 온도로 초기화
		int maxTemp = month[0].maxTemp;

		// 12월의 길이만큼 반복해 최대온도 계산
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

		// 12월의 길이만큼 반복해 최소 온도 계산
		for (int i = 0; i < month.length; i++) {
			if (month[i].minTemp < minTemp) {
				this.minTemp = month[i].minTemp;
			}
		}
	}

	// 월별 기상 상태 출력 함수
	public void calcYearWeat() {
		// 12월의 길이만큼 반복해 기상 상태 카운트
		for (int i = 0; i < month.length; i++) {
			this.clearCnt += month[i].clearCnt;
			this.cloudCnt += month[i].cloudCnt;
			this.rainCnt += month[i].rainCnt;
		}
	}
}
