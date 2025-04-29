package theater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FuncImplementation extends Thread implements ReservationFuncInterface{
	public static final String adminID = "admin";
	public static final String adminPW = "1q2w3e4r";

	@Override
	public void movieFileUpload(ArrayList<Movie> mvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/movieTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.movieField = s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int movieNum = Integer.parseInt(tokens[0]);
				String movieName = tokens[1];
				String releaseDate = tokens[2];
				int reservationCount = Integer.parseInt(tokens[3]);
				
				Movie movie = new Movie(movieNum, movieName, releaseDate, reservationCount);
				mvList.add(movie);
				
			}
			System.out.println("정상적으로 영화 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("영화 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void movieFileSave(ArrayList<Movie> mvList, Scanner s) {
		char yn = PatternInspection(s, "현재까지 업데이트된 내용을 저장하시겠습니까?(y/n) : ", "^[y|Y|n|N]$").charAt(0);
		if(yn == 'y' || yn == 'Y'){
			FileOutputStream fo = null;
			try {
				fo = new FileOutputStream("tableFile/movieTable.txt");
			} catch (FileNotFoundException e) {
				System.out.println("영화 파일 저장 실패했습니다.");
				e.printStackTrace();
			}
			PrintStream ps = new PrintStream(fo);
			
			ps.printf("%s\n", MovieReservationSystem.movieField);
			
			for(Movie data : mvList) {
				ps.printf("%d,%s,%s,%d\n", data.getMovieNum(), data.getMovieName(), data.getReleaseDate(), data.getReservationCount());
			}
			
			ps.close();
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("---영화 파일 저장 완료---");
		}else{
			System.out.println("업데이트된된 내용을 저장하지 않았습니다.");
		}

	}

	@Override
	public void reservationFileUpload(ArrayList<Reservation> rsvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reservationInfoTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.reservationField = s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				String phoneNum = tokens[0];
				String userName = tokens[1];
				String movieName = tokens[2];
				int seatNum = Integer.parseInt(tokens[3]);
				
				Reservation reservation = new Reservation(phoneNum, userName, movieName, seatNum);
				
				rsvList.add(reservation);
				
			}
			System.out.println("정상적으로 예매 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("예매 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reservationFileSave(ArrayList<Reservation> rsvList, Scanner s) {
		char yn = PatternInspection(s, "현재까지 업데이트된 내용을 저장하시겠습니까?(y/n) : ", "^[y|Y|n|N]$").charAt(0);
		if(yn == 'y' || yn == 'Y'){
			FileOutputStream fo = null;
			try {
				fo = new FileOutputStream("tableFile/reservationInfoTable.txt");
			} catch (FileNotFoundException e) {
				System.out.println("예매 파일 저장 실패했습니다.");
				e.printStackTrace();
			}
			PrintStream ps = new PrintStream(fo);
			
			ps.printf("%s\n", MovieReservationSystem.reservationField);
			
			for(Reservation data : rsvList) {
				ps.printf("%s,%s,%s,%d\n", data.getPhoneNum(), data.getUserName(), data.getMovieName(), data.getSeatNum());
			}
			
			ps.close();
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("---예매 파일 저장 완료---");
		}else{
			System.out.println("업데이트된된 내용을 저장하지 않았습니다.");
		}
	}

	@Override
	public void reviewFileUpload(ArrayList<Review> rvList) {
		FileInputStream fi;
		try {
			fi = new FileInputStream("tableFile/reviewTable.txt");
			Scanner s = new Scanner(fi);
			
			// 첫라인 저장
			if(s.hasNextLine()) {
				MovieReservationSystem.reviewField = s.nextLine();
			}
			while(true) {
				if(!s.hasNextLine()) {
					break;
				}
				String[] tokens = s.nextLine().split(",");
				int reviewNum = Integer.parseInt(tokens[0]);
				int movieNum = Integer.parseInt(tokens[1]);
				double reviewRate = Double.parseDouble(tokens[2]);
				String comment = tokens[3];
				
				Review review = new Review(reviewNum, movieNum, reviewRate, comment);
				
				rvList.add(review);
				
			}
			System.out.println("정상적으로 리뷰 파일을 로드했습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("리뷰 파일 업로드가 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public void reviewFileSave(ArrayList<Review> rvList, Scanner s) {
		char yn = PatternInspection(s, "현재까지 업데이트된 내용을 저장하시겠습니까?(y/n) : ", "^[y|Y|n|N]$").charAt(0);
		if(yn == 'y' || yn == 'Y'){
			FileOutputStream fo = null;
			try {
				fo = new FileOutputStream("tableFile/reviewTable.txt");
			} catch (FileNotFoundException e) {
				System.out.println("리뷰 파일 저장 실패했습니다.");
				e.printStackTrace();
			}
			PrintStream ps = new PrintStream(fo);
			
			ps.printf("%s\n", MovieReservationSystem.reviewField);
			
			for(Review data : rvList) {
				ps.printf("%d,%d,%.1f,%s\n", data.getReviewNum(), data.getMovieNum(), data.getReviewRate(), data.getComment());
			}
			
			ps.close();
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("---리뷰 파일 저장 완료---");
		}else{
			System.out.println("업데이트된된 내용을 저장하지 않았습니다.");
		}
	}
	
	@Override
	public int adminLogon(int no, Scanner s) {
		if(no == 1){
			do{
				System.out.print("Admin ID : ");
				String id = s.nextLine();
				System.out.print("Password : ");
				String pw = s.nextLine();

				if(id.equals(adminID) && pw.equals(adminPW)){
					break;
				}
				System.out.println("관리자 계정 정보를 확인해주세요.");
			}while(true);
		}
		return no;
	}

	@Override
	public void movieAdd(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 등록---");
		
		int max = Integer.MIN_VALUE;
		for(Movie data : mvList) {
			if(max < data.getMovieNum()) {
				max = data.getMovieNum();
			}
		}
		int movieNum = max+1;
		
		String movieName = PatternInspection(s, "등록할 영화 이름 : ", "^[가-힣a-zA-Z0-9\\s]{1,30}$");
		String releaseDate = PatternInspection(s, "등록할 영화 개봉일 : ", "\\d{4}-\\d{2}-\\d{2}");
		Movie movie = new Movie(movieNum, movieName, releaseDate, 0);
		mvList.add(movie);
		System.out.println("영화가 등록되었습니다.");
	}

	@Override
	public void movieModify(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 수정---");
		
		String search = PatternInspection(s, "수정할 영화 검색(제목) : ", "(?u)^[\\uAC00-\\uD7A3a-zA-Z0-9\\s]{1,30}$");
		Movie modifyMovie = null;
		for(Movie data : mvList) {
			if(data.getMovieName().equals(search)) {
				modifyMovie = data;
				break;
			}
		}
		if(modifyMovie == null) {
			System.out.printf("%s 는 존재하지 않습니다.\n", search);
			return;
		}
		
		String movieName = PatternInspection(s, "수정할 제목 : ", "(?u)^[\\uAC00-\\uD7A3a-zA-Z0-9\\s]{1,30}$");
		String releaseDate = PatternInspection(s, "수정할 개봉일 : ", "\\d{4}-\\d{2}-\\d{2}");
		
		modifyMovie.setMovieName(movieName);
		modifyMovie.setReleaseDate(releaseDate);
		
		System.out.printf("%s 영화 정보 수정 완료.\n", search);
	}

	@Override
	public void movieRemove(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---영화 삭제---");
		
		String search = PatternInspection(s, "삭제할 영화 검색(제목) : ", "(?u)^[\\uAC00-\\uD7A3a-zA-Z0-9\\s]{1,30}$");
		Movie removeMovie = null;
		for(Movie data : mvList) {
			if(data.getMovieName().equals(search)) {
				removeMovie = data;
				break;
			}
		}
		if(removeMovie == null) {
			System.out.printf("%s 는 존재하지 않습니다.\n", search);
			return;
		}
		
		mvList.remove(removeMovie);
		
		System.out.printf("%s 영화 정보 삭제 완료.\n", search);
	}

	@Override
	public void movieList(ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---개봉 영화 확인---");
		
		int page = 1;
		while(true) {
			clear();
			// 전체 페이지를 구한다
			int totalPage = mvList.size() / 10;
			int remainValue = mvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(mvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^\\d{1,2}$|^-1"));
		
			if(page == -1) {
				break;
			}
			if(page > totalPage){
				System.out.println("전체 Page수 범위에서 입력하세요.");
				page = 1;
				continue;
			}
		}
		
	}

	@Override
	public void reservationAsc(ArrayList<Movie> mvList, Scanner s) {
		Collections.sort(mvList);
		System.out.println("---오름차순 정렬 완료---");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int page = 1;
		while(true) {
			clear();
			// 전체 페이지를 구한다
			int totalPage = mvList.size() / 10;
			int remainValue = mvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(mvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^\\d{1,2}$|^-1"));
		
			if(page == -1) {
				break;
			}
			if(page > totalPage){
				System.out.println("전체 Page수 범위에서 입력하세요.");
				page = 1;
				continue;
			}
		}
	}

	@Override
	public void reservationDesc(ArrayList<Movie> mvList, Scanner s) {
		Collections.sort(mvList, Collections.reverseOrder());
		System.out.println("---내림차순 정렬 완료---");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int page = 1;
		while(true) {
			clear();
			// 전체 페이지를 구한다
			int totalPage = mvList.size() / 10;
			int remainValue = mvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(mvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^\\d{1,2}$|^-1"));
		
			if(page == -1) {
				break;
			}
			if(page > totalPage){
				System.out.println("전체 Page수 범위에서 입력하세요.");
				page = 1;
				continue;
			}
		}
	}

	@Override
	public void reservationMax(ArrayList<Movie> mvList) {
		int max = Integer.MIN_VALUE;
		Movie movie = null;
		for(Movie data : mvList) {
			if(data.getReservationCount() > max) {
				max = data.getReservationCount();
				movie = data;
			}
		}
		System.out.println("가장 예매율이 높은 영화는 " + movie.getMovieName() + " / " + max + "입니다.");
	}

	@Override
	public void reservationMin(ArrayList<Movie> mvList) {
		int min = Integer.MAX_VALUE;
		Movie movie = null;
		for(Movie data : mvList) {
			if(data.getReservationCount() < min) {
				min = data.getReservationCount();
				movie = data;
			}
		}
		System.out.println("가장 예매율이 낮은 영화는 " + movie.getMovieName() + " / " + min + "입니다.");
	}

	@Override
	public void reservationAdd(ArrayList<Reservation> rsvList, Scanner s) {
		System.out.println("---예매 신청---");
		Reservation reservation = null;

		String name = PatternInspection(s, "예매자 이름 : ","^[가-힣A-Za-z]{1,20}$");
		String phoneNum = PatternInspection(s, "휴대폰 번호 : ", "^(01[016789])-\\d{3,4}-\\d{4}$");
		String movieName = PatternInspection(s, "영화 제목 : ", "[가-힣A-Za-z0-9]{1,30}$");
		int seatNum = 0;
		do{
			// for(int i = 0 ; i < 50 ; i++){
			// 	for(Reservation data : rsvList){
			// 		if(movieName.equals(data.getMovieName()) && (i+1) == data.getSeatNum()){
			// 			System.out.printf("[%3s]", "-");
			// 		}else{
			// 			System.out.printf("[%3d]", i+1);
			// 		}
			// 	}
			// 	if((i+1)%10 == 0) {
			// 		System.out.println();
			// 	}
			// }

			seatNum = Integer.parseInt(PatternInspection(s, "좌석 선택 : ", "^[0-9]{1,2}$"));
			for(Reservation data : rsvList){
				if(movieName.equals(data.getMovieName()) && seatNum == data.getSeatNum()){
					System.out.println("이미 예매된 좌석입니다.");
					seatNum = 0;
					continue;
				}
			}
			if(seatNum != 0){
				break;
			}
		}while(true);

		reservation = new Reservation(phoneNum, name, movieName, seatNum);
		rsvList.add(reservation);
	}

	@Override
	public void reservationCancle(ArrayList<Reservation> rsvList, Scanner s) {
		System.out.println("---예매 취소---");
		String canclePhoneNum = PatternInspection(s, "예매 휴대폰 번호 : ", "^(01[016789])-\\d{3,4}-\\d{4}$");
		Reservation imsiRsv = null;

		for(Reservation data : rsvList){
			if(data.getPhoneNum().equals(canclePhoneNum)){
				System.out.println("예매 정보 : " + data);
				imsiRsv = data;
				break;
			}
		}
		if(imsiRsv == null){
			System.out.println(canclePhoneNum + "으로 검색된 예매 정보는 없습니다.");
		}else{
			char yn = PatternInspection(s, "검색된 예매 정보를 삭제하시겠습니까?(y/n) : ", "^[y|n|Y|N]$").charAt(0);
			if(yn == 'y' || yn == 'Y'){
				rsvList.remove(imsiRsv);
				System.out.println("정상적으로 예매 취소되었습니다.");
			}else{
				System.out.println("예매 취소를 하지 않았습니다.");
			}
		}
	}

	@Override
	public void reservationCheck(ArrayList<Reservation> rsvList, Scanner s) {
		int page = 1;
		while(true) {
			clear();
			// 전체 페이지를 구한다
			int totalPage = rsvList.size() / 10;
			int remainValue = rsvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(rsvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^\\d{1,2}$|^-1"));

			if(page == -1) {
				break;
			}
			if(page > totalPage){
				System.out.println("전체 Page수 범위에서 입력하세요.");
				page = 1;
				continue;
			}
		}
	}

	@Override
	public void reservationModify(ArrayList<Reservation> rsvList, Scanner s) {
		System.out.println("---예매 수정---");
		String canclePhoneNum = PatternInspection(s, "예매 휴대폰 번호 : ", "^(01[016789])-\\d{3,4}-\\d{4}$");
		Reservation imsiRsv = null;

		for(Reservation data : rsvList){
			if(data.getPhoneNum().equals(canclePhoneNum)){
				System.out.println("예매 정보 : " + data);
				imsiRsv = data;
				break;
			}
		}
		if(imsiRsv == null){
			System.out.println(canclePhoneNum + "으로 검색된 예매 정보는 없습니다.");
		}else{
			String name = PatternInspection(s, "수정할 예매자 이름 : ","^[가-힣A-Za-z]{1,20}$");
			String phoneNum = PatternInspection(s, "수정할 휴대폰 번호 : ", "^(01[016789])-\\d{3,4}-\\d{4}$");
			String movieName = PatternInspection(s, "수정할 영화 제목 : ", "[가-힣A-Za-z0-9]{1,30}$");
			int seatNum = 0;
			do{
				// for(int i = 0 ; i < 50 ; i++){
				// 	System.out.printf("%-5d", i+1);
				// 	for(Reservation data : rsvList){
				// 		if(movieName.equals(data.getMovieName()) && (i+1) == data.getSeatNum()){
				// 			System.out.printf("%5s", "[-]");
				// 		}else{
				// 			System.out.printf("%5s", "[ ]");
				// 		}
				// 	}
				// 	System.out.printf("");
				// 	if((i+1)%10 == 0) {
				// 		System.out.println();
				// 	}
				// }

				seatNum = Integer.parseInt(PatternInspection(s, "수정할 좌석 선택 : ", "^[0-9]{1,2}$"));
				for(Reservation data : rsvList){
					if(movieName.equals(data.getMovieName()) && seatNum == data.getSeatNum()){
						System.out.println("이미 예매된 좌석입니다.");
						seatNum = 0;
						continue;
					}
				}
				if(seatNum != 0){
					break;
				}
			}while(true);

			imsiRsv.setPhoneNum(phoneNum);
			imsiRsv.setUserName(name);
			imsiRsv.setMovieName(movieName);
			imsiRsv.setSeatNum(seatNum);
			System.out.println("예매 수정이 완료되었습니다.");
		}
	}

	@Override
	public void movieReservationCountUpdate(ArrayList<Reservation> rsvList, ArrayList<Movie> mvList,Scanner s){
		// movieTable의 reservationCount 업데이트
		for(Movie mv : mvList){
			int count = 0;
			for(Reservation rsv : rsvList){
				if(mv.getMovieName().equals(rsv.getMovieName())){
					count++;
				}
			}
			mv.setReservationCount(count);
		}
	}

	@Override
	public void reviewWrite(ArrayList<Review> rvList, ArrayList<Movie> mvList, Scanner s) {
		System.out.println("---리뷰 작성---");
		int max = Integer.MIN_VALUE;
		for(Review data : rvList) {
			if(max < data.getReviewNum()) {
				max = data.getReviewNum();
			}
		}
		int reviewNum = max+1;
		int movieNum = Integer.parseInt(PatternInspection(s, "영화 번호 입력 : ", "^[0-9]{1,2}$"));
		boolean findMovie = false;
		for(Movie movie : mvList){
			if(movieNum == movie.getMovieNum()){
				findMovie = true;
			}
		}
		if(findMovie == true){
			double reiewRate = Double.parseDouble(PatternInspection(s, "평점 입력 : ", "\\b(?:[0-4]\\.[0-9]|5\\.0)\\b"));
			String comment = PatternInspection(s, "코멘트 입력 : ", "^[A-Za-z가-힣ㄱ-ㅎ0-9\\s]{1,100}$");
			
			Review review = new Review(reviewNum, movieNum, reiewRate, comment);
			
			rvList.add(review);
		}else{
			System.out.println("해당 번호를 가진 영화는 없습니다.");
		}
	}

	@Override
	public void reviewPrint(ArrayList<Review> rvList, Scanner s) {
		System.out.println("---리뷰 조회---");
		int page = 1;
		while(true) {
			// 전체 페이지를 구한다
			int totalPage = rvList.size() / 10;
			int remainValue = rvList.size() % 10;
			if(remainValue != 0) {
				totalPage += 1;
			}
			// 해당 페이지의 시작위치, 끝위치를 구한다.
			int first = 10 * (page - 1);
			int last = first + 10;
			// 마지막페이지에 나머지가 있을때 끝위치를 정한다.
			if(remainValue != 0 && page == totalPage) {
				last = first + remainValue;
			}
			// for문을 통해 페이지별 출력
			System.out.printf("현재 %d / 전체 %d page\n", page, totalPage);
			for(int i = first; i < last; i++) {
				System.out.println(rvList.get(i));
			}
			page = Integer.parseInt(PatternInspection(s, "Page 입력 (Exit : -1) > ", "^\\d{1,2}$|^-1"));

			if(page == -1) {
				break;
			}
			if(page > totalPage){
				System.out.println("전체 Page수 범위에서 입력하세요.");
				page = 1;
				continue;
			}
		}
	}

	@Override
	public String PatternInspection(Scanner s, String string, String regex) {
		System.out.print(string);
		String input = s.nextLine();
		if(Pattern.matches(regex, input)) {
			return input;
		}else {
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
