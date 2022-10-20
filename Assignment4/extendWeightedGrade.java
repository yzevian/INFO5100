/* [Yi Zhao]
 * [Class INFO5101]
 * [Assignment4]
 * [Section8]
 * [NUID:002103352]
 */

package Assignment4;

import java.util.Scanner;

public class extendWeightedGrade {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		calculateGrades c= new calculateGrades();
		System.out.print("Please use spance to separate data，and enter -1 to indicate the end\n");
		
		System.out.print("Please input the Earned Points:"+"\n");
		while(true){
			int EarnedPoints = s.nextInt();
			if (EarnedPoints == -1) break;
			c.setE_point(EarnedPoints);
			//System.out.print(c.e_point(EarnedPoints));
		}
		
		System.out.print("Please input the total Point:"+"\n");
		while(true){
			int totalPoint = s.nextInt();
			if(totalPoint==0) 
				System.out.println("Error, total Point cannot be 0, Please end the program and run it again");
			if (totalPoint == -1) break;
			c.setT_point(totalPoint);
			//System.out.print(c.e_point(totalPoint));
		}
		
		System.out.print("Please input the Assignment Percentage(only number):"+"\n");
		while(true){
			int Percentage = s.nextInt();
			if (Percentage == -1) break;
			c.setPercent(Percentage);
			//System.out.print(c.e_point(Percentage));
		}
		
		
		double g=c.calGrade();
		c.calculateGrades(g);
		    	
	}
}
