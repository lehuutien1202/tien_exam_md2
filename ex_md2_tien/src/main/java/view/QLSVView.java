package view;

import Services.IStudentServices;
import Utils.AppUtils;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Scanner;

public class QLSVView {
    Scanner scanner = new Scanner(System.in);


    public void runAdmin() {

        StudentView studenView = new StudentView();
        System.out.println(" * * * * * * * * * Admin * * * * * * ** * *");
        System.out.println(" *                                        *");
        System.out.println(" *   1. Hiển Thị Danh Sách SV             *");
        System.out.println(" *   2. Đăng Ký Học Viên Mới              *");
        System.out.println(" *   3. Sửa Thông Tin SV                  *");
        System.out.println(" *   4. Xóa                               *");
        System.out.println(" *   5. Tìm                               *");
        System.out.println(" *   6. thoát                              *");
        System.out.println(" *                                       *");
        System.out.println(" * * * * * * ** * * * * * * * * * * * * * *");
        System.out.println("Chon chuc nang:");
        int choice = AppUtils.retryChoose(1, 6);

    switch (choice) {
        case 1:
            studenView.showStudentList();
            break;
        case 2:
            studenView.addStudent();
            break;
        case 3:
            studenView.editStudent();
            break;
        case 4:
            studenView.removeStudent();
            break;
        case 5:
            SearchSt searchSt = new SearchSt();
            searchSt.searchStudent();
            break;

        case 6:
            AppUtils.exit();
    }
}
}
