/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author 84352
 */
public class Manangement {

    Validate validate = new Validate();
    ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    private void createCandidate(int type) {
        while (true) {
            String id = validate.checkRegex("^[a-zA-Z1-9]{1,}$",
                    "Enter id:", "Must be alphabet or digit");
            String firstName = validate.checkRegex("^[a-zA-Z]{1,}$",
                    "Enter first name: ", "Must be alphabet");
            String lastName = validate.checkRegex("^[a-zA-Z]{1,}$",
                    "Enter last name: ", "Must be alphabet");
            int birthDate = validate.checkIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR),
                    "Enter Birthdate", "Must be 1900-> Now");
            String address = validate.checkInputString("Enter Address:");
            String phone = validate.checkRegex("[0-9]{10,}",
                    "Enter Phone: ", "Phone >10 digits");
            String email = validate.checkRegex("^[a-zA-Z1-9]{1,}@[a-zA-Z1-9]{1,}(.[a-zA-Z1-9]{1,}){1,3}$",
                    "Enter Email: ", "Must be email (ex: xxx@sss.mmm)");
            if (validate.checkIdExist(candidates, id)) {
                Candidate candidate = new Candidate(id, firstName, lastName,
                        birthDate, address, phone, email, type);
                if (type == 0) {
                    createExp(candidate);
                } else if (type == 1) {
                    createFre(candidate);
                } else {
                    createIntern(candidate);
                }
            } else {
                return;
            }
            String choose = validate.checkOption("y|n", "Do you want to continue (Y/N)? :"
                    + "  ", "Must be Y or N");
            if (choose.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void createExp(Candidate candidate) {
        int yearExperience = validate.checkIntLimit(0,
                Calendar.getInstance().get(Calendar.YEAR) - candidate.getBirthDate(),
                "Enter year experience", "Must be < age");
        String professionalSkill = validate.checkInputString("Enter professional skill");

        candidates.add(new Experience(yearExperience, professionalSkill, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        display();
    }

    private void createFre(Candidate candidate) {

        String graduationDate = validate.checkInputString("Enter graduation date");
        String graduationRank = validate.checkOption("excellence|good|fair|poor",
                "Enter Rank of Graduation", "1 in Excellence|Good|Fair|Poor");

        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        display();
    }

    private void createIntern(Candidate candidate) {

        String major = validate.checkInputString("Enter Major: ");
        String semester = validate.checkInputString("Enter Semester: ");
        String university = validate.checkInputString("Enter University: ");;

        candidates.add(new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        display();
    }

    private void display() {
        System.out.println("List of candidate: ");
        boolean isExistExp = false;
        boolean isExistFre = false;
        boolean isExistIntern = false;

        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience && isExistExp==false) {
                isExistExp = true;
            }
            if (candidate instanceof Fresher && isExistFre== false) {
                isExistFre = true;
            }
            if (candidate instanceof Intern && isExistIntern==false) {
                isExistIntern = true;
            }
        }
        if (isExistExp) {
            System.out.println("===========EXPERIENCE CANDIDATE============ ");
            for (Candidate candidate : candidates) {
                if (candidate instanceof Experience) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }
        if (isExistFre) {
            System.out.println("===========FRESHER CANDIDATE============ ");
            for (Candidate candidate : candidates) {
                if (candidate instanceof Fresher) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }

        if (isExistIntern) {
            System.out.println("===========INTERN CANDIDATE============ ");
            for (Candidate candidate : candidates) {
                if (candidate instanceof Intern) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }

    }

    private void search() {
        String name = validate.checkInputString("Input Candidate name (First name or Last name): ");
        int type = validate.checkIntLimit(0, 2, "Input type of candidate: ", "Must be 0->2");
        boolean isExist = false;
        boolean found = true;

        if (type == 0) {
            // candidate
            for (Candidate candidate : candidates) {

                if (candidate instanceof Experience) {
                    if (candidate.getFirstName().contains(name)
                            || candidate.getLastName().contains(name)) {
                        isExist = true;
                        if (found) {
                            found = false;
                            System.out.println("The candidates found:");
                        }
                        System.out.println(candidate.toString());
                    }
                }
            }
            if (!isExist) {
                System.out.println("The candidates not found:");
            }
        } else if (type == 1) {

            for (Candidate candidate : candidates) {
                if (candidate instanceof Fresher) {
                    if (candidate.getFirstName().contains(name) || candidate.getLastName().contains(name)) {
                        isExist = true;
                        if (found) {
                            found = false;
                            System.out.println("The candidates found:");
                        }
                        System.out.println(candidate.toString());
                    }
                }
            }
            if (!isExist) {
                System.out.println("The candidates not found:");
            }
        } else {

            for (Candidate candidate : candidates) {
                if (candidate instanceof Intern) {
                    if (candidate.getFirstName().contains(name) || candidate.getLastName().contains(name)) {
                        isExist = true;
                        if (found) {
                            found = false;
                            System.out.println("The candidates found:");
                        }
                        System.out.println(candidate.toString());
                    }
                }
            }
            if (!isExist) {
                System.out.println("The candidates not found:");
            }
        }

    }

    public void menu() {
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1.	Experience\n"
                    + "2.	Fresher\n"
                    + "3.	Internship\n"
                    + "4.	Searching\n"
                    + "5.	Exit");
            int choice = validate.checkIntLimit(1, 5, "Choose:  ", "Must be 1->5");
            switch (choice) {
                case 1:
                    createCandidate(0);
                    break;
                case 2:
                    createCandidate(1);

                    break;
                case 3:
                    createCandidate(2);

                    break;
                case 4:
                    search();
                    break;

                case 5:
                    return;
            }
        } while (true);
    }
}
