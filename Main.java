import java.io.IOException;
import java.util.Scanner;


public class Main{
	
	public static void main(String args[]){
		
		
		//Call export grade class file
		
		//Call tutor get attandance class file
		attendanceMonitoring attMonitor = new attendanceMonitoring();
		
		System.out.println("Hello, are you a:");
		System.out.println("1. Admin");
		System.out.println("2. Tutor");
		System.out.println("3. Student");
		System.out.println("\nInput: ");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getIntInput = Integer.parseInt(getInput);		
		
		while(getIntInput != 0){
			
			switch(getIntInput){
				
				case 0:
					System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
					getInput = scan.next();
					getIntInput = Integer.parseInt(getInput);
					break;
					
				case 1:
					System.out.println("You choose 1. Admin");
					//admin.printFunction();
					getIntInput = 0;
					break;
					
				case 2:
					//System.out.println("You choose 2. Tutor");
					attMonitor.printFunctions();
					getIntInput = 0;
					break;
					
				case 3:
					System.out.println("You choose 3. Student");
					getIntInput = 0;
					break;
					
				default: 
					System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
					getInput = scan.next();
					getIntInput = Integer.parseInt(getInput);
					break;
			}
		}
		scan.close();
	}
}