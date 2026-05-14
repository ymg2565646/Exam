package bean;
 
import java.io.Serializable;
 
public class TestListStudent implements Serializable {
    private String subjectName;
    private int num;
    private String subjectCd;
    private int point;
    
    public TestListStudent() {
    	
    }
 
    public String getsubjectName() { return subjectName; }
    public void getsubjectName(String subjectName) { this.subjectName = subjectName; }
    public int getnum() { return num; }
    public void getnum(int num) { this.num = num; }
    public String getsubjectCd() { return subjectCd; }
    public void getsubjectCd(String subjectCd) { this.subjectCd = subjectCd; }
    public int getPoint() { return point; }
    public void setPoint(int point) { this.point = point; }
    
}