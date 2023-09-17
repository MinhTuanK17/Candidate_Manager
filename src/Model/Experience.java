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
public class Experience extends Candidate {
    protected int expInYear;
    protected String proSkill;

    public Experience(int expInYear, String proSkill, String candidateID, String frstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(candidateID, frstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience {" + "expInYear=" + expInYear + ", proSkill=" + proSkill + '}';
    }
   
}
