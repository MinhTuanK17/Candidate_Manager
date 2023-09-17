/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Candidate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MINH TUAN
 */
public class Validation {

    public Validation() {
    }

    final static String DATE_FORMAT = "dd/MM/yyyy";
    final static Scanner scanner = new Scanner(System.in);

    //Nhap chuoi 
    public static String getString(String msg) {
        String value = null;

        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }

            System.err.println("Please enter again...");
        }

        return value;
    }

    //Kiem tra Date
    public static Date checkValidDate(String msg) {
        boolean isValidDate = false;
        Date date = null;

        while (!isValidDate) {
            try {
                date = validStringToDate(msg);
                isValidDate = true; 
            } catch (ParseException ex) {
                System.out.println("Please enter date with format(dd/mm/yyyy)");
                msg = getString("Enter Graduation Date: ");
            }
        }

        return date; 
    }

    public static Date validStringToDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        // df.setLenient(false);
        return df.parse(date);
    }

    public static String showDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }

    // kiem tra ten
    public static String checkName(String msg) {
        String input = null;

        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            input = scanner.nextLine().trim();
            boolean isValid = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && !input.isEmpty()) {
                break;
            }
            System.out.println("Name cannot contain special characters or numbers. Please try again");
        }
        return input;
    }

    //check Phone
    public static String checkPhone(String msg) {
        while (true) {
            String phone = getString(msg);
            phone.trim();

            if (phone.length() != 10) {
                System.out.println("Number phone is under 10 digits.Please enter again your phone");
                continue;
            }
            String sub = phone.substring(4);
            try {
                int check = Integer.parseInt(sub);
                if (check < 0) {
                    continue;
                }
                return sub;

            } catch (Exception e) {
                System.out.println("Invalid phone number.");
            }

        }
    }

    // Kiem tra kdl int  
    public static int checkInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                value = Integer.parseInt(scanner.nextLine());
                if (value < minRange || value > maxRange) {
                    System.out.println("Invalid input! Value must be between " + minRange + " and " + maxRange + ". Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please try again");
            }
        } while (value < minRange || value > maxRange);

        return value;
    }

    // Kiem tra ton tai
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateID().equalsIgnoreCase(id)) {
                System.out.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    // Kiem tra graduation rank
    public static String checkGraduationRank(String msg) {
        while (true) {
            String result = getString(msg);
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.out.println("Please choose one in Graduation: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    // Kiem tra email
    public static String checkEmail(String msg) {
        while (true) {
            try {
                int vt = 0;
                String sub = "";
                String email = getString(msg);
                email.trim();
                if (email.startsWith(" ")) {
                    System.out.println("Email must be have format @gmail.com/@fpt.edu.vn");
                    continue;
                } else {
                    vt = email.indexOf("@");
                    if (email.charAt(0) == '@') {
                        System.out.println("Email must be have format @gmail.com/@fpt.edu.vn");
                        continue;
                    }
                    sub = email.substring(vt + 1);
                }
                if (!sub.equals("gmail.com") && !sub.equals("fpt.edu.vn")) {               
                    System.out.println("Email must be have format @gmail.com/@fpt.edu.vn");                  
                    continue;
                }
                return email;
            } catch (Exception ex) {
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String input = getString("Please enter y/Y or n/N: ");

            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Invalid. Try again.");
        }
    }

}
