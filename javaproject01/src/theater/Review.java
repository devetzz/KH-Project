package theater;

public class Review extends Movie{
	private int reviewNum;
	// movieNum
	private double reviewRate;
	private String comment;
	
	public Review() {
		this(0,0,0.0,null);
	}

	public Review(int reviewNum, int movieNum, double reviewRate, String comment) {
		this.setMovieNum(movieNum);
		this.reviewNum = reviewNum;
		this.reviewRate = reviewRate;
		this.comment = comment;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public double getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(double reviewRate) {
		this.reviewRate = reviewRate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [" + reviewNum + ", " + this.getMovieNum()+ ", " + reviewRate + ", " + comment + "]";
	}
	
	
	
}
