/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author MINH TUAN
 */
public class Internship extends Candidate{
    protected String majors;
    protected String semester;
    protected String universityName;

    public Internship(String majors, String semester, String universityName, String candidateID, String frstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(candidateID, frstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Internship{" + "majors=" + majors + ", semester=" + semester + ", universityName=" + universityName + '}';
    }
    
    
}
