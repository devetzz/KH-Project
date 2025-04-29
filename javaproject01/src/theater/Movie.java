package theater;

public class Movie implements Comparable<Movie> {

	private int movieNum;
	private String movieName;
	private String releaseDate;
	private int reservationCount;
	
	public Movie() {
		this(0,null,null);
	}

	public Movie(int movieNum, String movieName, String releaseDate) {
		super();
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
	}

	public Movie(int movieNum, String movieName, String releaseDate, int reservationCount) {
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
		return "Movie [" + movieNum + ", " + movieName + ", " + releaseDate + ", " + reservationCount + "]";
	}
	
	@Override
	public int compareTo(Movie o) {
		// 부모 영역에 자식이 있는지 확인
		Movie movie = null;
		if(o instanceof Movie) {
			movie = (Movie)o;
		}
		if(this.reservationCount> movie.getReservationCount()) {
			return 1;
		}else if (this.reservationCount < movie.getReservationCount()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
