import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*
 * [Yi Zhao]
 * [Class INFO5101]
 * [Assignment3]
 * [Section8]
 * [NUID:002103352]
 * 
 *
 * This is a read and write file.
 */
public class ReadAndWrite {
	//read file method
	public String readFile(String rName) {
		String str1 = "";
		try {
			File myFile = new File(rName);
			Scanner s = new Scanner(myFile);
			int i=0;
			
			while(s.hasNextLine() && i<5) {
				String data = s.nextLine();
				str1 +=data+"\n";
		
				i++;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			
			str1 = "File not found";
		}
		return str1;
	}
	
	// write file method
	public String writeFile(String rName, String wName) {
		File file = new File(rName);
		String content=null;
		String str2="";
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(rName));
			
				File f = new File(wName);
				FileOutputStream out1 = new FileOutputStream(f);
				OutputStreamWriter writer = new OutputStreamWriter(out1, "UTF-8");
			
				while((content = br.readLine())!=null) {
					String[] con = content.split(",");
					for(int i=0; i<3; i++) {
						if(i==2) {
							writer.append(con[i]+"\r\n");
						}else {
							writer.append(con[i]+",");
						}
					}
				}
				writer.close();
				out1.close();
				br.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			
				str2 = "File not found.";
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			File myFile = new File(wName);
			Scanner s = new Scanner(myFile);
			int i=0;
			while(s.hasNextLine() && i<5) {
				i++;
				String data = s.nextLine();
			
				str2 +=data+"\n";
			
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
				
			str2 = "File not found.";
		}
		return str2;
	}

}
