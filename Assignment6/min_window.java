/*
 * [Yi Zhao]
 * [Class INFO5101]
 * [Assignment3]
 * [Section8]
 * [NUID:002103352]
 * 
 * This is the graphical interface class.
 */
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;


public class min_window {

	protected Shell shell;
	
	private Text t1,t2,t3,t4;

	private Label label1,label2,label3,label4;
	
	private Button b1;//widgets initialize

	/**
	 * Launch the application.
	 * @param args
	 
	public static void main(String[] args) {
		try {
			lab_six window = new lab_six();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Open the window.
	 */
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(600, 500);
		shell.setText("SWT Application");
		b1 = new Button(shell, SWT.NONE);
		b1.setText("Click to calculate Score:");
		b1.setBounds(100, 200, 300, 30);
		b1.addSelectionListener(new SelectionAdapter() {
			@Override

			public void widgetSelected(SelectionEvent e) {
				calGrade cg = new calGrade();
				
			    double T_point = Double.parseDouble(t1.getText());
			    cg.setPointtotal(T_point);

			    double E_point = Double.parseDouble(t2.getText());
			    cg.setEarnedpoints(E_point);
			
			    double P = Double.parseDouble(t3.getText());
			    cg.setAssignment(P);
			
			    cg.totalWeightGrade();
			    t4.setText(String.valueOf(cg.totalWeightGrade()));
			}

		});//Button click event
		
		//the elements defination
		label1 = new Label(shell,SWT.NONE);
		label1.setText("Total Assignment Points:");
		label1.setBounds(20,30,250,30);
		
		
		label2 = new Label(shell,SWT.NONE);
		label2.setText("Earned Points:");
		label2.setBounds(300,30,250,30);	
		
		label3 = new Label(shell,SWT.BORDER);
		label3.setText("Percentage of class:");
		label3.setBounds(20,110,250,30);
		
		label4 = new Label(shell,SWT.BORDER);
		label4.setText("Weighted Score:");
		label4.setBounds(100,240,300,30);
		
		t1 = new Text(shell, SWT.BORDER);
		t1.setBounds(20,70,250,30);

		t2 = new Text(shell, SWT.BORDER);
		t2.setBounds(300,70,250,30);
		
		t3 = new Text(shell, SWT.BORDER);
		t3.setBounds(20,150,250,30);
		
		t4 = new Text(shell, SWT.BORDER);
		t4.setBounds(100,280,300,30);
		
	}
}

