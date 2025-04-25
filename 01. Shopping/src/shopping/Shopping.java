package shopping;

import java.util.Scanner;

public class Shopping {
	// 상품 객체 배열 선언
	Product[] product = new Product[999999];

	// 구매 객체 생성
	Purchase purchase = new Purchase();

	// 구매자 장바구니 객체 배열 선언
	Basket[] conBasket = new Basket[999999];

	// 비회원 장바구니 객체 배열 선언
	Basket[] nonConBasket = new Basket[999999];

	// 공급자 객체 생성
	Provider provider = new Provider();

	// 구매자 객체 생성
	Consumer consumer = new Consumer();

	// 상품 번호
	int productNum = 0;

	// 구매자 장바구니 번호
	int conBasketNum = 0;

	// 비회원 장바구니 번호
	int nConBasketNum = 0;

	// 구매자 최종 가격
	int conFinalPrice = 0;

	// 비회원 최종 가격
	int nConFinalPrice = 0;

	/*
	 * 공급자 회원가입 메소드
	 * 메소드 정의 : 이름, 아이디, 비밀번호를 입력 받고 비밀번호가 맞는지 한번 더 입력을 받고 맞다면 회원가입 / 아니라면 회원가입 실패
	 */
	public void signupProv() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String proName = scanner.nextLine();

		System.out.print("아이디 입력 : ");
		String proId = scanner.nextLine();

		System.out.print("비밀번호 입력 : ");
		String proPw = scanner.nextLine();

		System.out.print("비밀번호 확인 : ");
		String pwCheck = scanner.nextLine();

		if (proPw.equals(pwCheck)) {
			provider.name = proName;
			provider.id = proId;
			provider.pw = proPw;
			System.out.println("회원가입을 성공적으로 완료했습니다. 환영합니다, " + provider.name + "님");
		} else {
			System.out.println("비밀번호가 맞지 않습니다. 회원가입을 종료합니다.");
		}
	}

	/*
	 * 구매자 회원가입 메소드
	 * 메소드 정의 : 이름, 아이디, 비밀번호를 입력 받고 비밀번호가 맞는지 한번 더 입력을 받고 맞다면 회원가입 / 아니라면 회원가입 실패
	 */
	public void signupCons() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String proName = scanner.nextLine();

		System.out.print("아이디 입력 : ");
		String conId = scanner.nextLine();

		System.out.print("비밀번호 입력 : ");
		String conPw = scanner.nextLine();

		System.out.print("비밀번호 확인 : ");
		String pwCheck = scanner.nextLine();

		System.out.print("배송지 입력 : ");
		String conDeli = scanner.nextLine();

		System.out.print("연락처 입력 : ");
		String conPhone = scanner.nextLine();

		if (conPw.equals(pwCheck)) {
			consumer.name = proName;
			consumer.id = conId;
			consumer.pw = conPw;
			consumer.deliveryDest = conDeli;
			consumer.contectInfo = conPhone;
			System.out.println("회원가입을 성공적으로 완료했습니다. 환영합니다, " + consumer.name + "님");
		} else {
			System.out.println("비밀번호가 맞지 않습니다. 회원가입을 종료합니다.");
		}
	}

	/*
	 * 상품명 입력 메소드
	 * 메소드 정의 : 상품명과 상품 가격을 입력받아 상품 객체에 등록하는 메소드
	 */
	public void inputProduct() {
		// 입력 객체, 상품 객체 생성
		Scanner scanner = new Scanner(System.in);
		product[productNum] = new Product();

		// 상품명 입력
		System.out.print("상품명 입력 : ");
		String temp = scanner.nextLine();
		product[productNum].name = temp;

		// 상품 가격 입력
		while (true) {
			System.out.print("상품 가격 입력 (예: 1000) : ");
			temp = scanner.nextLine();
			// 예외처리 : 입력이 숫자 형식이 아닐 경우 재입력 유도
			try {
				product[productNum].price = Integer.parseInt(temp);
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		// 상품 번호 삽입
		product[productNum].productNum = this.productNum + 1;

		// 상품 번호 +1
		this.productNum += 1;

		System.out.println("상품이 성공적으로 등록되었습니다.");
	}

	/*
	 * 상품명 조회 메소드
	 * 메소드 정의 : 현재 등록된 상품의 객체를 출력하는 메소드
	 */
	public void searchProduct() {
		// 등록된 상품이 없다면 종료
		if (product[0] == null) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		System.out.println("상품번호 | 상품명 | 가격");
		for (int i = 0; i < product.length; i++) {
			// 현재 인덱스가 빈 객체 배열이라면 종료
			if (product[i] == null) {
				break;
			}
			System.out.println(product[i].productNum + ". " + product[i].name + " " + product[i].price);
		}
	}

	/*
	 * 상품 삭제 메소드
	 * 메소드 정의 : 삭제할 상품의 번호를 입력받고 해당 번호의 상품을 삭제하는 메소드
	 */
	public void deleteProduct() {
		if (product[0] == null) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		// 삭제할 번호 변수 생성
		int delNum;

		while (true) {
			// 현재 상품 출력
			searchProduct();
			System.out.print("삭제할 상품 번호 입력 : ");
			String temp = scanner.nextLine();

			// 예외처리 : 입력 형식이 숫자가 아니라면 재시도
			try {
				delNum = Integer.parseInt(temp) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		// 입력한 숫자가 음수라면 종료
		if (delNum < 0) {
			System.out.println("해당 번호는 잘못된 형식의 번호입니다. 1 이상의 번호를 입력해주세요");
			return;
		}

		// 입력한 숫자의 상품이 없다면 종료
		if (product[delNum] == null) {
			System.out.println("해당 번호는 없는 상품의 번호입니다. 다시 시도해주세요.");
			return;
		}

		// 삭제할 상품의 인덱스를 null로 선언
		product[delNum] = null;

		// 삭제할 상품의 인덱스를 기준으로 뒤에 있는 객체 앞으로 당기기
		for (int i = delNum; i < this.productNum - 1; i++) {
			product[i] = product[i + 1];
			product[i].productNum = product[i + 1].productNum - 1;
		}

		System.out.println("상품을 삭제했습니다.");

		// 등록된 상품 기준 맨 마지막 인덱스 비우기
		product[this.productNum - 1] = null;

		// 상품 번호 -1
		this.productNum -= 1;

		// 삭제 후 등록된 상품이 없다면 종료
		if (product[0] == null) {
			return;
		}

		// 삭제 후 현재 등록된 상품 출력
		System.out.println("상품번호 | 상품명 | 가격");
		for (int i = 0; i < product.length; i++) {
			// 빈 객체 배열이라면 종료
			if (product[i] == null) {
				break;
			}
			System.out.println(product[i].productNum + ". " + product[i].name + " " + product[i].price);
		}
	}

	/*
	 * 구매자 장바구니 담기 메소드
	 * 메소드 정의 : 현재 등록된 상품을 기준으로 상품을 선택해 장바구니에 담는 메소드
	 */
	public void conInsertBasket() {
		// 등록된 상품이 없다면 종료
		if (product[0] == null) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		// 입력받을 임시 문자 변수 선언
		String temp;

		// 담을 상품의 번호, 담을 상품의 갯수, 담을 상품의 총 가격 변수 선언
		int pNum;
		int pCount;
		int totalPrice;

		while (true) {
			searchProduct();
			System.out.print("구매할 상품의 번호 입력 : ");
			temp = scanner.nextLine();

			try {
				pNum = Integer.parseInt(temp) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		if (pNum < 0) {
			System.out.println("해당 번호는 잘못된 형식의 번호입니다. 1 이상의 번호를 입력해주세요");
			return;
		}

		if (product[pNum] == null) {
			System.out.println("없는 번호의 상품입니다. 다시 시도해주세요.");
			return;
		}

		// 선택한 상품의 정보 출력
		System.out.println("구매할 상품 : " + product[pNum].name + " " + product[pNum].price + "(원/1개)");

		while (true) {
			System.out.print("구매할 갯수 입력 (개): ");
			temp = scanner.nextLine();

			try {
				pCount = Integer.parseInt(temp);
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		// 상품의 갯수가 0이거나 음수일 때 종료
		if (pCount <= 0) {
			System.out.println("상품의 갯수가 정상적이지 않습니다. 다시 시도해주세요.");
			return;
		}

		// 담을 상품의 총 가격 계산
		totalPrice = product[pNum].price * pCount;

		// 담을 상품의 이름과 갯수, 총 가격 출력
		System.out.println("구매하실 상품은 " + product[pNum].name + " " + pCount + "개, 총 " + totalPrice + "원입니다.");

		System.out.print("장바구니에 담으시겠습니까? (y/n) : ");
		temp = scanner.nextLine();

		// 장바구니에 담기 선택 시 구매자 장바구니 객체를 생성해 정보를 추가
		if (temp.equals("y")) {
			System.out.println("장바구니에 추가되었습니다.");
			conBasket[this.conBasketNum] = new Basket();

			conBasket[this.conBasketNum].product = product[pNum].name;
			conBasket[this.conBasketNum].count = pCount;
			conBasket[this.conBasketNum].price = totalPrice;

			// 구매자의 최종 가격에 담은 상품의 총 가격을 추가하고 장바구니 번호 +1
			this.conFinalPrice += totalPrice;
			this.conBasketNum += 1;
		} else if (temp.equals("n")) {
			System.out.println("구매를 취소했습니다. 처음으로 돌아갑니다.");
		} else {
			System.out.println("장바구니에 실패했습니다. 처음으로 돌아갑니다.");
		}
	}

	/*
	 * 구매자 현재 장바구니 조회 메소드
	 * 메소드 정의 : 현재 장바구니에 담긴 상품의 이름, 갯수, 총 가격 출력
	 */
	public void conSearchBasket() {
		// 장바구니에 담긴 상품이 없다면 종료
		if (conBasket[0] == null) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		// 장바구니에 담긴 상품 정보 출력
		System.out.println("장바구니 번호 | 상품 | 개수 | 금액");
		for (int i = 0; i < conBasket.length; i++) {
			if (conBasket[i] == null) {
				break;
			}
			System.out.println(
					(i + 1) + ". " + conBasket[i].product + " " + conBasket[i].count + " " + conBasket[i].price + "원");
		}
		System.out.println("-------------------");
		System.out.println("총 " + conFinalPrice + "원");
	}

	/*
	 * 구매자 장바구니 삭제 메소드
	 * 메소드 정의 : 장바구니의 번호를 입력받아 해당 장바구니 객체 삭제
	 */
	public void conDeleteBasket() {
		if (conBasket[0] == null) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		// 삭제할 번호, 삭제할 번호의 상품의 총 가격을 담을 변수 선언
		int delNum;
		int delPrice;

		while (true) {
			conSearchBasket();
			System.out.print("삭제할 장바구니 번호 입력 : ");
			String temp = scanner.nextLine();
			try {
				delNum = Integer.parseInt(temp) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		if (delNum < 0) {
			System.out.println("해당 번호는 잘못된 형식의 번호입니다. 1 이상의 번호를 입력해주세요");
			return;
		}

		if (conBasket[delNum] == null) {
			System.out.println("해당 번호는 없는 상품의 번호입니다. 다시 시도해주세요.");
			return;
		}

		// 삭제할 상품의 총 가격 대입
		delPrice = conBasket[delNum].price;

		// 삭제할 번호의 장바구니 비우기
		conBasket[delNum] = null;

		// 삭제할 번호 기준 뒤에 있는 인덱스 값 앞으로 당기기
		for (int i = delNum; i < this.conBasketNum - 1; i++) {
			conBasket[i] = conBasket[i + 1];
		}

		// 현재 등록된 장바구니 기준 맨 뒤 인덱스 비우기
		conBasket[this.conBasketNum - 1] = null;
		System.out.println("장바구니를 삭제했습니다.");

		// 장바구니 번호 -1
		this.conBasketNum -= 1;

		// 구매자의 최종 가격에서 삭제한 상품의 총 가격 뺌
		this.conFinalPrice -= delPrice;

		// 삭제한 후 장바구니 출력
		conSearchBasket();
	}

	/*
	 * 구매자 장바구니 전체 비우기 메소드
	 * 메소드 정의 : 현재 장바구니를 모두 비우는 메소드
	 */
	public void conAllDelBasket() {
		if (conBasketNum == 0) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		for (int i = 0; i < this.conBasketNum; i++) {
			conBasket[i] = null;
		}

		System.out.println("장바구니를 전체 비우기했습니다.");
		this.conBasketNum = 0;
		this.conFinalPrice = 0;

		// 장바구니가 비워졌는지 확인
		if (conBasket[0] == null) {
			return;
		}

		System.out.println("장바구니 번호 | 상품 | 개수 | 금액");
		for (int i = 0; i < conBasket.length; i++) {
			if (conBasket[i] == null) {
				break;
			}
			System.out.println(
					(i + 1) + ". " + conBasket[i].product + " " + conBasket[i].count + " " + conBasket[i].price + "원");
		}
		System.out.println("-------------------");
		System.out.println("총 " + conFinalPrice + "원");

	}

	/*
	 * 비회원 장바구니 담기 메소드
	 * 메소드 정의 : 비회원의 장바구니에 상품을 담는 메소드
	 */
	public void nConInsertBasket() {
		if (product[0] == null) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		String temp;
		int pNum;
		int pCount;
		int totalPrice;

		while (true) {
			searchProduct();
			System.out.print("구매할 상품의 번호 입력 : ");
			temp = scanner.nextLine();

			try {
				pNum = Integer.parseInt(temp) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		if (pNum < 0) {
			System.out.println("해당 번호는 잘못된 형식의 번호입니다. 1 이상의 번호를 입력해주세요");
			return;
		}

		if (product[pNum] == null) {
			System.out.println("없는 번호의 상품입니다. 다시 시도해주세요.");
			return;
		}

		System.out.println("구매할 상품 : " + product[pNum].name + " " + product[pNum].price + "(원/1개)");

		while (true) {
			System.out.print("구매할 갯수 입력 (개): ");
			temp = scanner.nextLine();

			try {
				pCount = Integer.parseInt(temp);
				totalPrice = product[pNum].price * pCount;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		System.out.println("구매하실 상품은 " + product[pNum].name + " " + pCount + "개, 총 " + totalPrice + "원입니다.");
		System.out.print("장바구니에 담으시겠습니까? (y/n) : ");
		temp = scanner.nextLine();

		if (temp.equals("y")) {
			System.out.println("장바구니에 추가되었습니다.");
			nonConBasket[this.nConBasketNum] = new Basket();

			nonConBasket[this.nConBasketNum].product = product[pNum].name;
			nonConBasket[this.nConBasketNum].count = pCount;
			nonConBasket[this.nConBasketNum].price = totalPrice;
			this.nConFinalPrice += totalPrice;
			this.nConBasketNum += 1;
		} else if (temp.equals("n")) {
			System.out.println("구매를 취소했습니다. 처음으로 돌아갑니다.");
		} else {
			System.out.println("장바구니에 실패했습니다. 처음으로 돌아갑니다.");
		}
	}

	/*
	 * 비회원 현재 장바구니 조회 메소드
	 * 메소드 정의 : 비회원의 현재 장바구니를 조회하는 메소드
	 */
	public void nConSearchBasket() {
		if (nonConBasket[0] == null) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		System.out.println("장바구니 번호 | 상품 | 개수 | 금액");
		for (int i = 0; i < nonConBasket.length; i++) {
			if (nonConBasket[i] == null) {
				break;
			}
			System.out.println((i + 1) + ". " + nonConBasket[i].product + " " + nonConBasket[i].count + " "
					+ nonConBasket[i].price + "원");
		}
		System.out.println("-------------------");
		System.out.println("총 " + nConFinalPrice + "원");
	}

	/*
	 * 비회원 장바구니 삭제 메소드
	 * 메소드 정의 : 비회원의 장바구니에서 담은 상품을 삭제하는 메소드
	 */
	public void nConDeleteBasket() {
		if (nonConBasket[0] == null) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);
		int delNum;
		int delPrice;

		while (true) {
			nConSearchBasket();
			System.out.print("삭제할 장바구니 번호 입력 : ");
			String temp = scanner.nextLine();
			try {
				delNum = Integer.parseInt(temp) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력이 숫자 형식이 아닙니다. 다시 입력해주세요!");
			}
		}

		if (delNum < 0) {
			System.out.println("해당 번호는 잘못된 형식의 번호입니다. 1 이상의 번호를 입력해주세요");
			return;
		}

		if (nonConBasket[delNum] == null) {
			System.out.println("해당 번호는 없는 상품의 번호입니다. 다시 시도해주세요.");
			return;
		}
		delPrice = nonConBasket[delNum].price;
		nonConBasket[delNum] = null;

		for (int i = delNum; i < this.nConBasketNum - 1; i++) {
			nonConBasket[i] = nonConBasket[i + 1];
		}
		nonConBasket[this.nConBasketNum - 1] = null;

		System.out.println("장바구니를 삭제했습니다.");
		this.nConFinalPrice -= delPrice;
		this.nConBasketNum -= 1;
		nConSearchBasket();
	}

	/*
	 * 비회원 장바구니 전체 삭제 메소드
	 * 메소드 정의 : 비회원의 장바구니를 전체 비우는 메소드
	 * 
	 */
	public void nConAllDelBasket() {
		if (nConBasketNum == 0) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		for (int i = 0; i < this.nConBasketNum; i++) {
			nonConBasket[i] = null;
		}

		System.out.println("장바구니를 전체 비우기했습니다.");
		this.nConBasketNum = 0;
		this.nConFinalPrice = 0;

		if (nonConBasket[0] == null) {
			return;
		}

		System.out.println("장바구니 번호 | 상품 | 개수 | 금액");
		for (int i = 0; i < nonConBasket.length; i++) {
			if (nonConBasket[i] == null) {
				break;
			}
			System.out.println((i + 1) + ". " + nonConBasket[i].product + " " + nonConBasket[i].count + " "
					+ nonConBasket[i].price + "원");
		}
		System.out.println("-------------------");
		System.out.println("총 " + nConFinalPrice + "원");
	}

	/*
	 * 구매자의 구매 메소드
	 * 메소드 정의 : 구매자의 장바구니를 기준으로 물건을 전체 구매하는 메소드
	 */
	public void conPurchase() {
		if (conBasketNum == 0) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		conSearchBasket();
		System.out.print("장바구니의 모든 물품을 구매하시겠습니까? (y/n) : ");
		String temp = scanner.nextLine();
		System.out.println();

		if (temp.equals("y")) {
			System.out.println("구매를 진행합니다.");

			// 구매를 진행하게 되면 생선된 구매 객체에 구매자의 최종 가격, 목적지, 연락처를 삽입
			purchase.purchasePrice = this.conFinalPrice;
			purchase.deliveryDest = this.consumer.deliveryDest;
			purchase.contectInfo = this.consumer.contectInfo;

			System.out.println(purchase.deliveryDest + "(으)로 배송해드리겠습니다. 감사합니다!");

			// 구매 후 장바구니 비우기
			for (int i = 0; i < this.conBasketNum; i++) {
				conBasket[i] = null;
			}

			// 장바구니 번호와 구매자의 최종 가격 변수 초기화
			this.conBasketNum = 0;
			this.conFinalPrice = 0;
		} else if (temp.endsWith("n")) {
			System.out.println("구매를 취소했습니다.");
		} else {
			System.out.println("구매에 실패했습니다. 다시 시도해주세요");
		}
	}

	/*
	 * 비회원 구매 메소드
	 * 메소드 정의 : 비회원의 현재 장바구니를 기준으로 물건을 전체 구매하는 메소드
	 */
	public void nConPurchase() {
		if (nConBasketNum == 0) {
			System.out.println("장바구니에 담긴 상품이 없습니다.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		nConSearchBasket();
		System.out.print("장바구니의 모든 물품을 구매하시겠습니까? (y/n) : ");
		String temp = scanner.nextLine();
		System.out.println();

		if (temp.equals("y")) {
			System.out.println("구매를 진행합니다.");
			purchase.purchasePrice = this.nConFinalPrice;

			// 비회원은 배송지와 연락처 입력 받기
			System.out.println("배송지를 입력해주세요.");
			System.out.print("배송지 : ");
			temp = scanner.nextLine();
			purchase.deliveryDest = temp;

			System.out.println("연락처를 입력해주세요.");
			System.out.print("연락처 (000-0000-0000) : ");
			temp = scanner.nextLine();
			purchase.contectInfo = temp;

			System.out.println(purchase.deliveryDest + "(으)로 배송해드리겠습니다. 감사합니다!");

			// 비회원의 장바구니 초기화
			for (int i = 0; i < this.nConBasketNum; i++) {
				nonConBasket[i] = null;
			}

			// 장바구니 번호, 최종 가격 초기화
			this.nConBasketNum = 0;
			this.nConFinalPrice = 0;
		} else if (temp.endsWith("n")) {
			System.out.println("구매를 취소했습니다.");
		} else {
			System.out.println("구매에 실패했습니다. 다시 시도해주세요");
		}
	}
}
