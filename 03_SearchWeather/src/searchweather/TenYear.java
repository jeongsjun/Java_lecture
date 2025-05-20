package searchweather;

import java.util.Random;
import java.util.Scanner;

public class TenYear {
	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);

	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();

	// 10년에 대한 객체 배열 생성
	Year[] year = new Year[10];

	// 시작 년도 선언
	int referenceYear = 2011;

	// 생성자
	TenYear() {
		// 시작년도(2011년)부터 10년 동안의 객체 생성
		for (int i = 0; i < year.length; i++) {
			year[i] = new Year(referenceYear);

			year[i].calcYearAvgTemp();
			year[i].calcYearMaxTemp();
			year[i].calcYearMinTemp();
			year[i].calcYearWeat();

			referenceYear++;
		}
	}

	// 특정 년도를 입력하여 해당 연도의 printMonth() 메소드를 실행하는 메소드
	public void printYear() {
		// 년도 입력
		System.out.print("조회할 년도을 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);

		System.out.println();

		// 2011~2020년 중에 입력한 년도를 찾았다면 -> 입력한 년도의 printMonth() 메소드 실행 후 종료
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				year[i].printMonth();

				return;
			}
		}

		// 찾지 못했다면 입력한 년도가 잘못된 년도라는 멘트 출력
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}

	// 특정 년도를 입력하여 해당 년도의 정보를 출력해주는 메소드
	public void printYearInfo() {
		// 년도 입력
		System.out.print("조회할 년도을 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);
		System.out.println();

		// 2011~2020년 중에 입력한 년도를 찾았다면 -> 입력한 년도의 평균 온도, 최대 온도, 최저 온도, 기상 상태 카운트 출력
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				System.out.println("==== " + year[i].year + "년의 정보 ====");
				System.out.println("평균 온도 : " + year[i].avgTemp);
				System.out.println("최대 온도 : " + year[i].maxTemp);
				System.out.println("최저 온도 : " + year[i].minTemp);
				System.out.println("맑은날 : " + year[i].clearCnt + "(일), 흐린날 : " + year[i].cloudCnt + "(일), 비온날 : "
						+ year[i].rainCnt);
				return;
			}
		}

		// 찾지 못했다면 입력한 년도가 잘못된 년도라는 멘트 출력
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}

	// 특정 년도를 입력하여 해당 년도의 월을 조회하는 메소드
	public void printMonthInfo() {
		// 년도 입력
		System.out.print("조회할 년도을 입력해주세요 : ");

		String temp = scanner.nextLine();
		int selectYear = Integer.parseInt(temp);
		System.out.println();

		// 2011~2020년 중에 입력한 년도를 찾았다면 -> 해당 년도의 printMonthInfo() 메소드 실행
		for (int i = 0; i < year.length; i++) {
			if (selectYear == year[i].year) {
				year[i].printMonthInfo();
				return;
			}
		}

		// 찾지 못했다면 입력한 년도가 잘못된 년도라는 멘트 출력
		System.out.println("해당 년도는 잘못된 년도입니다. 다시 입력해주세요");
	}
}
