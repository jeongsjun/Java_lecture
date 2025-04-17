package day_250401.Class;

public class MainClass {
	public static void main(String[] args) {
		/* 총 10명의 학생 데이터를 입력 받아서
		 * 각 과목별 점수 총합, 평균을 출력하세요
		 */
		StudentMethod st = new StudentMethod();
		
		st.inputStudent();
		System.out.println();
		st.outputSum();
		System.out.println();
		st.outputAvg();
	}
}