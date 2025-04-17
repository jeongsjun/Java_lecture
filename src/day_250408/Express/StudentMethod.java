// 학생 메소드 생성
package day_250408.Express;

public class StudentMethod {
	Student[] student = new Student[10];
	
	// 입력 메소드
	public void inputData() {
		for (int i = 0; i < student.length; i++) {
			student[i] = new Student();
			System.out.println((i+1)+"번째 학생 정보");
			student[i].inputStudent();
			System.out.println();
		}
	}
	
	// 성별을 세는 메소드
	public void countGender() {
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i].gender.equals("남")) {
				count += 1;
			}
		}
		
		double countMan = (double) count / student.length;
		double countWoman = 1 - countMan;
		
		int ratioMan = (int) (countMan * 100);
		int ratioWoman = (int) (countWoman * 100);
		
		System.out.println("** 남녀 성비 **");
		System.out.println("남자 : " + ratioMan + "%, 여자 : " + ratioWoman + "%");
	}
	
	// 서울에 사는 학생의 명단을 출력하는 메소드
	public void countSeoul() {
		System.out.println("** 서울에 사는 학생 명단 **");
		for (int i = 0; i < student.length; i++) {
			if(student[i].address.equals("서울")) {
				System.out.println(student[i].name);
			}
		}
	}
}
