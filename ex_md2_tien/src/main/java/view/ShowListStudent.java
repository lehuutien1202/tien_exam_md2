package view;

import Model.Student;
import Services.StudentServices;
import Utils.AppUtils;
import Utils.InstanUtils;

import java.util.List;

public class ShowListStudent {
    public void showAll(){
        do {
            System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            System.out.println ( "|                                                                                ++++   DANH SÁCH HỌC VIÊN    ++++                                                                                                        |" );
            System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );

            System.out.printf ( "||\t%-5s|%-20s|%-20s|%-30s|%-20s|%-20s|%-20s|%-30s|%-20s|%-20s||\n",
                    "STT", "Mã Học Viên", "Lớp", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Ngày tạo", "Ngày chỉnh sửa" );
            System.out.println ( "*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
            StudentServices studentServices = new StudentServices ();
            List<Student> students = studentServices.findAll ();
            int i = 1;
            for (Student student : students) {
                System.out.printf ( "||\t%-5d|%-20s|%-20s|%-30s|%-20s|%-20s|%-20s|%-30s|%-20s|%-20s||\n",
                        i, student.getCode (),
                        student.getClasses (),
                        student.getFullName(),
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
            AppUtils.isRetryAdmin(InputOption.SHOW);
            //            System.out.println ( "Nhấn (1) để sắp xếp theo tên (A -> Z) ||  (2) để mở tùy chọn" );
//            int choises_11 = AppUtils.retryChoose ( 1, 2 );
//            switch (choises_11) {
//                case 1:
//                    AdminView adminView = new AdminView ();
//                    adminView.sorfStudentByNameADC (students);
//                    break;
//                case 2:
//                    AppUtils.isRetryAdmin ( InputOption.SHOW );
//                    break;
//            }
        }while (true);
    }
    public void showAllToAction(){

        System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );
        System.out.println ( "|                                                                                ++++   DANH SÁCH HỌC VIÊN    ++++                                                                                                        |" );
        System.out.println ( "*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*" );

        System.out.printf ( "||\t%-5s|%-20s|%-20s|%-30s|%-20s|%-20s|%-20s|%-30s|%-20s|%-20s||\n",
                "STT", "Mã Học Viên", "Lớp", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Ngày tạo", "Ngày chỉnh sửa" );
        System.out.println ( "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+" );
        StudentServices studentServices = new StudentServices ();
        List<Student> students = studentServices.findAll ();
        int i = 1;
        for (Student student : students) {
            System.out.printf ( "||\t%-5d|%-20s|%-20s|%-30s|%-20s|%-20s|%-20s|%-30s|%-20s|%-20s||\n",
                    i, student.getCode (),
                    student.getClasses (),
                    student.getFullName(),
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

    }
}
