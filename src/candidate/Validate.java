/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 84352
 */
public class Validate {

    Scanner in = new Scanner(System.in);

    int checkIntLimit(int min, int max,String mess, String error ) {
        while (true) {
            try {
                System.out.println(mess);
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println(error);
            }
        }
    }

    String checkRegex(String str, String mess, String error) {
        while (true) {
            try {
                System.out.println(mess);
                String result = in.nextLine().trim();
                if (result.matches(str)) {
                    return result;
                } else {
                    System.err.println(error);
                }
            } catch (NumberFormatException ex) {
                System.err.println(error);
            }
        }
    }

    String checkOption(String str, String mess , String error) {
        while (true) {
            try {
                System.out.println(mess);
                String result = in.nextLine().trim().toLowerCase();

                if (result.matches(str)) {
                    return result;
                } else {
                    System.err.println(error);
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                System.err.println(error);

            }
        }
      
    }

    String checkInputString(String mess) {
        while (true) {
            System.out.println(mess);
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Must be alphabet");
            } else {
                return result;
            }

        }
    }
    public  boolean checkIdExist(ArrayList<Candidate> candidates, String id) 
    {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id is exist.");
                return false;
            }
        }
        return true;
    }
    
}
