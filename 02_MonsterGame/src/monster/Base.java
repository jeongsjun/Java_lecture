package monster;

// 몬스터의 기본 클래스
public abstract class Base {
	// 이름
	public String name; 
	
	// 점수
	public int score;
	
	// 공격력 수치
	public int attack;
	
	// 잡힌 마리 수
	public int count = 0;
	
	// 몬스터 발견 확률
	public int findRate;
	
	// 몬스터 잡을 확률
	public int catchRate;
	
	// 기본 생성자
	public Base() {
		this.name = "기본";
	}
	
	// 매개변수를 받는 생성자 - 이름, 점수, 공격력을 초기화
	public Base(String name, int score, int attack, int findRate, int catchRate) {
		this.name = name;
		this.score = score;
		this.attack = attack;
		this.findRate = findRate;
		this.catchRate = catchRate;
	}
	
	// 몬스터를 잡는 메소드 - 현재는 무조건 true를 반환 (기본 동작)
	public abstract boolean catchMonster();
}
