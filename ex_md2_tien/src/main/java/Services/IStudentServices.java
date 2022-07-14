package Services;

import Model.Student;

import java.util.List;

public interface IStudentServices {
    List<Student> findAll();


    boolean existsPhoneNumber(String phoneNumber);

    Student getByCode(long code);

    Student getByEmail(String email);
    Student getByPhone(String phone);
    void deleteByCode(long code);
    void studentByClass();
    boolean existsCode(long code);
    boolean existsEmail(String email);
    boolean existsClass(String classes);
    void add(Student newStudent);
    void edit(Student beforeStudent);
    List<Student> sortFullNameADC(List<Student> studentList);
    List<Student> sortFullNameDEC(List<Student> studentList);
    boolean checkNameStudent(String name);
}
