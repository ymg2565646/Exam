package bean;

public class ScoreBean implements java.io.Serializable {
    private String studentId;
    private String subjectCode;
    private int score;
    private String examDate;
    
    public ScoreBean() {
    	
    }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getExamDate() { return examDate; }
    public void setExamDate(String examDate) { this.examDate = examDate; }
}