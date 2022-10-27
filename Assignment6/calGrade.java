/*
 * [Yi Zhao]
 * [Class INFO5101]
 * [Assignment3]
 * [Section8]
 * [NUID:002103352]
 * 
 * 
 *  This is the weighted grades class.
 */
 

public class calGrade {

	private double Pointtotal;
	private double Earnedpoints;
	private double Assignment;
	//definition of input variable
	
	public void setPointtotal(double Pointtotal) {
		this.Pointtotal=Pointtotal;		
	}
	
	public double getPointtotal() {
		return Pointtotal;
	}
	
	public void setEarnedpoints(double Earnedpoints ) {
		this.Earnedpoints=Earnedpoints;			
	}
	
	public double getEarnedpoints() {
		return Earnedpoints;
	}
	
	public void setAssignment(double Assignment) {
		this.Assignment=Assignment;		
	}
	
	public double getAssignment() {
		return Assignment;
	}
	
	public double totalWeightGrade() {
		double result = (double) Earnedpoints/Pointtotal * Assignment;//calculate formula
		System.out.print(result);
		return result;
	}
	
}
