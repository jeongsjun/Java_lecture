package monsterGame;

import java.util.Random;
import java.util.Scanner;

import monster.Base;
import monster.M1;
import monster.M2;
import monster.M3;
import monster.M4;
import monster.M5;
import user.User;

// 메소드를 정의한 클래스
public class MethodClass {
	// 사용자 입력을 위한 객체
	Scanner scanner = new Scanner(System.in);
	
	// 랜덤 숫자를 생성하기 위한 객체
	Random random = new Random();
	
	// 유저 정보를 저장할 배열
	User[] user = new User[Config.MUHAN_NUM];
	
	// 현재 생성된 유저 수
	int userCount = 0;
	
	// 체력 회복용 포션 개수 (최대 3개)
	int hpPotionCount = 3;
	
	// 몬스터 정보를 저장할 배열 (총 5종의 몬스터)
	Base[] monster = new Base[5];
	
	// 생성자: MethodClass 객체가 생성될 때 호출됨
	// 몬스터 배열에 각각의 몬스터 객체를 초기화하여 저장
    MethodClass() {
        monster[0] = new M1(); // 첫번째 몬스터 (은지)
        monster[1] = new M2(); // 두번째 몬스터 (성진)
        monster[2] = new M3(); // 세번째 몬스터 (주영)
        monster[3] = new M4(); // 네번째 몬스터 (승준)
        monster[4] = new M5(); // 다섯번째 몬스터 (영철)
    }
	
    /** 사용자의 닉네임 입력을 받는 메소드<br>
     * <br>
     * 닉네임이 중복되지 않으면 새로운 User 객체를 생성하고 user 배열에 저장<br>
     * 성공 시 true, 실패(중복) 시 false 반환<br>
     */ 
	public boolean createUser() {
		// 사용자에게 닉네임 입력 요청
		System.out.print("사용자의 닉네임을 입력해주세요 : ");
		
		// 입력받은 닉네임을 temp 변수에 저장
		String temp = scanner.nextLine();
		
		// 기존에 저장된 유저들 중에서 닉네임이 중복되는지 확인
		for(int i = 0; i < this.userCount; i++) {
			if(user[i].userName.equals(temp)) { // 닉네임이 중복될 경우
				System.out.println("이미 존재하는 닉네임입니다.");
				System.out.println();
				return false; // 중복된 닉네임이므로 유저 생성 실패
			}
		}
		
		// 중복이 없으면 새로운 User 객체 생성 후 배열에 저장
		user[userCount] = new User();
		user[userCount].userName = temp; // 입력한 닉네임 설정
		
		// 환영 메시지 출력
		System.out.println("반갑습니다! " + user[userCount].userName);
		
		return true; // 유저 생성 성공
	}
    
	/**
	 * 사용자가 지정된 번호의 몬스터와 조우하는 이벤트를 처리 메소드
	 * <p>
	 * 사용자에게 싸움 또는 도망 선택지를 제시하며,
	 * 싸움을 선택할 경우 몬스터를 잡거나 공격받게 되고,
	 * 도망을 선택하면 전투 없이 종료됩니다.
	 * 또한, 사용자는 일정 확률로 몬스터의 공격을 회피할 수 있습니다.
	 * 몬스터를 잡으면 점수를 획득하고, 실패 시 체력이 감소합니다.
	 * 잘못된 입력은 다시 선택하도록 유도합니다.
	 * </p>
	 *
	 * @param monsterNum 조우할 몬스터의 배열 인덱스 번호
	 */
    public void encounterMonster(int monsterNum) {
    	// 마주친 몬스터 이름 출력
		System.out.println(monster[monsterNum].name + "(을)를 마주쳤다!");
    	while(true) {
	    	// 선택지 출력 및 선택
			System.out.print("1. 싸운다 | 2. 도망간다 : ");
			String num = scanner.nextLine();
			  
			// 싸우기 선택
			if (num.equals("1")) {
				System.out.println("싸움을 선택하셨습니다");
				System.out.println();
				
				
				// 몬스터 잡음
				if (monster[monsterNum].catchMonster()) {
					monster[monsterNum].count++;
					
					// 점수 습득 멘트 출력 및 점수 증가
					System.out.println("축하합니다! " + monster[monsterNum].score + "점을 얻었습니다!");
					user[this.userCount].score += monster[monsterNum].score;
					
					break;
				
				// 몬스터 잡기 실패 및 몬스터 공격
				} else {
					// 공격 받음 및 체력 감소 멘트 출력
					System.out.println(monster[monsterNum].name + "(이)가 공격했다!");
					
					int avoidRandNum = random.nextInt(100);
					
					if (avoidRandNum < user[this.userCount].avoidanceRate) {
						System.out.println("빠른 스피드로 공격을 회피했습니다!");
						System.out.println("앗! " + monster[monsterNum].name + "(이)가 도망갔다...");
						
						break;
					}
					
					else {
						System.out.println("체력을 " + monster[monsterNum].attack + "만큼 잃었다...");
						
						// 사용자 체력을 몬스터의 공격력만큼 감소
						user[this.userCount].hp -= monster[monsterNum].attack;
						
						break;
					}
				}
			
			// 도망 선택
			} else if (num.equals("2")) {
				// 도망 멘트 출력
				System.out.println("도망을 선택하셨습니다.");
				
				break;

			// 잘못된 입력 처리
			} else {
				// 잘못된 입력 멘트 출력
				System.out.println("잘못된 입력입니다. 올바른 메뉴 번호로 입력해주세요🙏");
            	System.out.println();
			}
    	}
    }
	
	/**
	 * 플레이어가 몬스터를 마주치는 이벤트 메소드<br>
	 * <br>
	 * 이 메서드는 약 50% 확률로 몬스터를 조우하게 하며,
	 * 조우할 경우 5종류 중 하나의 몬스터가 무작위로 등장합니다.<br>
	 * <br>
	 * 각 몬스터는 고유한 이름, 점수, 공격력을 가지며,<br>
	 * 플레이어는 몬스터를 상대로 "싸운다" 또는 "도망간다" 중 하나를 선택할 수 있습니다.<br>
	 * <br>
	 * - 싸운다: 몬스터 포획 시 점수와 몬스터 이름이 인벤토리에 추가됨<br>
	 *           포획 실패 시 몬스터에게 공격받아 체력 손실<br>
	 * <br>
	 * - 도망간다: 아무 일도 일어나지 않고 이벤트 종료<br>
	 * <br>
	 * - 잘못된 선택: 선택지 외 입력 시, 몬스터가 도망가고 이벤트 종료<br>
	 * <br>
	 * 확률 분포:<br>
	 * - M1: 40% (0~39)<br>
	 * - M2: 30% (40~69)<br>
	 * - M3: 15% (70~84)<br>
	 * - M4: 10% (85~94)<br>
	 * - M5: 5% (95~99)<br>
	 * <br>
	 * 몬스터를 만나지 않을 경우 "아무 일도 일어나지 않았습니다." 출력 후 종료됩니다.<br>
	 */
	public void encounter() {
		// 0 ~ 99 사이의 난수 생성
        int chance = random.nextInt(100);
        
        // 50% 확률로 몬스터를 만남
		if (chance < 50) {
			System.out.println("몬스터를 마주쳤습니다!");
			
			// 0 ~ 99 사이의 난수 생성하여 몬스터 결정
			int randNumber = random.nextInt(100);
			
			// M1 (0~39, 40% 확률)
	    	if (randNumber < monster[0].findRate) {
	    		encounterMonster(0);
	    	} 
	    	
	    	// M2 (40~69, 30% 확률)
	    	else if (randNumber < monster[0].findRate + monster[1].findRate) {
	    		encounterMonster(1);
	    	} 
	    	
	    	// M3 (70~84, 15% 확률)
	    	else if (randNumber < monster[0].findRate + monster[1].findRate + monster[2].findRate) {
	    		encounterMonster(2);
	    	} 
	    	
	    	// M4 (85~94, 10% 확률)
	    	else if (randNumber < monster[0].findRate + monster[1].findRate + monster[2].findRate + monster[3].findRate) {
	    		encounterMonster(3);
	    	} 
	    	
	    	// M5 (95~99, 5% 확률)
	    	else { 
	    		encounterMonster(4);
	    	}
	    
    	// 몬스터를 만나지 않음
		} else {
			// 몬스터 만나지 않음 멘트 출력
			System.out.println("아무 일도 일어나지 않았습니다.");
		}
    }
	
	/**
	 * 플레이어가 요정을 만나는 특별 이벤트 메소드<br>
	 * <br>
	 * 이 메서드는 게임 진행 중 무작위 이벤트로 호출되며,
	 * 플레이어는 2종류 중 하나의 요정을 만나게 됩니다:<br>
	 * <br>
	 * - 천사 요정: 점수 +5<br>
	 * - 악마 요정: 점수 -5<br>
	 * <br>
	 * 요정의 종류는 50% 확률로 결정되며, 결과에 따라<br>
	 * 현재 플레이어(user[userCount])의 점수가 즉시 변경됩니다.<br>
	 */
	public void fairy() {
		// 특별 요정 출현 메세지 출력
		System.out.println("특별 요정을 만났습니다!");
		
		// 0 ~ 1 사이의 난수 생성
		int fairyType = random.nextInt(2);
		
		// 천사 요정 (50%)
		if (fairyType == 0) {
			// 사용자 점수 + 5
			user[userCount].score += 5;
			
			// 천사 요정 메세지 출력
			System.out.println("천사 요정이 나타났습니다! 점수 +5");
			
		// 악마 요정 (50%)
		} else {
			// 사용자 점수 - 5
			user[userCount].score -= 5;
			
			// 악마 요정 메세지 출력
			System.out.println("악마 요정이 나타났습니다! 점수 -5");
		}
	}
	
	/**
	 * 플레이어의 현재 점수를 출력해주는 이벤트 메소드
	 */
	public void printScore() {
		System.out.println("현재 점수 : " + user[userCount].score);
	}
	
	/**
	 * 플레이어의 현재 체력을 출력해주는 이벤트 메소드
	 */
	public void printHeart() {
		System.out.println("현재 체력 : " + user[userCount].hp);
	}
	
	/**
	 * 랜덤박스를 열었을 때의 이벤트를 처리하는 메서드<br>
	 * <br>
	 * 플레이어가 필드에서 랜덤박스를 발견했을 때 호출되며,
	 * 상자 안에서 세 가지 중 하나의 결과가 무작위로 등장합니다:<br>
	 * <br>
	 * - 고기 (30% 확률): 체력을 회복시켜줍니다.<br>
	 * 		- 체력이 85 이상이면 → 최대 체력까지 회복<br>
	 * 		- 체력이 100이면 → 아무 일도 일어나지 않음<br>
	 * 		- 그 외 → 체력 +15<br>
	 * - 폭탄 (30% 확률): 플레이어의 체력을 10 감소시킵니다.<br>
	 * - 신발 (10% 확률): 플레이어의 회피율을 1 증가시킵니다.<br>
	 * - 뼈다귀 (40% 확률): 아무 효과 없는 꽝 아이템입니다.<br>
	 */
	public void randomBox() {
		// 상자 발견 메세지 출력
		System.out.println("랜덤박스를 발견했습니다!");
		
		// 0~99 사이의 난수 생성
		int randNumber = random.nextInt(100);
		   
		// [고기] 30% 확률 (0~29)
		if (randNumber < 30) {
			// 플레이어의 현재 체력이 85 이상이면 → 최대 체력까지 회복
			if (user[userCount].hp >= 85) {
				System.out.println("고기를 발견했습니다. 최대 체력까지 회복합니다.");
				user[userCount].hp = Config.MAX_HP; // 최대 체력으로 설정
			
			// 체력이 이미 100이라면 → 아무 효과 없음
			} else if (user[userCount].hp == Config.MAX_HP) {
				System.out.println("체력이 이미 100입니다. 고기가 자연으로 돌아갔습니다.");
			
			// 그 외 → 체력 +15 회복
			} else {
				System.out.println("고기를 발견했습니다. 체력을 15 회복합니다.");
				user[userCount].hp += 15; // 사용자 체력 + 15
			}
			
		// [폭탄] 30% 확률 (30~59)
		} else if (randNumber < 60) {
			// 체력 10 감소 메시지 출력 및 체력 감소
			System.out.println("폭탄 발견!! 체력이 10 깎였습니다.");
			user[userCount].hp -= 10; 
		
		// [신발] 10% 확률 (60~69)
		} else if (randNumber < 70) {
			System.out.println("고급 신발 발견!! 스피드가 1 상승합니다");
			user[userCount].avoidanceRate += 1;
			
		// [뼈다귀] 40% 확률 (70~99)
		} else {
			// 꽝 메세지 출력 (효과 없음)
			System.out.println("뼈다귀 발견. 꽝!");
		}	      
	}
	
	/**
	 * 몬스터 도감 정보를 출력하는 메서드<br>
	 * <br>
	 * 이 메서드는 플레이어가 조우할 수 있는 모든 몬스터의 기본 정보를
	 * 콘솔에 표 형식으로 출력합니다.<br>
	 * 각 몬스터에 대한 다음의 정보를 포함합니다:<br>
	 * <br>
	 * - 이름<br>
	 * - 점수 : 해당 몬스터를 잡았을 때 얻는 점수<br>
	 * - 발견 확률 : 해당 몬스터를 조우할 확률<br>
	 * - 잡힐 확률 : 싸움을 선택했을 때 몬스터가 잡힐 확률<br>
	 * <br>
	 * 몬스터는 난이도 순으로 정렬되어 있으며,
	 * 번호가 높을수록 조우 확률과 포획 확률이 낮고 점수는 높습니다.<br>
	 * <br>
	 * 출력 예시:<br>
	 * 이름 | 점수 | 발견 확률 | 잡힐 확률<br>
	 * 은지 | 10 | 40% | 100%<br>
	 * 성진 | 30 | 30% | 80%<br>
	 * 주영 | 50 | 15% | 60%<br>
	 * 승준 | 100 | 10% | 40%<br>
	 * 영철 | 999999 | 5% | 10%<br>
	 */
	public void dictMon() {
	    System.out.println(String.format("%-6s | %6s | %6s | %6s", "이름", "점수", "발견확률", "잡힐확률"));
	    for (int i = 0; i < 5; i++) {
	        System.out.println(String.format("%-6s | %6d점 | %7d%% | %6d%%",
	            monster[i].name, monster[i].score, monster[i].findRate, monster[i].catchRate));
	    }
	}

	
	/**
	 * 사용자가 잡은 몬스터들을 인벤토리에서 확인할 수 있는 메소드<br>
	 * <br>
	 * 인벤토리가 비어있을 경우 잡은 몬스터가 없음 메세지 출력<br>
	 * <br>
	 * 인벤토리에 몬스터가 있으면 잡은 몬스터 목록 출력
	 */
	public void catchedMon() {
    	System.out.println("========== 몬스터 인벤토리 ==========");
    	System.out.println("이름 | 잡은 마리 수 | 총 점수");
    	for (int i = 0; i < 5; i++) {
    		System.out.println(String.format("%s | %9d | %4d", monster[i].name, monster[i].count, (monster[i].count * monster[i].score)));
    	}

	}
	
	/**
	 * 현재 사용자 정보를 출력하는 메소드
	 * <p>
	 * 이름, 체력, 점수, 회피 확률 등 사용자의 상태를 
	 * 보기 좋게 포맷팅하여 콘솔에 출력합니다.
	 * </p>
	 * 
	 * <p>
	 * 사용자 배열에서 현재 인덱스(this.userCount)를 기준으로 정보를 가져옵니다.
	 * </p>
	 */
	public void userInfo() {
	    System.out.println("========== 유저 정보 ==========");
	    System.out.printf("이름       : %s\n", user[this.userCount].userName);
	    System.out.printf("체력       : %d / %d\n", user[this.userCount].hp, Config.MAX_HP);
	    System.out.printf("점수       : %d점\n", user[this.userCount].score);
	    System.out.printf("회피 확률  : %d%%\n", user[this.userCount].avoidanceRate);
	}

	
	/**
	 * 플레이어들의 점수를 기준으로 순위를 정렬하고 출력하는 메서드
	 * 
	 * 이 메서드는 현재까지 게임을 플레이한 모든 유저의 점수를 기준으로
	 * 높은 점수 순으로 순위를 매기고, 그 결과를 콘솔에 출력합니다.
	 * 
	 * 주요 동작:
	 * - 유저 점수 배열을 만들어 내림차순으로 정렬 (삽입 정렬 사용)
	 * - 점수와 일치하는 유저 이름을 찾아 순위에 매핑
	 * - 순위표를 출력 (1등부터 N등까지)
	 * 
	 * 조건:
	 * - 등록된 유저가 한 명도 없을 경우, 안내 메시지만 출력 후 종료됩니다.
	 */
	public void ranking() {
		// 유저가 한 명도 등록되지 않았을 경우 메세지 출력 후 종료
		if (this.userCount == 0) {
			System.out.println("현재 순위가 없습니다. 1등에 도전해보세요!");
			return;
		}
		
		// 유저 점수를 저장할 배열
		int[] rank = new int[this.userCount];
		
		// 순위에 해당하는 유저 이름을 저장할 배열
		String[] rankUser = new String[this.userCount];
		
		// 유저의 점수를 rank 배열에 복사
		for (int i = 0; i < this.userCount; i++) {
			rank[i] = user[i].score;
		}
		
		// 삽입 정렬을 사용하여 점수를 내림차순으로 정렬
		for (int i = 1; i < this.userCount; i++) {
			int key = rank[i]; 	// 현재 비교할 점수
			int j = i - 1; 
			
			// 앞쪽 점수들이 key보다 작으면 뒤로 한 칸씩 이동
			while (j >= 0 && rank[j] < key) {
				rank[j + 1] = rank[j];
				j--;
			}	
			
			// key를 적절한 위치에 삽입
			rank[j + 1] = key;
		}

		// 정렬된 점수와 실제 유저 이름을 매칭
		for (int i = 0; i < this.userCount; i++) {
			for (int j = 0; j < this.userCount; j++) {
				
				// 점수가 일치하는 유저를 찾았을 때
				if (rank[i] == user[j].score) {
					
					// 중복된 이름이 이미 등록되었는지 확인
		            boolean alreadyExists = false;
		            for (int k = 0; k < this.userCount; k++) {
		                if (rankUser[k] != null && rankUser[k].equals(user[j].userName)) {
		                    alreadyExists = true;
		                    break;
		                }
		            }
		            
		            // 중복이 아니라면 유저 이름을 해당 순위에 할당
		            if (!alreadyExists) {
		                rankUser[i] = user[j].userName;
		                break; // 한 명만 매칭 후 루프 종료
		            }
				}
			}
		}
		
		// 최종 순위 출력
		System.out.println("========== 순위 ==========");
		for (int i = 0; i < this.userCount; i++) {
			System.out.println("" + (i+1) + "등 : " + rankUser[i] + ", " + rank[i] + "점");
		}
	}
	
	/**
	 * 게임의 메인 루프를 담당하는 메서드
	 * 
	 * 플레이어가 게임을 시작한 후, 종료 조건이 만족될 때까지 계속 반복되는 구조입니다.
	 * 주요 기능은 다음과 같습니다:
	 * 
	 * - 체력이 0 이하가 되면 게임 종료 및 점수 출력
	 * - 점수가 999999점 이상이 되면 '전설의 교수님 영철'을 잡은 것으로 간주하고 게임 종료
	 * - 반복되는 게임 메뉴를 통해 다음 선택 가능:
	 *     1. 탐색: 요정/랜덤박스/몬스터 중 하나 무작위로 발생
	 *     2. 물약 사용: 체력이 100이 아닐 경우 포션으로 회복
	 *     3. 몬스터 도감 확인
	 *     4. 인벤토리 확인 (잡은 몬스터 목록)
	 *     5. 유저 정보 출력
	 *     6. 수동 게임 종료
	 * 
	 * 사용자의 입력에 따라 각 기능이 호출되며, 입력 오류도 체크하여 안내 메시지를 출력합니다.
	 */
	public void inGame() {
		while(true) {
			// 체력이 0 이하일 경우 게임 종료
			if (user[this.userCount].hp <= 0) {
				// 체력 소진 메세지 출력 및 사용자의 최종 점수 출력
				System.out.println("모든 체력을 소진했습니다. 게임을 종료합니다.");
				System.out.println("당신의 점수 : " + user[this.userCount].score);
				System.out.println();
				
				// 다음 유저로 인덱스 이동
				this.userCount++;
				
				// 잡은 몬스터 수 초기화
				for (int i = 0; i < 5; i++) {
					monster[i].count = 0;
				}
				
				break;
			}
			
			// 점수가 최대 점수 이상일 경우 클리어
			if (user[this.userCount].score >= 999999) {
				// 축하 메세지 출력 및 사용자의 최종 점수 출력
				System.out.println("전설의 교수님 영철을 잡았습니다!");
				System.out.println("👏👏👏당신이 새로운 전설이에요👏👏👏");
				System.out.println("당신의 점수 : " + user[this.userCount].score);
				System.out.println();
				
				// 다음 유저로 인덱스 이동
				this.userCount++;
				
				// 잡은 몬스터 수 초기화
				for (int i = 0; i < 5; i++) {
					monster[i].count = 0;
				}
				
				break;
			}
			
			// 게임 메뉴 출력
    		System.out.println("========== 게임 메뉴 ==========");
            System.out.println("1. 탐색 | 2. 물약먹기(현재 개수 : "+ this.hpPotionCount + "개) | 3. 몬스터 도감 | 4. 몬스터 인벤토리 | 5. 유저 정보 | 6. 게임종료");
            System.out.print("번호를 입력하세요: ");
            
            // 사용자 입력 받기
            String temp = scanner.nextLine();
            System.out.println();
            
            // 1. 탐색 선택 시
            if (temp.equals("1")) {
            	
            	// 0~9 사이 난수 생성
            	int randNum = random.nextInt(10);
            	
            	// 10% 확률로 요정 등장
            	if (randNum == 0) {
            		fairy();
            		System.out.println();
            	} 
            	
            	// 10% 확률로 랜덤박스 등장
            	else if (randNum == 1) {
            		randomBox();
            		System.out.println();
            	}
            	
            	// 나머지 경우엔 몬스터 등장
            	else {
            		encounter();
            		System.out.println();
            	}
            	
        	// 2. 포션 사용
            } else if (temp.equals("2")) {
            	
            	// 체력이 이미 최대일 경우
    		    if (user[userCount].hp == Config.MAX_HP) {
    		        System.out.println("체력이 충분합니다. 포션을 사용할 수 없습니다.");
    		        System.out.println();
    		        
		        // 포션이 있을 경우
    			} else if (hpPotionCount > 0) {
    				
    				// 체력이 70 이상이면 최대 체력까지 회복
    				if (user[userCount].hp >= 70) {
    					System.out.println("포션을 사용했습니다! 최대 체력까지 회복합니다.");
    					System.out.println();
    					user[userCount].hp = Config.MAX_HP;
    					this.hpPotionCount -= 1;
    					
					// 체력이 70 미만이면 30 회복
    				} else {
    					System.out.println("포션을 사용했습니다! 체력이 30 회복되었습니다.");
    					System.out.println();
    					user[userCount].hp += 30;
    					this.hpPotionCount -= 1;
    				}
    				
				// 포션이 없을 경우
    			} else {
    			    System.out.println("포션이 없습니다!");
    			    System.out.println();
    			}
    		    
		    // 3. 몬스터 도감 출력
    		} else if (temp.equals("3")) {
            	dictMon();
            	System.out.println();
            }
            
            // 4. 인벤토리 출력
            else if (temp.equals("4")) {
            	catchedMon();
            	System.out.println();
            }
            
            // 5. 유저 정보 출력
            else if (temp.equals("5")) {
            	userInfo();
            	System.out.println();
            }
            
            // 6. 사용자가 게임 종료 선택
            else if (temp.equals("6")) {
            	System.out.println("게임을 종료합니다.");
            	System.out.println();
            	
            	// 다음 유저로 인덱스 이동
            	this.userCount++;
            	
            	// 잡은 몬스터 수 초기화
				for (int i = 0; i < 5; i++) {
					monster[i].count = 0;
				}
				
            	break;
            }
            
            // 그 외 잘못된 입력
            else {
            	System.out.println("잘못된 입력입니다. 올바른 메뉴 번호로 입력해주세요🙏");
            	System.out.println();
            }
    	}
	}
	
	/**
	 * 게임의 메인 메뉴를 처리하는 메소드<br>
	 * <br>
	 * 이 메서드는 게임 시작 시 유저가 선택할 수 있는 
	 * 기본적인 메뉴를 제공합니다. 사용자가 선택한 메뉴에 따라 게임을 진행하거나 순위를 확인하고,
	 * 종료할 수 있습니다.
	 */
	public void gameStart() {
		while(true) {
			// 메인 메뉴 출력
			System.out.println("========== 메인 메뉴 ==========");
	        System.out.println("1. 유저 생성 | 2. 현재 순위 | 3. 종료");
	        System.out.print("번호를 입력하세요: ");
	        
	        // 사용자의 입력을 받음
	        String temp = scanner.nextLine();
	        System.out.println();
	        
	        // '1' 입력 시 유저 생성 후 게임 시작
	        if (temp.equals("1")) {
	        	
	        	// createUser() 메소드를 호출하여 유저를 생성하고, 성공 시 게임을 시작함
	        	if (createUser()) {
	        		System.out.println();
	        		inGame(); // 유저 생성 후 게임 진행
	        	}
	        	
        	// '2' 입력 시 현재 순위 출력
	        } else if (temp.equals("2")) {
	        	// ranking() 메소드를 호출하여 순위 출력
	        	ranking();
	        	System.out.println();
	        	
        	// '3' 입력 시 게임 종료
	        } else if (temp.equals("3")) {
	        	System.out.println("게임을 종료합니다. 감사합니다!");
	        	return;
	        	
        	// 잘못된 입력 시 오류 메시지 출력
	        } else {
            	System.out.println("잘못된 입력입니다. 올바른 메뉴 번호로 입력해주세요🙏");
            	System.out.println();
            }
		}
	}
}

