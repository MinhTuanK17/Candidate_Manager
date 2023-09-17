/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Candidate;
import Model.Candidate_List;
import Model.Experience;
import Model.Fresher;
import Model.Internship;
import View.Validation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import view.Menu;

/**
 *
 * @author MINH TUAN
 */
public class Candidate_Management extends Menu<String> {

    static String[] menu = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
    static Candidate_List candidateList = new Candidate_List();
    ArrayList<Candidate> candidates = new ArrayList<>();

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public  Candidate_List getCandidateList() {
        return candidateList;
    }
    
    

    public Candidate_Management() {
        super("__________ CANDIDATE MANAGEMENT SYSTEM __________", menu);
    }

    @Override
    public void execute(int choice) throws Exception {
        switch (choice) {
            case 1:
                addCandidate(candidates, 0);
                break;
            case 2:
                addCandidate(candidates, 1);
                break;
            case 3:
                addCandidate(candidates, 2);
                break;
            case 4:
                searchCandidate();
                break;
            case 5:
                System.out.println("___<3___ Thank you ___<3___");
                System.out.println("Exiting......");
                System.exit(0);
            default:
                this.stop();
        }
    }

    public void addCandidate(ArrayList<Candidate> candidates, int type) throws Exception {
        while (true) {

            String id = Validation.getString("Enter id: ");
            String firstName = Validation.checkName("Enter first name: ");
            String lastName = Validation.checkName("Enter last name: ");
            int birthDate = Validation.checkInt("Enter BirthDate: ", 1900, 2023);
            String address = Validation.getString("Enter address: ");
            String phone = Validation.checkPhone("Enter phone: ");
            String email = Validation.checkEmail("Enter email: ");

            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            candidateList.addCandidate(candidate);

            //check exist
            if (Validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createIntern(candidates, candidate);
                        break;
                }
            } else {
                return;
            }

            System.out.println("Do you want to continue?");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        int expYear = Validation.checkInt("Enter Year of Experience: ", 0, 100);
        String proSkill = Validation.getString("Enter Professional Skill: ");

        candidates.add(new Experience(expYear, proSkill, candidate.getCandidateID(), candidate.getFrstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        Date graDate = Validation.checkValidDate(Validation.getString("Enter Graduation Date: "));
        String graRank = Validation.checkGraduationRank("Enter Graduation Rank: ");
        String edu = Validation.getString("Enter education: ");

        candidates.add(new Fresher(graDate, graRank, edu, candidate.getCandidateID(), candidate.getFrstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {
        String major = Validation.getString("Enter major: ");
        String sem = Validation.getString("Enter Semester: ");
        String uni = Validation.getString("Enter University Name: ");
        candidates.add(new Internship(major, sem, uni, candidate.getCandidateID(), candidate.getFrstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
    }

    public void searchCandidate() throws Exception {
        String[] mSearch = {"Find by Candidate Name", "Find by Type of Candidate", "Back to Main Menu"};
        Menu m = new Menu("Candidate Searching", mSearch) {
            @Override
            public void execute(int choice) throws Exception {
                switch (choice) {
                    case 1:
                        searchName();
                        break;
                    case 2:
                        displayAll(candidates);
                        int type = Validation.checkInt("Enter type of candidate: ", 0, 100);

                        ArrayList<Candidate> searchType = candidateList.search(candidates -> candidates.getTypeCandidate() == type);
                        displaySearch(searchType);
                        break;
                    case 3:
                        return;
                    default:
                        this.stop();
                }
            }
        };
        m.execute(m.getSelected());

    }

    public void searchName() throws Exception {
        String[] mSearchName = {"Find by First Name", "Find by Last Name", "Back to Main Menu"};
        Menu mSearch = new Menu("Candidate Searching", mSearchName) {

            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        displayAll(candidates);
                        String firstName = Validation.getString("Enter first Name: ");
                        ArrayList<Candidate> searchFirstName = candidateList.search(candidates -> candidates.getFrstName().startsWith(firstName));
                        displaySearch(searchFirstName);
                        break;
                    case 2:
                        displayAll(candidates);
                        String lastName = Validation.getString("Enter last Name: ");
                        ArrayList<Candidate> searchLastName = candidateList.search(candidates -> candidates.getLastName().startsWith(lastName));
                        displaySearch(searchLastName);
                        break;
                }
            }
        };
        mSearch.execute(mSearch.getSelected());
    }

    public void displaySearch(ArrayList<Candidate> candidates) {
        if (candidates.isEmpty()) {
            System.out.println("No doctor found.");
        } else {
            System.out.println("The candidates found:");
            System.out.printf("%-15s | %-15s | %-15s | %-15s | %-20s |%-20s%n", "Name", "Date of Birth", "Address", "Phone", "Email", "Type Candidate");

            for (Candidate candidate : candidates) {
                System.out.printf("%-15s | %-15s | %-15s | %-15s | %-20s | %-20s%n", candidate.getFrstName() + candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate());
            }
        }
        System.out.println();

    }

    public void displayAll(ArrayList<Candidate> candidates) {

        System.out.println("List of Candidate:");
        System.out.println("-----------------------------------------");
        System.out.println("=========== Experience Candidate ===========");

        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFrstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========   Fresher Candidate  ===========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFrstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("=========== Internship Candidate ===========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFrstName() + " " + candidate.getLastName());
            }
        }
    }
}
