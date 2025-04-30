package theater;

public class Review extends Movie{
	private int reviewNum;
	// movieNum => movieName
	private double reviewRate;
	private String comment;
	
	public Review() {
		this(0,null,0.0,null);
	}

	public Review(int reviewNum, String movieName, double reviewRate, String comment) {
		this.setMovieName(movieName);
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
		return formatAlign(reviewNum, 10)
				+ formatAlign(this.getMovieName(), 20)
				+ formatAlign(reviewRate, 10)
				+ formatAlign(comment, 100);
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
	public static String formatAlign(double number, int width) {
		return formatAlign(String.valueOf(number), width);
	}
}
