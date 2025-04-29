package theater;

import java.util.ArrayList;
import java.util.Scanner;

public interface ReservationFuncInterface {
	public void movieFileUpload(ArrayList<Movie> mvList);
	public void movieFileSave(ArrayList<Movie> mvList, Scanner s);
	public void reservationFileUpload(ArrayList<Reservation> rsvList);
	public void reservationFileSave(ArrayList<Reservation> rsvList, Scanner s);
	public void reviewFileUpload(ArrayList<Review> rvList);
	public void reviewFileSave(ArrayList<Review> rvList, Scanner s);
	
	public int adminLogon(int no, Scanner s);
	
	public void movieAdd(ArrayList<Movie> mvList, Scanner s);
	public void movieModify(ArrayList<Movie> mvList, Scanner s);
	public void movieRemove(ArrayList<Movie> mvList, Scanner s);
	
	public void movieList(ArrayList<Movie> mvList, Scanner s);
	
	public void reservationAsc(ArrayList<Movie> rsvList, Scanner s);
	public void reservationDesc(ArrayList<Movie> rsvList, Scanner s);
	public void reservationMax(ArrayList<Movie> rsvList);
	public void reservationMin(ArrayList<Movie> rsvList);

	public void reservationAdd(ArrayList<Reservation> rsvList, Scanner s);
	public void reservationCancle(ArrayList<Reservation> rsvList, Scanner s);
	public void reservationCheck(ArrayList<Reservation> rsvList, Scanner s);
	public void reservationModify(ArrayList<Reservation> rsvList, Scanner s);

	public void movieReservationCountUpdate(ArrayList<Reservation> rsvList, ArrayList<Movie> mvList,Scanner s);

	public void reviewWrite(ArrayList<Review> rvList, ArrayList<Movie> mvList, Scanner s);
	public void reviewPrint(ArrayList<Review> rvList, Scanner s);
	
	public String PatternInspection(Scanner s, String string, String regex);

}
