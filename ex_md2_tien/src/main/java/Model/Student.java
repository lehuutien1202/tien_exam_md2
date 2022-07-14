package Model;

import java.time.Instant;

public class Student {
    private long code;
    private String classes;
    private String fullName;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private Instant addedAt;
    private Instant updatedAt;

    public Student() {
    }

    public Student(String classes, String fullName, String gender, String dateOfBirth, String phoneNumber, String email) {
        this.classes = classes;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static Student parseStudent(String row) {
        Student student = new Student ();
        String[] fields = row.split ( "," );
        student.code = Long.parseLong(fields[0]) ;
        student.classes = fields[1];
        student.fullName = fields[2];
        student.gender = fields[3];
        student.dateOfBirth = fields[4];
        student.phoneNumber = fields[5];
        student.email = fields[6];
        student.addedAt = Instant.parse ( fields[7] );
        String temp = fields[8];
        if ( temp != null && !temp.equals ( "null" ) )
            student.updatedAt = Instant.parse ( temp );
        return student;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Instant addedAt) {
        this.addedAt = addedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return code + "," +
                classes + "," +
                fullName + "," +
                gender + "," +
                dateOfBirth + "," +
                phoneNumber + "," +
                email + "," +
                addedAt + "," +
                updatedAt;
    }
}
