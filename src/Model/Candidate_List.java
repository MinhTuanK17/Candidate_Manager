/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author MINH TUAN
 */
public class Candidate_List {

    ArrayList<Candidate> candidateList;

    public Candidate_List() {
        candidateList = new ArrayList<>();
    }

    public ArrayList<Candidate> getListCandidate() {
        return candidateList;
    }

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        candidates.add(candidate);
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        candidates.add(candidate);
    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {
        candidates.add(candidate);
    }

    public ArrayList<Candidate> search(Predicate<Candidate> predicate) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        for (Candidate candidate : candidateList) {
            if (predicate.test(candidate)) {
                candidates.add(candidate);
            }
        }
        return candidates;
    }
    
     
}
