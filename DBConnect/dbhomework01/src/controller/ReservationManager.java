package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.ReservationVO;

public class ReservationManager {
	public static Scanner s = new Scanner(System.in);
    // 예약 리스트
    public void list(Scanner s) throws Exception{
        ReservationDAO rsd = new ReservationDAO();
        System.out.println("예약 전체 리스트");
        ArrayList<ReservationVO> rsvList = null; 
		rsvList = rsd.selectAll();
		if(rsvList == null) {
			System.out.println("예약 전체 리스트 에러발생");
			System.out.println("계속하려면 엔터를 입력하세요.");
			s.nextLine();
			return;
		}else if(rsvList.size() == 0) {
			System.out.println("예약 전체 리스트 내용이 없습니다.");
			System.out.println("계속하려면 엔터를 입력하세요.");
			s.nextLine();
			return;
		}
		for( ReservationVO data : rsvList) {
			System.out.println(data.toString());
		}
		System.out.println("계속하려면 엔터를 입력하세요.");
		s.nextLine();
    }

    // 예약 등록
    public void register(Scanner s) throws Exception {

		ReservationDAO rsd = new ReservationDAO();
		ReservationVO rsvo = new ReservationVO();

		String phoneNum; // 예약자 핸드폰 번호
		String userName; // 예약자명
		String movieName; // 영화명
		int seatNum; // 좌석번호
		
		System.out.println("예약 정보 입력");
		System.out.print("예약자 핸드폰 번호 : ");
		phoneNum = s.nextLine();
		System.out.print("예약자명 : ");
		userName = s.nextLine();
		System.out.print("영화 제목 : ");
		movieName = s.nextLine();
		System.out.print("좌석번호 : ");
		seatNum = Integer.parseInt(s.nextLine());

		rsvo.setPhoneNum(phoneNum);
		rsvo.setUserName(userName);
		rsvo.setMovieName(movieName);
		rsvo.setSeatNum(seatNum);

		rsd.insert(rsvo); 

		System.out.println();
		list(s);
		System.out.println();
	}
    // 예약 수정
    public void update(Scanner s) throws Exception {

		ReservationDAO rsd = new ReservationDAO();
		ReservationVO rsvo = new ReservationVO();

		String findNum; // 검색할 번호
		String phoneNum; // 예약자 핸드폰 번호
		String userName; // 예약자명
		String movieName; // 영화명
		int seatNum; // 좌석번호
		

		System.out.println("예약 전체 리스트");
		list(s); 
		System.out.println();

		System.out.println("수정할 예약자 핸드폰 번호 입력");
		System.out.print("핸드폰 번호 : ");
		findNum = s.nextLine();

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("핸드폰 번호 : ");
		phoneNum = s.nextLine();
		System.out.print("사용자명 : ");
		userName = s.nextLine();
		System.out.print("영화 이름 : ");
		movieName = s.nextLine();
		System.out.print("좌석 번호 : ");
		seatNum = Integer.parseInt(s.nextLine());
		
		rsvo.setPhoneNum(phoneNum);
		rsvo.setUserName(userName);
		rsvo.setMovieName(movieName);
		rsvo.setSeatNum(seatNum);
		int count = rsd.update(rsvo, findNum);
		
		if(count == 0) {
			System.out.println("영화 정보 수정 오류발생");
			return; 
		}else {
			System.out.println("영화 정보 수정완료");
		}
		
		System.out.println();
		list(s); 
		System.out.println();
	}
    // 예약 삭제
    public void delete(Scanner s) throws Exception {

		ReservationDAO rsd = new ReservationDAO();
		ReservationVO rsvo = new ReservationVO();

		String phoneNum; // 핸드폰 번호
		list(s);
		System.out.println();

		System.out.println("예약 취소할 핸드폰 번호 입력");
		System.out.print("핸드폰 번호 : ");
		phoneNum = s.nextLine();
		rsvo.setPhoneNum(phoneNum);
		int count = rsd.deleteByPhoneNum(rsvo);
		if(count == 0) {
			System.out.printf("%s 번호 삭제 문제발생\n", phoneNum);
		}else {
			System.out.printf("%s 번호 삭제성공\n", phoneNum);
		}
		System.out.println();
		list(s);
		System.out.println();
	}
}
