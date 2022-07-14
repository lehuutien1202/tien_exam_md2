package view;

import Model.Student;
import Services.IStudentServices;
import Services.StudentServices;
import Utils.AppUtils;
import Utils.ValidateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class StudentView {
    private static final Scanner input = new Scanner ( System.in );
    private IStudentServices studentService;
    public StudentView() {
        studentService = StudentServices.getInstance ();
    }

    public void addStudent() {
        do {
            System.out.println ( "\t * * * * * * * * * * * * * * * * * *" );
            System.out.println ( "\t *      Thêm Sinh Viên Mới        * " );
            System.out.println ( "\t * * * * * * * * * * * * * * * * * *" );
            String classes = inputClass ( InputOption.ADD );
            String fullName = inputFullName ( InputOption.ADD );
            String gender = inputGender ( InputOption.ADD );
            String dayOfBirth = inputDate ( InputOption.ADD );
            String phoneNumber = inputPhoneNum ( InputOption.ADD );
            String email = inputEmail ( InputOption.ADD );
            Student newStudent = new Student ( classes, fullName, gender, dayOfBirth, phoneNumber, email);
            studentService.add ( newStudent );
            System.out.println ();
            System.out.println ( "Đã thêm thành công!" );
            System.out.println ();
            AppUtils.isRetryAdmin ( InputOption.ADD );
        } while (true);
    }
    public void showStudentList() {
        do {
            ShowListStudent show = new ShowListStudent ();
            show.showAll();

        } while (true);
    }
    public void editStudent() {

        ShowListStudent show = new ShowListStudent ();
        show.showAllToAction();
        System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
        long code = inputCode ( InputOption.UPDATE );
        do {
            Student student = studentService.getByCode ( code );
            System.out.println ();
            System.out.println ();
            System.out.println ( "➧➧➧➧➧➧➧ Thông tin học viên cần chỉnh sửa: " );
            System.out.printf ( "Mã học viên: %s\nLớp học: %s\nHọ tên: %s\nGiới tính: %s\nNgày sinh: %s\nSố điện thoại: %s\nEmail: %s\n",
                    student.getCode (), student.getClasses (), student.getFullName (), student.getGender (), student.getDateOfBirth (), student.getPhoneNumber (), student.getEmail () );
            System.out.println ();
            System.out.println ( "* * * * * * * * ✎ CHỈNH SỬA ✎ * * * * * * * * " );
            System.out.println ( "*            ✍ 1. Lớp học                        *" );
            System.out.println ( "*            ✍ 2. Tên                            *" );
            System.out.println ( "*            ✍ 3. Giới tính                      *" );
            System.out.println ( "*            ✍ 4. Ngày sinh                      *" );
            System.out.println ( "*            ✍ 5. Số điện thoại                  *" );
            System.out.println ( "*            ✍ 6. Email                          *" );
            System.out.println ( "*            ✍ 7. Chỉnh sửa toàn bộ              *" );
            System.out.println ( "*            ✍ 8. Tùy chọn                       *" );
            System.out.println ( "* * * * * * * * * * * * * * * * * * * * * * * * " );
            int option = AppUtils.retryChoose ( 1, 8 );
            Student afterStudent = new Student ();
            afterStudent.setCode ( code );
            Student student_edit = studentService.getByCode ( code );
            switch (option) {
                case 1:
                    System.out.println ( "Lớp học hiện tại: " + student_edit.getClasses () );
                    String classes = inputClass ( InputOption.UPDATE );
                    afterStudent.setClasses ( classes );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi lớp học thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 2:
                    System.out.println ( "Tên hiện tại: " + student_edit.getFullName () );
                    String name = inputFullName ( InputOption.UPDATE );
                    afterStudent.setFullName ( name );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi tên thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 3:
                    System.out.println ( "Giới tính hiện tại: " + student_edit.getGender () );
                    String gender = inputGender ( InputOption.UPDATE );
                    afterStudent.setGender ( gender );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi giới tính thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 4:
                    System.out.println ( "Ngày sinh hiện tại: " + student_edit.getDateOfBirth () );
                    String dayOfBirth = inputDate ( InputOption.UPDATE );
                    afterStudent.setDateOfBirth ( dayOfBirth );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi ngày sinh thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 5:
                    System.out.println ( "Số điện thoại hiện tại: " + student_edit.getPhoneNumber () );
                    String phoneNum = inputPhoneNum ( InputOption.UPDATE );
                    afterStudent.setPhoneNumber ( phoneNum );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi số điện thoại thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 6:
                    System.out.println ( "Email hiện tại: " + student_edit.getEmail () );
                    String email = inputEmail ( InputOption.UPDATE );
                    afterStudent.setEmail ( email );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi email thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 7:
                    System.out.println ( "Lớp học hiện tại: " + student_edit.getClasses () );
                    String classesEdit = inputClass ( InputOption.UPDATE );
                    afterStudent.setClasses ( classesEdit );
                    System.out.println ( "Tên hiện tại: " + student_edit.getFullName () );
                    String nameEdit = inputFullName ( InputOption.UPDATE );
                    afterStudent.setFullName ( nameEdit );
                    System.out.println ( "Giới tính hiện tại: " + student_edit.getGender () );
                    String genderEdit = inputGender ( InputOption.UPDATE );
                    afterStudent.setGender ( genderEdit );
                    System.out.println ( "Ngày sinh hiện tại: " + student_edit.getDateOfBirth () );
                    String dayOfBirthEdit = inputDate ( InputOption.UPDATE );
                    afterStudent.setDateOfBirth ( dayOfBirthEdit );
                    System.out.println ( "Số điện thoại hiện tại: " + student_edit.getPhoneNumber () );
                    String phoneNumEdit = inputPhoneNum ( InputOption.UPDATE );
                    afterStudent.setPhoneNumber ( phoneNumEdit );
                    System.out.println ( "Email hiện tại: " + student_edit.getEmail () );
                    String emailEdit = inputEmail ( InputOption.UPDATE );
                    afterStudent.setEmail ( emailEdit );
                    studentService.edit ( afterStudent );
                    System.out.println ( "✑✑ Thay đổi thành công ✑✑" );
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
                case 8:
                    AppUtils.isRetryAdmin ( InputOption.UPDATE );
                    break;
            }
        } while (true);
    }
    public void removeStudent() {
        do {
            ShowListStudent show = new ShowListStudent ();
            show.showAllToAction();
            long code;
            code = inputCode ( InputOption.DELETE );
            Student student = studentService.getByCode ( code );
            System.out.println ();
            System.out.println ( "-------- Thông tin học viên muốn xóa: " );
            System.out.printf ( "Mã học viên: %s\nLớp học: %s\nHọ tên: %s\nGiới tính: %s\nNgày sinh: %s\nSố điện thoại: %s\nEmail: %s\n",
                    student.getCode (), student.getClasses (), student.getFullName (), student.getGender (), student.getDateOfBirth (), student.getPhoneNumber (), student.getEmail () );
            System.out.println ();
            System.out.println ( "* * *BẠN CÓ CHẮC MUỐN XÓA* * *" );
            System.out.println ( "*                              *" );
            System.out.println ( "*        ▫ 1. Xác nhận         *" );
            System.out.println ( "*        ▪ 2. Hủy bỏ           *" );
            System.out.println ( "*                              *" );
            System.out.println ( "* * * * * - - - - - - * * * * *" );
            int option = AppUtils.retryChoose ( 1, 2 );
            if ( option == 1 ) {
                studentService.deleteByCode ( code );
                System.out.println ( "Đã xóa thành công!" );
                AppUtils.isRetryAdmin ( InputOption.DELETE );
            } else if ( option == 2 ) {
                AppUtils.isRetryAdmin ( InputOption.DELETE );
            }
        } while (true);
    }
    public long inputCode(InputOption option) {
        switch (option) {
            case DELETE:
                System.out.print ( "Nhập mã học viên muốn xóa: " );
                break;
            case UPDATE:
                System.out.print ( "Nhập mã học viên muốn sửa: " );
                break;
            case INFO:
                System.out.print ( "Nhập mã học viên muốn thêm thông tin: " );
                break;
        }
        long code = AppUtils.retryParseLong();
        do {
            if ( !studentService.existsCode ( code ) ) {
                System.out.print ( "Mã học viên không tồn tại, hãy nhập lại: " );
                continue;
            }
            break;
        } while (true);
        return code;
    }
    public String inputClass(InputOption option) {
        String classes;
        switch (option) {
            case ADD -> System.out.print("Nhập lớp học: ");
            case UPDATE -> System.out.print("Nhập lớp học muốn thay đổi: ");
        }
        classes = AppUtils.retryString ( "Tên lớp" );
        return classes;
    }
    public String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.print ( "Nhập họ và tên (VD: Le Huu Tien): " );
                break;
            case UPDATE:
                System.out.print ( "Nhập tên muốn thay đổi: " );
                break;
            case INFO:
                System.out.print ( "Nhập họ và tên người thân: " );
                break;
            case SEARCH:
                System.out.print ( "Nhập tên học viên cần tìm kiếm: " );
        }
        String fullName;
        do {
            if ( !ValidateUtils.fullNameValid ( fullName = AppUtils.retryString ( "Họ và tên" ) ) ) {
                System.out.print ( fullName + " không đúng định dạng, hãy nhập lại (VD: Le Huu Tien): " );
                continue;
            }
            break;
        } while (true);
        return fullName;
    }

    public String inputGender(InputOption option) {
        String gender = "";
        System.out.println ( " * * * GIỚI TÍNH * * * *" );
        System.out.println ( " *     ▫ 1. Nam       * " );
        System.out.println ( " *     ▪ 2. Nữ        * " );
        System.out.println ( " *     ▫ 3. Khác      * " );
        System.out.println (" * * * * * * * * * * * * *");
        int options = AppUtils.retryChoose ( 1, 3 );
        if ( options == 1 ) {
            gender = "Nam";
        } else if ( options == 2 ) {
            gender = "Nữ";
        } else if ( options == 3 ) {
            gender = "Khác";
        }
        return gender;
    }
    public String inputDate(InputOption option) {
        switch (option) {
            case ADD:
                System.out.print ( "Nhập ngày sinh (dd-MM-yyyy): " );
                break;
            case UPDATE:
                System.out.print ( "Nhập ngày sinh muốn thay đổi (dd-MM-yyyy): " );
                break;
            case INFO:
                System.out.print ( "Nhập ngày cấp (dd-MM-yyyy): " );
                break;
            case ADMISSION:
                System.out.print ( "Nhập học ngày (dd-MM-yyyy): " );
                break;
        }
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd-MM-yyyy" );
        String date;
        do {
            if ( !ValidateUtils.dateValid ( date = AppUtils.retryString ( "Ngày sinh" ) ) ) {
                System.out.print ( date + " không đúng, hãy nhập lại: " );
                continue;
            }
            try {
                Date dateinput = sdf.parse ( date );
                int compareTime = dateinput.compareTo ( Date.from ( Instant.now () ) );
                if ( compareTime > 0 ) {
                    System.out.print ( "Thời gian không hợp lệ, hãy nhập lại: " );
                    continue;
                }
            } catch (ParseException e) {
                System.out.print ( date + " nhập sai, hãy nhập lại: " );
            }
            break;
        } while (true);
        return date;
    }
    public String inputPhoneNum(InputOption option) {
        switch (option) {
            case ADD:
                System.out.print ( "Nhập số điện thoại: " );
                break;
            case UPDATE:
                System.out.print ( "Nhập số điện thoại muốn sửa: " );
                break;
            case INFO:
                System.out.print ( "Nhập số điện thoại của người thân: " );
                break;
        }
        String phoneNum;
        do {
            switch (option) {
                case ADD:
                case UPDATE:
                case INFO:
                    if ( !ValidateUtils.phoneNumValid ( phoneNum = AppUtils.retryString ( "Số điện thoại" ) ) ) {
                        System.out.print ( phoneNum + " không đúng định dạng, hãy nhập lại:" );
                        continue;
                    }
                    if ( studentService.existsPhoneNumber ( phoneNum ) ) {
                        System.out.print ( "Số điện thoại đã tồn tại, hãy nhập lại: " );
                        continue;
                    }
                    return phoneNum;
//                    break;
                case SEARCH:
                    if ( !ValidateUtils.phoneNumValid ( phoneNum = AppUtils.retryString ( "Số điện thoại" ) ) ) {
                        System.out.print ( phoneNum + " không đúng định dạng, hãy nhập lại: " );
                        continue;
                    }
                    if ( !studentService.existsPhoneNumber ( phoneNum ) ) {
                        System.out.print ( "Số điện thoại không tồn tại, hãy nhập lại: " );
                        continue;
                    }
                    return phoneNum;
//                    break;
            }
        } while (true);
    }
    public String inputEmail(InputOption add) {
        System.out.print ( " Email đăng nhập: " );
        String email;
        do {
            if ( !ValidateUtils.emailValid ( email = AppUtils.retryString ( "Email đăng nhập" ) ) ) {
                System.out.print ( email + " không đúng, hãy nhập lại: " );
                continue;
            }
            if ( studentService.existsEmail ( email ) ) {
                System.out.print ( "Email đã tồn tại, hãy nhập lại: " );
                continue;
            }
            break;
        } while (true);
        return email;
    }
}
