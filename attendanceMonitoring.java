import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class attendanceMonitoring{
	
	public void printFunctions(){
		
		ArrayList<String> allCourses = new ArrayList<String>();
		allCourses.add("PSD3");
		allCourses.add("ALG3");
		allCourses.add("PL3");
		
		System.out.println("All courses: ");
		
		for(int i=0; i<allCourses.size(); i++){
			
			System.out.println(i+1 + ". " + allCourses.get(i));
			
		}
		
		System.out.println("Please select a course: ");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getAttInput = Integer.parseInt(getInput);	
		switch(getAttInput){
			case 1:
				//call another function
				printPSD3();
				break;
			case 2:
				//call another function
				
				break;
			case 3:
				//call another function
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getAttInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}
	
	public void printPSD3(){
		System.out.println("Please select which date");
		System.out.println("1. 04/11/2013");
		System.out.println("2. 11/11/2013");
		System.out.println("3. 18/11/2013");
		System.out.println("4. 25/11/2013");
		
		ArrayList<String> studentNames = new ArrayList<String>();
		//String[] arr = null;
		
		studentNames.add("2010001, Yee Keng, YTT");
		studentNames.add("2010002, Daemian, YTT");
		studentNames.add("2010003, Boon Keong, YTT");
		studentNames.add("2010004, WinWin, YTT");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getDateInput = Integer.parseInt(getInput);	
		switch(getDateInput){
			case 1:
			
				break;
			case 2:
				//call another function
				
				break;
			case 3:
				//call another function
				break;
			
			case 4:
				
				break;
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getDateInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}
	
}