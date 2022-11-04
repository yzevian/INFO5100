/*
 * [Yi Zhao]
 * [Class INFO5101]
 * [Assignment3]
 * [Section8]
 * [NUID:002103352]
 * 
 *
 *  This is a ui file.
 */

import java.io.*;
import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class minWindow {

	protected Shell shell;

	private Text t1, t2, t3, t4;

	private Label label1, label2, label3, label4;

	private Button b1, b2;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */


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
		shell.setText("Assignment7");

		b1 = new Button(shell, SWT.NONE);
		b1.setText("Click to Read from file:");
		b1.setBounds(20, 120, 200, 30);
		b1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ReadAndWrite re = new ReadAndWrite();
				String ans = re.readFile(t1.getText());
				t3.setText(ans);
				//call the read method
			}
		});

		b2 = new Button(shell, SWT.NONE);
		b2.setText("Click to write to file:");
		b2.setBounds(300, 120, 200, 30);
		b2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ReadAndWrite rw = new ReadAndWrite();
				String res = rw.writeFile(t1.getText(), t2.getText());
				t4.setText(res);
				//call the write method
			}
		});

		label1 = new Label(shell, SWT.NONE);
		label1.setText("Reading File Name:");
		label1.setBounds(20, 30, 250, 30);

		label2 = new Label(shell, SWT.NONE);
		label2.setText("File Name to Write:");
		label2.setBounds(300, 30, 250, 30);

		label3 = new Label(shell, SWT.NONE);
		label3.setText("Frist five lines of file:");
		label3.setBounds(20, 180, 250, 30);

		label4 = new Label(shell, SWT.NONE);
		label4.setText("Frist five lines of new file:");
		label4.setBounds(300, 180, 250, 30);

		t1 = new Text(shell, SWT.BORDER);
		t1.setBounds(20, 70, 200, 30);

		t2 = new Text(shell, SWT.BORDER);
		t2.setBounds(300, 70, 200, 30);

		// t3 = new Text(shell, SWT.BORDER);
		t3 = new Text(shell, SWT.MULTI | SWT.BORDER);
		t3.setBounds(20, 220, 250, 200);

		t4 = new Text(shell, SWT.MULTI | SWT.BORDER);
		// t4 = new Text(shell, SWT.BORDER);
		t4.setBounds(300, 220, 250, 200);

	}

}
