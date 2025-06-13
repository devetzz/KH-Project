package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.MovieVO;
import model.ReservationVO;
import model.ReviewVO;

public interface ReservationFuncInterface {
	// public void movieFileUpload(ArrayList<MovieVO> mvList);
	// public void movieFileSave(ArrayList<MovieVO> mvList, Scanner s);
	// public void reservationFileUpload(ArrayList<ReservationVO> rsvList);
	// public void reservationFileSave(ArrayList<ReservationVO> rsvList, Scanner s);
	// public void reviewFileUpload(ArrayList<ReviewVO> rvList);
	// public void reviewFileSave(ArrayList<ReviewVO> rvList, Scanner s);
	
	public int adminLogon(int no, Scanner s);
	
	public void movieAdd(ArrayList<MovieVO> mvList, Scanner s);
	public void movieModify(ArrayList<MovieVO> mvList, Scanner s);
	public void movieRemove(ArrayList<MovieVO> mvList, Scanner s);
	
	public void movieList(ArrayList<MovieVO> mvList, Scanner s);
	
	public void reservationAsc(ArrayList<MovieVO> rsvList, Scanner s);
	public void reservationDesc(ArrayList<MovieVO> rsvList, Scanner s);
	public void reservationMax(ArrayList<MovieVO> rsvList);
	public void reservationMin(ArrayList<MovieVO> rsvList);

	public void reservationAdd(ArrayList<ReservationVO> rsvList, Scanner s);
	public void reservationCancle(ArrayList<ReservationVO> rsvList, Scanner s);
	public void reservationCheck(ArrayList<ReservationVO> rsvList, Scanner s);
	public void reservationModify(ArrayList<ReservationVO> rsvList, Scanner s);

	public void movieReservationCountUpdate(ArrayList<ReservationVO> rsvList, ArrayList<MovieVO> mvList,Scanner s);

	public void reviewWrite(ArrayList<ReviewVO> rvList, ArrayList<MovieVO> mvList, Scanner s);
	public void reviewPrint(ArrayList<ReviewVO> rvList, Scanner s);
	
	public String PatternInspection(Scanner s, String string, String regex);

}
