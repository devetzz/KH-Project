package model;

public class MovieVO implements Comparable<MovieVO> {

	private int movieNum;
	private String movieName;
	private String releaseDate;
	private int reservationCount;
	
	public MovieVO() {
		this(0,null,null);
	}

	public MovieVO(int movieNum, String movieName, String releaseDate) {
		super();
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
	}

	public MovieVO(int movieNum, String movieName, String releaseDate, int reservationCount) {
		super();
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.reservationCount = reservationCount;
	}
	
	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String movieDate) {
		this.releaseDate = movieDate;
	}

	public int getReservationCount() {
		return reservationCount;
	}

	public void setReservationCount(int reservationCount) {
		this.reservationCount = reservationCount;
	}

	@Override
	public String toString() {
		return formatAlign(movieNum, 10)
			+ formatAlign(movieName, 30)
			+ formatAlign(releaseDate, 20)
			+ formatAlign(reservationCount, 10);
	}
	
	@Override
	public int compareTo(MovieVO o) {
		// 부모 영역에 자식이 있는지 확인
		MovieVO movie = null;
		if(o instanceof MovieVO) {
			movie = (MovieVO)o;
		}
		if(this.reservationCount> movie.getReservationCount()) {
			return 1;
		}else if (this.reservationCount < movie.getReservationCount()) {
			return -1;
		}else {
			return 0;
		}
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
