package theater;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MovieReservationSystem extends Thread {

	public static String movieField;
	public static String reservationField;
	public static String reviewField;
	
	public static void main(String[] args) throws InterruptedException {
		// 변수 선언
		boolean stopFlag = false;
		boolean adminStop = false;
		boolean userStop = false;
		Scanner s = new Scanner(System.in);
		ArrayList<Movie> mvList = new ArrayList<>();
		ArrayList<Reservation> rsvList = new ArrayList<>();
		ArrayList<Review> rvList = new ArrayList<>();

		ReservationFuncInterface func = new FuncImplementation();
		func.movieFileUpload(mvList);
		func.reservationFileUpload(rsvList);
		func.reviewFileUpload(rvList);

		// 반복문(입력, 출력, 종료)
		while (!stopFlag) {
			// 사용자 선택 메뉴
			clear();
			Menu.userSelectMenuPrint();
			int no = Integer.parseInt(PatternInspection(s, "사용자 선택 > ", "^[1-5]{1}$"));

			func.adminLogon(no, s);

			switch (no) {
				case Menu.ADMIN:
					while (!adminStop) {
						// 관리자 메뉴
						clear();
						Menu.adminMenuPrint();
						int adminNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[0,1,2,3,4,5]{1}$"));
						switch (adminNo) {
							case Menu.MANAGEMENT:
								while (true) {
									// 관리 메뉴
									clear();
									Menu.manageMenuPrint();
									int manageNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,3,5]{1}$"));
									switch (manageNo) {
										case Menu.MOVIEADD:
											clear();
											func.movieAdd(mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.MOVIEMODIFY:
											clear();
											func.movieModify(mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.MOVIEREMOVE:
											clear();
											func.movieRemove(mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.MANAGEEXIT:
											func.movieFileSave(mvList, s);
											break;
									}// manage switch
									if (manageNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIELIST:
								clear();
								// 개봉 영화 확인
								func.movieList(mvList, s);
								break;
							case Menu.MOVIERANK:
								while (true) {
									clear();
									// 순위 메뉴
									Menu.rankMenuPrint();
									int rankNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));

									switch (rankNo) {
										case Menu.ACS:
											clear();
											func.reservationAsc(mvList, s);
											break;
										case Menu.DESC:
											clear();
											func.reservationDesc(mvList, s);
											break;
										case Menu.MAX:
											// clear();
											func.reservationMax(mvList);
											Thread.sleep(2000);
											break;
										case Menu.MIN:
											// clear();
											func.reservationMin(mvList);
											Thread.sleep(2000);
											break;
										case Menu.RANKEXIT:
											break;
									}// rank switch
									if (rankNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIERESERVATION:
								while (true) {
									// 예매 메뉴
									clear();
									Menu.reservationMenuPrint();
									int reservationNo = Integer
											.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));

									switch (reservationNo) {
										case Menu.RESERVATIONADD:
											clear();
											func.reservationAdd(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONREMOVE:
											clear();
											func.reservationCancle(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONPRINT:
											func.reservationCheck(rsvList, s);
											break;
										case Menu.RESERVATIONMODIFY:
											clear();
											func.reservationModify(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONEXIT:
											func.movieReservationCountUpdate(rsvList, mvList, s);
											func.reservationFileSave(rsvList, s);
											func.movieFileSave(mvList, s);
											break;
									}// reservation switch
									if (reservationNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIEREVIEW:
								while (true) {
									// 리뷰 메뉴
									clear();
									Menu.reviewMenuPrint();
									int reviewNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,5]{1}$"));

									switch (reviewNo) {
										case Menu.REVIEWADD:
											clear();
											func.reviewWrite(rvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.REVIEWPRINT:
											func.reviewPrint(rvList, s);
											break;
										case Menu.REVIEWEXIT:
											func.reviewFileSave(rvList, s);
											break;
									}// review switch
									if (reviewNo == 5) {
										break;
									}
								}
								break;
							case Menu.EXIT:
								adminStop = true;
								System.out.println("(관리자)정상적으로 로그아웃 되었습니다.");
								Thread.sleep(2000);
								break;
						}// 2nd admin switch
					}// admin while
					break;



				case Menu.USER:
					while(!userStop){
						// 사용자 메뉴
						clear();
						Menu.userMenuPrint();
						int userNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[0,1,2,3,4,5]{1}$"));
						switch (userNo) {
							case Menu.MOVIELIST:
								clear();
								// 개봉 영화 확인
								func.movieList(mvList, s);
								break;
							case Menu.MOVIERANK:
								while (true) {
									clear();
									// 순위 메뉴
									Menu.rankMenuPrint();
									int rankNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));
	
									switch (rankNo) {
										case Menu.ACS:
											clear();
											func.reservationAsc(mvList, s);
											break;
										case Menu.DESC:
											clear();
											func.reservationDesc(mvList, s);
											break;
										case Menu.MAX:
											clear();
											func.reservationMax(mvList);
											Thread.sleep(2000);
											break;
										case Menu.MIN:
											clear();
											func.reservationMin(mvList);
											Thread.sleep(2000);
											break;
										case Menu.RANKEXIT:
											break;
									}// rank switch
									if (rankNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIERESERVATION:
								while (true) {
									clear();
									// 예매 메뉴
									Menu.reservationMenuPrint();
									int reservationNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1-5]{1}$"));
	
									switch (reservationNo) {
										case Menu.RESERVATIONADD:
											clear();
											func.reservationAdd(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONREMOVE:
											clear();
											func.reservationCancle(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONPRINT:
											clear();
											func.reservationCheck(rsvList, s);
											break;
										case Menu.RESERVATIONMODIFY:
											clear();
											func.reservationModify(rsvList, s);
											Thread.sleep(3000);
											break;
										case Menu.RESERVATIONEXIT:
											func.movieReservationCountUpdate(rsvList, mvList, s);
											func.reservationFileSave(rsvList, s);
											func.movieFileSave(mvList, s);
											break;
									}// reservation switch
									if (reservationNo == 5) {
										break;
									}
								}
								break;
							case Menu.MOVIEREVIEW:
								while (true) {
									clear();
									// 리뷰 메뉴
									Menu.reviewMenuPrint();
									int reviewNo = Integer.parseInt(PatternInspection(s, "메뉴 입력 > ", "^[1,2,5]{1}$"));
	
									switch (reviewNo) {
										case Menu.REVIEWADD:
											clear();
											func.reviewWrite(rvList, mvList, s);
											Thread.sleep(3000);
											break;
										case Menu.REVIEWPRINT:
											clear();
											func.reviewPrint(rvList, s);
											break;
										case Menu.REVIEWEXIT:
											func.reviewFileSave(rvList, s);
											break;
									}// review switch
									if (reviewNo == 5) {
										break;
									}
								}
								break;
							case Menu.EXIT:
								userStop = true;
								System.out.println("(사용자)정상적으로 로그아웃 되었습니다.");
								Thread.sleep(2000);
								break;
						}// 2nd user switch
					}// user while
					break;
					
				case Menu.USEREXIT:
					stopFlag = true;
					System.out.println("정상적으로 종료되었습니다.");
					break;
			}// 1st switch
		} // while
	}// main

	private static String PatternInspection(Scanner s, String string, String regex) {
		System.out.print(string);
		String input = s.nextLine();
		if (Pattern.matches(regex, input)) {
			return input;
		} else {
			System.out.println("유효한 값을 입력해주세요.");
			return PatternInspection(s, string, regex);
		}
	}

	// clear 함수
	public static void clear() {
		try {
			String operatingSystem = System.getProperty("os.name");
			if (operatingSystem.contains("Windows")) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			} else {
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
