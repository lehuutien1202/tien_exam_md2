package Services;

import Model.Student;
import Utils.AppUtils;
import Utils.CSVUtils;
import Utils.InstanUtils;
import view.InputOption;
import view.StudentView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentServices implements IStudentServices {
    public final static String PATH = "data\\student.csv";
    private static StudentServices instance;
    private IStudentServices studentService;


    public StudentServices() {
    }

    public static StudentServices getInstance() {
        if (instance == null) instance = new StudentServices();
        return instance;
    }

    @Override
    public List<Student> findAll() {
        List<String> records = CSVUtils.read(PATH);
        List<Student> students = new ArrayList<>();
        for (String record : records) {
            students.add(Student.parseStudent(record));
        }
        return students;
    }



//  Thêm tài khoản mới

    @Override
    public void add(Student newStudent) {
        long code = System.currentTimeMillis()/1000 ;
        newStudent.setCode(code);
        newStudent.setAddedAt(Instant.now());
        List<Student> students = findAll();
        students.add(newStudent);
        CSVUtils.write(PATH, students);
    }

    //Sửa thông tin tài khoản tài khoản
    @Override
    public void edit(Student afterStudent) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getCode() == (afterStudent.getCode())) {
                String classes = afterStudent.getClasses();
                if (classes != null && !classes.isEmpty())
                    student.setClasses(classes);
                String fullName = afterStudent.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    student.setFullName(fullName);
                String gender = afterStudent.getGender();
                if (gender != null && !gender.isEmpty())
                    student.setGender(gender);
                String dayOfBirth = afterStudent.getDateOfBirth();
                if (dayOfBirth != null && !dayOfBirth.isEmpty())
                    student.setDateOfBirth(dayOfBirth);
                String phoneNumber = afterStudent.getPhoneNumber();
                if (phoneNumber != null && !phoneNumber.isEmpty())
                    student.setPhoneNumber(phoneNumber);
                String email = afterStudent.getEmail();
                if (email != null && !email.isEmpty())
                    student.setEmail(email);
                student.setUpdatedAt(Instant.now());
                CSVUtils.write(PATH, students);
                break;
            }
        }
    }
    @Override
    public List<Student> sortFullNameADC(List<Student> studentList) {
        studentList.sort ( new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName ().compareTo ( o2.getFullName () );
            }
        } );
        return studentList;
    }

    @Override
    public List<Student> sortFullNameDEC(List<Student> studentList) {
        studentList.sort ( new Comparator<Student> () {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getFullName ().compareTo ( o1.getFullName () );
            }
        } );
        return studentList;
    }

    @Override
    public Student getByCode(long code) {
        for (Student student : findAll ()) {
            if ( student.getCode () ==  code  )
                return student;
        }
        return null;
    }

    @Override
    public Student getByEmail(String email) {
        for (Student student : findAll ()) {
            if ( student.getEmail ().equals ( email ) )
                return student;
        }
        return null;
    }

    @Override
    public Student getByPhone(String phone) {
        for (Student student : findAll ()) {
            if ( student.getPhoneNumber ().equals ( phone ) )
                return student;
        }
        return null;
    }

    @Override
    public void deleteByCode(long code) {
        List<Student> students = findAll ();
        students.removeIf ( new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getCode () == ( code );
            }
        } );
        CSVUtils.write ( PATH, students );
    }

    @Override
    public void studentByClass() {
        do {
            String classes;
            do {
                System.out.print ( "Nhập lớp học: " );
                classes = AppUtils.retryString ( "Lớp học" );
                if ( !existsClass ( classes ) ) {
                    System.out.println ( classes + " không tồn tại, nhập lại: " );
                    continue;
                }
                break;
            }while (true);
            List<Student> students = findAll ();
            List<Student> studentByClass = new ArrayList<> ();
            for (Student student : students) {
                if ( student.getClasses ().equals ( classes ) ) {
                    studentByClass.add ( student );
                }
            }
            System.out.println ( "*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            System.out.println ( "||                                                                                ++++   DANH SÁCH HỌC VIÊN THEO LỚP    ++++                                                                                               ||" );
            System.out.println ( "*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            System.out.printf ( "|\t%-5s│%-20s│%-20s│%-30s│%-20s│%-20s│%-20s│%-30s│%-20s│%-20s|\n",
                    "STT", "Mã Học Viên", "Lớp", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Ngày tạo", "Ngày chỉnh sửa" );
            System.out.println ( "*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            int i = 1;
            for (Student student : studentByClass) {
                System.out.printf ( "|\t%-5d|%-20s|%-20s|%-30s|%-20s|%-20s|%-20s|%-30s|%-20s|%-20s|\n",
                        i, student.getCode (),
                        student.getClasses (),
                        student.getFullName (),
                        student.getGender (),
                        student.getDateOfBirth (),
                        student.getPhoneNumber (),
                        student.getEmail (),
                        InstanUtils.instantToStringDayTime ( student.getAddedAt () ),
                        student.getUpdatedAt () == null ? "" : InstanUtils.instantToStringDayTime ( student.getUpdatedAt () )
                );
                System.out.println ( "||−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−|−−−−−−−−−−−−−−−−−−−−||" );
                i++;
            }
            System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            System.out.println ( "Nhấn (1) để sắp xếp theo tên (A -> Z)  ||  (2) để mở tùy chọn" );
            int choises = AppUtils.retryChoose ( 1, 2 );
            switch (choises) {
                case 1:
                   //StudentView studenView = new StudentView(studentService);
//                    adminView.sorfStudentByNameADC ( studentByClass );
                    break;
                case 2:
                    AppUtils.isRetryAdmin ( InputOption.SHOW );
                    break;
                default:
                    System.out.print ( "Nhập sai, hãy nhập lại: " );
                    break;
            }
        }while (true);
    }

    @Override
    public boolean existsCode(long code) {
        List<Student> students = findAll ();
        for (Student student : students) {
            if ( student.getCode ()== ( code ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsEmail(String email) {
        List<Student> students = findAll ();
        for (Student student : students) {
            if ( student.getEmail ().equals ( email ) )
                return true;
        }
        return false;
    }

    @Override
    public boolean existsClass(String classes) {
        List<Student> students = findAll ();
        for (Student student : students) {
            if ( student.getClasses ().equals ( classes ) ) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean existsPhoneNumber(String phoneNumber) {
        List<Student> students = findAll ();
        for (Student student : students) {
            if ( student.getPhoneNumber ().equals ( phoneNumber ) )
                return true;
        }
        return false;
    }

    @Override
    public boolean checkNameStudent(String name) {
        List<Student> students = findAll ();
        for (Student student:students) {
            if ( student.getFullName ().toLowerCase ().contains ( name.toLowerCase () ) ){
                return true;
            }
        }
        return false;
    }
}
