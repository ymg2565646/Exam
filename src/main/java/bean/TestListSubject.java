package bean;

import java.io.Serializable;

public class TestListSubject implements Serializable {
	private int entYear;
	private String studentNo;
	private String studentName;
	private String classNum;
	private int point;
	public TestListSubject() {
	
}
	public int getEntYear() { return entYear; }
	public void setEntYear(int entYear) { this.entYear = entYear; }
	public String getstudentNo() { return studentNo; }
	public void getstudentNo(String studentNo) { this.studentNo = studentNo; }
	public String getstudentName() { return studentName; }
	public void getstudentName(String studentName) { this.studentName = studentName; }
	public String getclassNum() { return classNum; }
	public void getclassNum(String classNum) { this.classNum = classNum; }
	public int  getpoint() { return point; }
	public void getpoint(int point) { this.point = point; }
}