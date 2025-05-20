package searchweather;

import java.util.Scanner;

public class Manager {
	// 10년 객체 생성
	TenYear tenyear = new TenYear();

	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);

	// 사용자 메뉴 메소드
	public void manager() {
		while (true) {
			// 메인 메뉴 출력
			System.out.println("========== 메뉴 ==========");
			System.out.println("1. 날짜의 날씨 조회 | 2. 월별 정보 조회 | 3. 년도별 정보 조회 | 4. 종료");
			System.out.print("번호를 입력하세요: ");

			// 사용자의 입력을 받음
			String temp = scanner.nextLine();
			System.out.println();

			// 1번 입력 시 -> 특정 날짜의 날씨 조회
			if (temp.equals("1")) {
				tenyear.printYear();
				// 2번 입력 시 -> 특정 월의 정보 조회
			} else if (temp.equals("2")) {
				tenyear.printMonthInfo();
				// 3번 입력 시 -> 특정 년도의 정보 조회
			} else if (temp.equals("3")) {
				tenyear.printYearInfo();
				// 4번 입력 시 -> 시스템 종료
			} else if (temp.equals("4")) {
				System.out.println("시스템을 종료합니다. 감사합니다!");
				return;

				// 잘못된 입력 시 오류 메시지 출력
			} else {
				System.out.println("잘못된 입력입니다. 올바른 메뉴 번호로 입력해주세요🙏");
				System.out.println();
			}
		}
	}
}
