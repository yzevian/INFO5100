
/* [Yi Zhao]
 * [Class INFO5101]
 * [Assignment3]
 * [Section8]
 * [NUID:002103352]
 */

package ExtendWeightedGrades;

public class CalculateGrades {
	private int[] earnePoint;
	private int[] totalPoint;
	private int[] precentage;
	private String finalresult;// the final level
	
	public String CalculateGrade(int a[],int b[],int c[]) {
		double[] graderesults = new double[a.length];
		int sum=0;
		double result=0;
		String finalresult;
		//Add some judgments to make sure you're calculating correctly
		//If the data is incorrect,display error
		if(a.length!=8 || b.length!=8|| c.length!=8 ) {
			return "error";
		}
		
		for(int i=0; i<c.length; i++) {
			sum +=c[i];
		}
		
		if(sum != 100) {
			return "error";
		}
		
		for(int i=0;i<a.length; i++) {
			
			if(a[i] > b[i]) {
				return "error";
			} 
			
		    double grade=(double)a[i]/b[i]*c[i];// calculate formula
		    //System.out.println(grade); 
		 	graderesults[i] = grade;//put the grade in array then calculate the total grade
			
		}
		
		for (int i=0;i<graderesults.length;i++) {
			result += graderesults[i];
		}
		
		if(result>=90 && result<=100) {finalresult ="A";}
		else if(result>=80 && result<90) 
			finalresult ="B";
		else if(result>=70 && result<80) 
			finalresult ="C";
		else if(result>=60 && result<70) 
			finalresult ="D";
		else 
			finalresult ="F";
		
	//System.out.print(finalresult);
		
	return finalresult;
	}

}
