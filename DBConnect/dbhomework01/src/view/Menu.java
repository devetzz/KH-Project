package view;

public interface Menu {
	// 사용자 메뉴
	public static final int ADMIN = 1;
	public static final int USER = 2;
	public static final int USEREXIT = 5;
	
	// 최상위 메뉴
	public static final int MANAGEMENT = 0;
	public static final int MOVIELIST = 1;
	public static final int MOVIERANK = 2;
	public static final int MOVIERESERVATION = 3;
	public static final int MOVIEREVIEW = 4;
	public static final int EXIT = 5;
	// 관리 메뉴
	public static final int MOVIEADD = 1;
	public static final int MOVIEMODIFY = 2;
	public static final int MOVIEREMOVE = 3;
	public static final int MANAGEEXIT = 5;
	// 순위 메뉴
	public static final int ACS = 1;
	public static final int DESC = 2;
	public static final int MAX = 3;
	public static final int MIN = 4;
	public static final int RANKEXIT = 5;
	// 예매 메뉴
	public static final int RESERVATIONADD = 1;
	public static final int RESERVATIONREMOVE = 2;
	public static final int RESERVATIONPRINT = 3;
	public static final int RESERVATIONMODIFY = 4;
	public static final int RESERVATIONEXIT = 5;
	// 리뷰 메뉴
	public static final int REVIEWADD = 1;
	public static final int REVIEWPRINT = 2;
	public static final int REVIEWEXIT = 5;

	
	public static void userSelectMenuPrint() {
		// 사용자 선택 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━ Select Mode ━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t\t", "1. 관리자");
		System.out.printf("%s\t\t", "2. 사용자");
		System.out.printf("%s\n", "5. 종료");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public static void adminMenuPrint() {
		// admin 최상위 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Admin MENU ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "0. 영화 관리");
		System.out.printf("%s\t", "1. 개봉 영화 확인");
		System.out.printf("%s\t", "2. 영화 순위");
		System.out.printf("%s\t", "3. 영화 예매");
		System.out.printf("%s\t", "4. 영화 리뷰");
		System.out.printf("%s\n", "5. 로그아웃");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public static void userMenuPrint() {
		// user 최상위 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ User MENU ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "1. 개봉 영화 확인");
		System.out.printf("%s\t", "2. 영화 순위");
		System.out.printf("%s\t", "3. 영화 예매");
		System.out.printf("%s\t", "4. 영화 리뷰");
		System.out.printf("%s\n", "5. 로그아웃");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	
	public static void manageMenuPrint() {
		// 관리 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 영화 관리 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "1. 영화 등록");
		System.out.printf("%s\t", "2. 영화 수정");
		System.out.printf("%s\t", "3. 영화 삭제");
		System.out.printf("%s\n", "5. 처음으로");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	public static void rankMenuPrint() {
		// 순위 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 랭킹 ━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "1. 예매율 낮은 순 정렬");
		System.out.printf("%s\t\n", "2. 예매율 높은 순 정렬");
		System.out.printf("%s\t", "3. 예매 순위 Top");
		System.out.printf("%s\t", "4. 예매 순위 Lowest");
		System.out.printf("%s\n", "5. 처음으로");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	public static void reservationMenuPrint() {
		// 예매 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 예매 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "1. 예매 신청");
		System.out.printf("%s\t", "2. 예매 취소");
		System.out.printf("%s\t", "3. 예매 내역 확인");
		System.out.printf("%s\t", "4. 예매 수정");
		System.out.printf("%s\n", "5. 처음으로");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	public static void reviewMenuPrint() {
		// 리뷰 메뉴
		System.out.println("━━━━━━━━━━━━━━━━━━━━━ 리뷰 ━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("%s\t", "1. 리뷰 작성");
		System.out.printf("%s\t", "2. 리뷰 조회");
		System.out.printf("%s\n", "5. 처음으로");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
}
