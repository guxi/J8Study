package ExcelAndDB;

import java.util.List;

//import java.awt.List;

public class test {

	public static void main(String[] args) {

		getExcelService ges=new getExcelService("C:\\Course\\数据库技术\\学期\\2011-2012(1)\\平时成绩登记表.xls");
		ges.saveToDB();
		//int i=ges.saveCourseInfo();
		//System.out.println(i);
//		List<student> list=ges.getStudents();
//		courseInfo ci=ges.getCInfo();	
//		
//		System.out.println(ci.toString());
//		System.out.println(list.size());
//		for(student s:list) {
//		System.out.println(s.toString());	
//		}		
	}

}
