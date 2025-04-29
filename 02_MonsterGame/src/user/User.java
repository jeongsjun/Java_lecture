package user;

import monsterGame.Config;

//게임 사용자(플레이어)를 표현하는 클래스
public class User {
	// 사용자 이름
	public String userName; 
	
	// 체력 (기본값 100)
	public int hp = Config.MAX_HP;
	
	// 사용자 점수 (기본값 0)
	public int score = 0;
	
	// 사용자의 회피 확률 (기본값 10)
	public int avoidanceRate = 10;
	
	// 기본 생성자 - 사용자 이름을 "사용자"로 설정
	public User() {
		this.userName = "사용자";
	}
	
	// 사용자 이름을 지정해서 생성하는 생성자
	public User(String userName) {
		this.userName = userName;
	}
}
