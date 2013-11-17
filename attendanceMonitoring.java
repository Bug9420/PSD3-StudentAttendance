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
				break;
			case 2:
				//call another function
				
				break;
			case 3:
				//call another function
		}
		scan.close();
	}
	
}