package shopping;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Shopping shopping = new Shopping();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("환영합니다~! 행복을 전하는 스금과 승준 쇼핑몰입니다!");
		System.out.println("하단의 메뉴에서 원하시는 기능을 선택해주세요!");
		System.out.println();
		
		
		while(true) {
			// 초기 메뉴
			System.out.println("---------메뉴--------");
			System.out.print("1. 로그인 | 2. 회원 가입 | q. 종료 -> ");
			String inputMenu = scanner.nextLine();
			System.out.println();
			
			if (inputMenu.equals("1")) {
				while(true) {
					// 로그인 메뉴
					System.out.println("--------로그인-------");
					System.out.print("1. 공급자 로그인 | 2. 구매자 로그인 | 3. 비회원 로그인 | q. 종료 -> ");
					String loginMenu = scanner.nextLine();
					System.out.println();
					
					// 공급자 메뉴
					if (loginMenu.equals("1")) {
						System.out.println("--------공급자 로그인-------");
						System.out.print("아이디 입력 : ");
						String proId = scanner.nextLine();
						
						
						System.out.print("비밀번호 입력 : ");
						String proPw = scanner.nextLine();
						
						if (proId.equals(shopping.provider.id)) {
							if (proPw.equals(shopping.provider.pw)) {
								System.out.println("로그인에 성공했습니다.");
								System.out.println("환영합니다! " + shopping.provider.name + "님");
							} else {
								System.out.println("비밀번호가 틀립니다.");
								System.out.println();
								break;
							}
						} else {
							System.out.println("아이디가 틀리거나 존재하지 않습니다.");
							System.out.println();
							break;
						}
						System.out.println();
						
						while(true) {
							System.out.println("--------공급자 메뉴-------");
							System.out.print("1. 상품 등록 | 2. 등록 상품 조회 | 3. 상품 삭제 | q. 로그아웃 -> ");
							String providerMenu = scanner.nextLine();
							System.out.println();
							
							if (providerMenu.equals("1")) {
								System.out.println("--------상품 등록-------");
								shopping.inputProduct();
								System.out.println();
								
							} else if (providerMenu.equals("2")) {
								System.out.println("--------등록 상품 조회-------");
								shopping.searchProduct();
								System.out.println();
								
							} else if (providerMenu.equals("3")) {
								System.out.println("--------상품 삭제-------");
								shopping.deleteProduct();
								System.out.println();
							}
							else if (providerMenu.equals("q")) {
								System.out.println("로그아웃합니다. 감사합니다.");
								System.out.println();
								break;
							}
							else {
								System.out.println("올바른 메뉴 번호를 입력해주세요.");
								System.out.println();
							}
						}
						
						
					} 
					
					// 구매자 메뉴
					else if (loginMenu.equals("2")) {
						System.out.println("--------구매자 로그인-------");
						System.out.print("아이디 입력 : ");
						String conId = scanner.nextLine();
						
						
						System.out.print("비밀번호 입력 : ");
						String conPw = scanner.nextLine();
						
						if (conId.equals(shopping.consumer.id)) {
							if (conPw.equals(shopping.consumer.pw)) {
								System.out.println("로그인에 성공했습니다.");
								System.out.println("환영합니다! " + shopping.consumer.name + "님");
							} else {
								System.out.println("비밀번호가 틀립니다.");
								System.out.println();
								break;
							}
						} else {
							System.out.println("아이디가 틀리거나 존재하지 않습니다.");
							System.out.println();
							break;
						}
						System.out.println();
						
						while(true) {
							System.out.println("---------구매자 메뉴--------");
							System.out.print("1. 상품 조회 | 2. 장바구니 담기 | 3. 장바구니 조회 | 4. 장바구니 삭제 | 5. 장바구니 비우기 | 6. 구매 | q. 로그아웃  -> ");
							
							String consumerMenu = scanner.nextLine();
							System.out.println();
							
							if (consumerMenu.equals("1")) {
								System.out.println("--------상품 조회-------");
								shopping.searchProduct();
								System.out.println();
							} else if (consumerMenu.equals("2")) {
								System.out.println("--------장바구니 담기-------");
								shopping.conInsertBasket();;
								System.out.println();
							} else if (consumerMenu.equals("3")) {
								System.out.println("--------장바구니 조회-------");
								shopping.conSearchBasket();;
								System.out.println();
							} else if (consumerMenu.equals("4")) {
								System.out.println("--------장바구니 삭제-------");
								shopping.conDeleteBasket();;
								System.out.println();
							} else if (consumerMenu.equals("5")) {
								System.out.println("--------장바구니 비우기-------");
								shopping.conAllDelBasket();;
								System.out.println();
							} else if (consumerMenu.equals("6")) {
								System.out.println("--------구매-------");
								shopping.conPurchase();
								System.out.println();
							} else if (consumerMenu.equals("q")) {
								System.out.println("로그아웃합니다. 감사합니다.");
								System.out.println();
								break;
							}
							else {
								System.out.println("올바른 메뉴 번호를 입력해주세요.");
								System.out.println();
							}
						}
					} 
					
					// 비회원 메뉴
					else if (loginMenu.equals("3")) {
						while(true) {
							System.out.println("---------비회원 메뉴--------");
							System.out.print("1. 상품 조회 | 2. 장바구니 담기 | 3. 장바구니 조회 | 4. 장바구니 삭제 | 5. 장바구니 비우기 | 6. 구매 | q. 로그아웃  -> ");
							
							String nConsumerMenu = scanner.nextLine();
							System.out.println();
							
							if (nConsumerMenu.equals("1")) {
								System.out.println("--------상품 조회-------");
								shopping.searchProduct();
								System.out.println();
							} else if (nConsumerMenu.equals("2")) {
								System.out.println("--------장바구니 담기-------");
								shopping.nConInsertBasket();;
								System.out.println();
							} else if (nConsumerMenu.equals("3")) {
								System.out.println("--------장바구니 조회-------");
								shopping.nConSearchBasket();;
								System.out.println();
							} else if (nConsumerMenu.equals("4")) {
								System.out.println("--------장바구니 삭제-------");
								shopping.nConDeleteBasket();;
								System.out.println();
							} else if (nConsumerMenu.equals("5")) {
								System.out.println("--------장바구니 비우기-------");
								shopping.nConAllDelBasket();;
								System.out.println();
							} else if (nConsumerMenu.equals("6")) {
								System.out.println("--------구매-------");
								shopping.nConPurchase();
								System.out.println();
							} else if (nConsumerMenu.equals("q")) {
								System.out.println("로그아웃합니다. 감사합니다.");
								System.out.println();
								break;
							}
							else {
								System.out.println("올바른 메뉴 번호를 입력해주세요.");
								System.out.println();
							}
						}
					} 

					else if (loginMenu.equals("q")) {
						System.out.println("로그인을 종료합니다.");
						System.out.println();
						break;
					} 
					else {
						System.out.println("올바른 메뉴 번호를 입력해주세요.");
						System.out.println();
					}
				}
				
			// 회원가입 메뉴	
			} else if (inputMenu.equals("2")) {
				while(true) {
					System.out.println("--------회원가입-------");
					System.out.print("1. 공급자 회원가입 | 2. 구매자 회원가입 | q. 종료  -> ");
					String signupMenu = scanner.nextLine();
					System.out.println();
					
					if (signupMenu.equals("1")) {
						System.out.println("--------공급자 회원가입-------");
						shopping.signupProv();
						System.out.println();
						System.out.println("초기 메뉴로 이동합니다.");
						System.out.println();
						break;
						
					} else if (signupMenu.equals("2")) {
						System.out.println("--------구매자 회원가입-------");
						shopping.signupCons();
						System.out.println();
						System.out.println("초기 메뉴로 이동합니다.");
						System.out.println();
						break;
						
					} else if (signupMenu.equals("q")) {
						System.out.println("회원가입을 종료합니다.");
						System.out.println();
						break;
					}
					else {
						System.out.println("올바른 메뉴 번호를 입력해주세요.");
						System.out.println();
					}
				}
			
			// 종료
			} else if (inputMenu.equals("q")) {
				System.out.println("감사합니다! 다음에 또 방문해주세요~! 스금과 승준 쇼핑몰이었습니다~~!");
				break;
			}
			else {
				System.out.println("올바른 메뉴 번호를 입력해주세요.");
				System.out.println();
			}
		}
	}
}
