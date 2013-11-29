package psd3Sprint1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Course {
	

	
	
	//for export all student grades
	private String coursename;
	private ArrayList<Student> allstudentgradelist;
	 
	//for single student
	
	


	
	
	
	

	public Course(String coursename,ArrayList<Student> allstudentgradelist){

		this.coursename=coursename;
		this.allstudentgradelist=allstudentgradelist;	
	}

	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}



	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Student getAllstudentgradelist(int index) {
		return allstudentgradelist.get(index);
}
	public ArrayList<Student> getAllstudentgradelist() {
		return allstudentgradelist;
}
	public void setAllstudentgradelist(ArrayList<Student> allstudentgradelist) {
		this.allstudentgradelist = allstudentgradelist;
	}
	
	
}
