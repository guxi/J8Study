

public class courseInfo {
	private String courseName;
	private String semester;
	private String techer;
	

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTecher() {
		return techer;
	}

	public void setTecher(String techer) {
		this.techer = techer;
	}

	

	@Override
	public String toString() {
		return "courseInfo [courseName=" + courseName + ", semester=" + semester + ", techer=" + techer + "]";
	}

	
}
