package model;

public class ReservationVO extends MovieVO {
	private String phoneNum;
	private String userName;
	//movieName
	private int seatNum;
	
	public ReservationVO() {
		this(null,null,null,0);
	}

	public ReservationVO(String phoneNum, String userName, String movieName, int seatNum) {
		this.setMovieName(movieName);
		this.phoneNum = phoneNum;
		this.userName = userName;
		this.seatNum = seatNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return formatAlign(phoneNum, 20)
				+ formatAlign(userName, 15)
				+ formatAlign(this.getMovieName(), 30)
				+ formatAlign(seatNum, 10);
	}

	public static String formatAlign(String text, int width) {
		int displayWidth = 0;
		for (char c : text.toCharArray()) {
			// 한글은 보통 2칸으로 간주
			displayWidth += (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES) ? 2 : 1;
		}
	
		int padding = Math.max(width - displayWidth, 0);
		return text + " ".repeat(padding);
	}

	public static String formatAlign(int number, int width) {
		return formatAlign(String.valueOf(number), width);
	}
	
}
