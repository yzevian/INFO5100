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
			c.e_point(EarnedPoints);
			//System.out.print(c.e_point(EarnedPoints));
		}
		
		System.out.print("Please input the total Point:"+"\n");
		while(true){
			int totalPoint = s.nextInt();
			if (totalPoint == -1) break;
			c.t_point(totalPoint);
			//System.out.print(c.e_point(totalPoint));
		}
		
		System.out.print("Please input the Assignment Percentage(only number):"+"\n");
		while(true){
			int Percentage = s.nextInt();
			if (Percentage == -1) break;
			c.percent(Percentage);
			//System.out.print(c.e_point(Percentage));
		}
		
		double g=c.calGrade();
		c.calculateGrades(g);
		    	
	}
}
