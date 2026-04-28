package bean;

public class SubjectBean implements java.io.Serializable {
    private String subjectCode;
    private String subjectName;
 
    public SubjectBean() {
    	
    }
    
    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }
    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
}