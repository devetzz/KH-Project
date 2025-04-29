package theater;


public class Reservation extends Movie {
	private String phoneNum;
	private String userName;
	//movieName
	private int seatNum;
	
	public Reservation() {
		this(null,null,null,0);
	}

	public Reservation(String phoneNum, String userName, String movieName, int seatNum) {
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
		return "Reservation [" + phoneNum + ", " + userName + ", " + this.getMovieName() + ", " + seatNum + "]";
	}

	
	
}
