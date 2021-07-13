package Manager;

import IOOperator.DocGhiFile;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    QuanLyDanhBa.xemDB();
                    break;
                case 2:
                    QuanLyDanhBa.themDB();
                    break;
                case 3:
                    QuanLyDanhBa.suaDB();
                    break;
                case 4:
                    QuanLyDanhBa.xoaDB();
                    break;
                case 5:
                    QuanLyDanhBa.timDB();
                    break;
                case 6:
                    System.out.println("Bạc có chắc muốn đọc File?");
                    System.out.println("1. Chắc");
                    System.out.println("2. Không");
                    int readChoice = Integer.parseInt(sc.nextLine());
                    if (readChoice == 1) {
                        QuanLyDanhBa.listDB = DocGhiFile.docFile();
                        break;
                    } else break;
                case 7:
                    System.out.println("Bạc có chắc muốn ghi File?");
                    System.out.println("1. Chắc");
                    System.out.println("2. Không");
                    int writeChoice = Integer.parseInt(sc.nextLine());
                    if (writeChoice == 1) {
                        DocGhiFile.ghiFile();
                        break;
                    } else break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
