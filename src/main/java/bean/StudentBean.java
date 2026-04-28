package bean;

public class StudentBean implements java.io.Serializable {
    private String studentId;
    private String studentName;
    private int grade;
    private String classNo;
    private boolean isEntrolled;
 
    public StudentBean() {
    	
    }
 
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
    public String getClassNo() { return classNo; }
    public void setClassNo(String classNo) { this.classNo = classNo; }
    public boolean isEntrolled() { return isEntrolled; }
    public void setEntrolled(boolean isEntrolled) { this.isEntrolled = isEntrolled; }
}