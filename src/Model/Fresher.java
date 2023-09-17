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
public class Fresher extends Candidate {
    protected Date graduationDate;
    protected String graduationRank;
    protected String education;

    public Fresher(Date graduationDate, String graduationRank, String education, String candidateID, String frstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(candidateID, frstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" + "graduationDate=" + graduationDate + ", graduationRank=" + graduationRank + ", education=" + education + '}';
    }
    
    
    
}
