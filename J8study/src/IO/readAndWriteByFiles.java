package IO;

import java.io.IOException;
import java.nio.file.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * nio 
 * 读取文件，取出带[error]的行，写入另一个文件。
 * @author yy
 *
 */
public class readAndWriteByFiles {

	public static void main(String[] args) throws IOException {
		Path Rpath=Paths.get("C:\\a\\Hello.txt");
		Path Wpath=Paths.get("C:\\a\\Hello1.txt");
		Files.lines(Rpath)
			 .filter(line->line.contains("[error]"))    
			 .map(
					 (a)->{
						 LocalDate ld=LocalDate.now();
						 LocalTime lt=LocalTime.now();
						 a=ld.toString()+" "+lt.toString()
								 +"\n"+a;
				 			return a;
			 			}
				)
			 .forEach(
					 a->{						 
						 System.out.println(a);
						 try {
							Files.write(Wpath, (a+"\n").getBytes(),StandardOpenOption.APPEND);
						 	} catch (IOException e) {
							e.printStackTrace();
						 	}
				
					 	}
					 );
		
		

	}
	
	
//	String readByFileInputStream() {
//try(FileInputStream fin=new FileInputStream("C:\\a\\Hello.txt")) {
//			
//			//Stream<String> lines=Files.lines(Paths.get(""));
//			Stream<String> lines= fin.read().
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 
//	}

}
