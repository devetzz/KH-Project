package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.ReviewVO;

public class ReviewManager {
	public static Scanner s = new Scanner(System.in);
    // 리뷰 리스트
    public void list(Scanner s) throws Exception{
        ReviewDAO rd = new ReviewDAO();
        System.out.println("리뷰 전체 리스트");
        ArrayList<ReviewVO> rvList = null; 
		rvList = rd.selectAll();
		if(rvList == null) {
			System.out.println("리뷰 전체 리스트 에러발생");
			System.out.println("계속하려면 엔터를 입력하세요.");
			s.nextLine();
			return;
		}else if(rvList.size() == 0) {
			System.out.println("리뷰 전체 리스트 내용이 없습니다.");
			System.out.println("계속하려면 엔터를 입력하세요.");
			s.nextLine();
			return;
		}
		for( ReviewVO data : rvList) {
			System.out.println(data.toString());
		}
		System.out.println("계속하려면 엔터를 입력하세요.");
		s.nextLine();
    }

    // 리뷰 등록
    public void register(Scanner s) throws Exception {

		ReviewDAO rd = new ReviewDAO();
		ReviewVO rvo = new ReviewVO();

		String movieName; // 영화 제목
		double reviewRate; // 리뷰 점수
		String comment; // 코멘트
		
		System.out.println("예약 정보 입력");
		System.out.print("영화 제목 : ");
		movieName = s.nextLine();
		System.out.print("리뷰 점수 : ");
		reviewRate = Double.parseDouble(s.nextLine());
		System.out.print("코멘트 : ");
		comment = s.nextLine();

		rvo.setMovieName(movieName);
		rvo.setReviewRate(reviewRate);
		rvo.setComment(comment);

		rd.insert(rvo);

		System.out.println();
		list(s);
		System.out.println();
	}
    // 리뷰 수정
    public void update(Scanner s) throws Exception {

		ReviewDAO rd = new ReviewDAO();
		ReviewVO rvo = new ReviewVO();

		String movieName; // 영화 제목
		double reviewRate; // 리뷰 점수
		String comment;	// 코멘트
		int reviewNum; // 리뷰 번호
		

		System.out.println("리뷰 전체 리스트");
		list(s); 
		System.out.println();

		System.out.println("수정할 리뷰 번호 입력");
		System.out.print("리뷰 번호 : ");
		reviewNum = Integer.parseInt(s.nextLine());

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("영화 제목 : ");
		movieName = s.nextLine();
		System.out.print("리뷰 점수 : ");
		reviewRate = Double.parseDouble(s.nextLine());
		System.out.print("코멘트 : ");
		comment = s.nextLine();
		
		rvo.setReviewNum(reviewNum);
		rvo.setMovieName(movieName);
		rvo.setReviewRate(reviewRate);
		rvo.setComment(comment);
		int count = rd.update(rvo);
		
		if(count == 0) {
			System.out.println("리뷰 정보 수정 오류발생");
			return; 
		}else {
			System.out.println("리뷰 정보 수정완료");
		}
		
		System.out.println();
		list(s); 
		System.out.println();
	}
    // 리뷰 삭제
    public void delete(Scanner s) throws Exception {

		ReviewDAO rd = new ReviewDAO();
		ReviewVO rvo = new ReviewVO();

		int reviewNum; // 리뷰 번호
		list(s);
		System.out.println();

		System.out.println("삭제할 리뷰 번호 입력");
		System.out.print("리뷰 번호 : ");
		reviewNum = Integer.parseInt(s.nextLine());
		rvo.setReviewNum(reviewNum);
		int count = rd.deleteByReviewNum(rvo);
		if(count == 0) {
			System.out.printf("%s 번호 삭제 문제발생\n", reviewNum);
		}else {
			System.out.printf("%s 번호 삭제성공\n", reviewNum);
		}
		System.out.println();
		list(s);
		System.out.println();
	}
}
