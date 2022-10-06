/* [Yi Zhao]
 * [Class INFO5101]
 * [Assignment2]
 * [Section8]
 * [NUID:002103352]
 * Description:This is the third assignment, which is used to calculate the sum of the eight grades 
 * and output the corresponding grade，
 * The user has to enter eight earn points，eight total point,and eight precentage.
 */
package ExtendWeightedGrades;

import java.util.Scanner;

public class ExtendWeightedGrades {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		System.out.print("Please use commas symbol（,） to separate data\n");
		//Data will be separated by comma,
		
		System.out.print("Please input the Earned Points :"+"\n");
		String earnPoints = s.nextLine();
		String[] earnPoint = earnPoints.split(",");
		int[] earnpoint= new int[earnPoint.length];
		for(int i =0; i<earnpoint.length; i++) {
			earnpoint[i] = Integer.parseInt(earnPoint[i]);//data type conversion
			//System.out.println(earnpoint[i]+" ");
		}
		
		if(earnpoint.length !=8) System.out.print("error，Please re-run and enter the correct data"+"\n");
		
		System.out.print("Please input the total Point :"+"\n");
		String totalPoint = s.nextLine();
		String[] totalPoints = totalPoint.split(",");
		int[] totalpoint= new int[totalPoints.length];
		for(int i =0; i<totalpoint.length; i++) {
			totalpoint[i] = Integer.parseInt(totalPoints[i]);
			//System.out.println(totalpoint[i]+" ");
		}
		if(totalpoint.length !=8) System.out.print("error，Please re-run and enter the correct data"+"\n");
		
		System.out.print("Please input the Assignment Percentage(only number):"+"\n");
		String precentage = s.nextLine();
		String[] precentages = precentage.split(",");
		int[] Precentage= new int[precentages.length];
		for(int i =0; i<Precentage.length; i++) {
			Precentage[i] = Integer.parseInt(precentages[i]);
			//System.out.println(Precentage[i]+" ");
		}
		
		CalculateGrades cg= new CalculateGrades();
		
		cg.CalculateGrade(earnpoint,totalpoint,Precentage);
		System.out.println(cg.CalculateGrade(earnpoint,totalpoint,Precentage));
	}
	
}
