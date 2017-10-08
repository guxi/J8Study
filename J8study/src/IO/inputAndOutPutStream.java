package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class inputAndOutPutStream {
	public static void main(String[] args) {
		String outPath="C:\\a\\BufferedWriterHello1.txt";
		String inPath="C:\\a\\Hello.txt";
		try (
				BufferedReader br = new BufferedReader(new FileReader(inPath));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(outPath)));
				){
			 String temp = br.readLine();
			 while(temp!=null){			 
			 //写文件
				 writer.write(temp);
			  temp = br.readLine();
			  if(temp == null)break;
			  writer.write("\n");	  //只适用Windows系统 ,继续读文件 
			  } 
		}
		// TODO Auto-generated method stub
 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
