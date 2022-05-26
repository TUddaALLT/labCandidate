/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

/**
 *
 * @author 84352
 */
public class Intern extends Candidate {

    private String major;
    private String semester;
    private String university;

    public Intern(String major, String semester, String university) {
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public Intern(String major, String semester, String university, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
