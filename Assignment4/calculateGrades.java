/* [Yi Zhao]
 * [Class INFO5101]
 * [Assignment4]
 * [Section8]
 * [NUID:002103352]
 */
package Assignment4;

import java.util.LinkedList;

public class calculateGrades {
	private String finalresult;
	private LinkedList<Integer> e_point = new LinkedList<Integer>();
	private LinkedList<Integer> t_point = new LinkedList<Integer>();
	private LinkedList<Integer> p = new LinkedList<Integer>();
	private double sum=0;

	//Add data to a linkedlist
	public void setE_point(int a) {
		e_point.add(a);
		//return e_point;
	}
	
	public void setT_point(int b) {
		t_point.add(b);
		//return t_point;
	}
	
	public void setPercent(int c) {
		p.add(c);
		//return p;
	}
	
	//calculate grades
	public double calGrade() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<e_point.size();i++) {
		double grade=(double)e_point.get(i)/t_point.get(i)*p.get(i);
		//System.out.println(grade);
		sum += grade;
		
		}
		System.out.print(sum);
		return sum;
	}

	// Calculate level
	public String calculateGrades(double sum) {
		if(sum>=90 && sum<=100) {finalresult ="A";}
		else if(sum>=80 && sum<90) {finalresult ="B";}
		else if(sum>=70 && sum<80) {finalresult ="C";}
		else if(sum>=60 && sum<70) { finalresult ="D";}
		else {finalresult ="F";}
		System.out.print(finalresult);
		return finalresult;		
	}
	
	public LinkedList<Integer> getT_point(){
	    return t_point;
	}
	public LinkedList<Integer> getE_point(){
	    return e_point;
	}
	public double getPercent(){
	    return sum;
	}
	
}
