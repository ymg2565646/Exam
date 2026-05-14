package bean;

import java.io.Serializable;

public class Subject implements Serializable{
    private String cd;
    private String name;
    private School school;
 
    public Subject() {
    	
    }
    
    public String getcd() { return cd; }
    public void getcd(String cd) { this.cd = cd; }
    public String getname() { return name; }
    public void getname(String name) { this.name = name; }
    public School getschool() { return school; }
    public void setschool(School school) { this.school = school; }
}