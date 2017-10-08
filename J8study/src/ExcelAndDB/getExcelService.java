package ExcelAndDB;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mysql.jdbc.PreparedStatement;

public class getExcelService {

	final static ComboPooledDataSource ds = new ComboPooledDataSource("usualscore");
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private List<student> Students;
	private courseInfo CInfo;

	public List<student> getStudents() {
		return Students;

	}

	public void setStudents(List<student> students) {
		Students = students;
	}

	public courseInfo getCInfo() {

		return CInfo;
	}

	public void setCInfo(courseInfo cInfo) {
		CInfo = cInfo;
	}

	getExcelService(String Path) {
		Workbook wb = getWorkBook(Path);
		List<student> list = new ArrayList<student>();

		Sheet sheet = wb.getSheetAt(0);

		// set courseInfo
		String courseInfo = sheet.getRow(1).getCell(0).getStringCellValue();
		String[] s1 = courseInfo.split("：");
		int end = s1[1].indexOf(" ");
		String Semester = s1[1].substring(0, end);
		end = s1[2].indexOf(" ");
		String CourseName = s1[2].substring(0, end);
		end = s1[3].indexOf(" ");
		String techer = s1[3].substring(0, end);
		String className = s1[4];
		courseInfo ci = new courseInfo();
		ci.setSemester(Semester);
		ci.setCourseName(CourseName);
		ci.setTecher(techer);
		// ci.setClassName(ClassName);
		setCInfo(ci);
System.out.println(courseInfo.toString());
		// set StudentsInfo
		int rowIndex = 5;
		while (rowIndex <= sheet.getLastRowNum()) {
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				String id = row.getCell(0).getStringCellValue();
				if (id.equals("武汉科技大学学生平时成绩登记表")&&id.equals("平时成绩登记表")) {

					courseInfo = sheet.getRow(rowIndex + 1).getCell(0).getStringCellValue();
					s1 = courseInfo.split("：");
					className = s1[4];

					rowIndex = rowIndex + 5;
					continue;
				}

				String name = row.getCell(1).getStringCellValue();
				student s = new student(id, name, className);
				list.add(s);
			}
			rowIndex++;
		}
		setStudents(list);

	}
	//@Transactional
	void saveToDB() {
		int courseInfoKey = saveCourseInfo();
		if (courseInfoKey != -1) {
			saveStudents();
			String sql = "insert into score(studentid,courseid) values(?,?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				for (student s : getStudents()) {

					pstmt.setString(1, s.getId());				
					pstmt.setInt(2, courseInfoKey);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	void saveStudents() {
		String sql1 = "";
		List<student> list = new ArrayList<student>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			for (student s : getStudents()) {
				sql1 = "select * from student where id=" + s.getId();
				rs = stmt.executeQuery(sql1);
				if (!rs.next())
					list.add(s);				
			}
			rs.close();
			stmt.close();
			String sql = "insert into student(id,name,classname) values(?,?,?)";
			pstmt= conn.prepareStatement(sql);
			for (student s : list) {
				pstmt.setString(1, s.getId());
				pstmt.setString(2, s.getName());
				pstmt.setString(3, s.getClassName());
				//pstmt.setInt(4, courseInfoKey);
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	int saveCourseInfo() {
		try {
			String sql = "insert into courseinfo(Semester,CourseName,techer) values(?,?,?)";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, getCInfo().getSemester());
			pstmt.setString(2, getCInfo().getCourseName());
			pstmt.setString(3, getCInfo().getTecher());
			pstmt.executeUpdate();
			ResultSet rsKey = pstmt.getGeneratedKeys();
			rsKey.next();
			int key = rsKey.getInt(1); // 得到第一个键值
			// System.out.println(key);

			rsKey.close();
			pstmt.close();
			conn.close();
			return key;

			// pstmt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	Workbook getWorkBook(String Path) {
		Workbook wb = null;
		InputStream inp = null;
		try {
			inp = new FileInputStream(Path);
			wb = WorkbookFactory.create(inp);
			inp.close();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	Workbook getWorkBook(InputStream inp) {
		Workbook wb = null;
		//InputStream inp = null;
		try {
			wb = WorkbookFactory.create(inp);
			inp.close();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return wb;
	}


}
