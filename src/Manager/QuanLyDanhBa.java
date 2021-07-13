package Manager;

import Classes.DanhBa;
import Validate.ValidateEmail;
import Validate.ValidateNgaySinh;
import Validate.ValidatePhoneNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDanhBa {
    public static ArrayList<DanhBa> listDB = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void xemDB() {
        if (listDB.size() < 1)
            System.out.println("Danh sách trống! Vui lòng thêm danh bạ");
        else {
            for (DanhBa db : listDB)
                System.out.println(db);
        }
    }

    public static void themDB() {
        listDB.add(taoDB());
    }

    public static void suaDB() {
        boolean check = false;
        while (true) {
            String sdt = getSdt();
            for (int i = 0; i < listDB.size(); i++) {
                if (listDB.get(i).getSdt().equals(sdt)) {
                    check = true;
                    listDB.set(i, taoDBNew(sdt));
                    break;
                }
                break;
            }
            if (!check)
                System.out.println("Không tìm được danh bạ với số điện thoại trên!");
            break;
        }
    }

    public static void xoaDB() {
        boolean check = false;
        while (true) {
            String sdt = getSdt();
            for (int i = 0; i < listDB.size(); i++) {
                if (listDB.get(i).getSdt().equals(sdt)) {
                    check = true;
                    System.out.println("Xác nhận xóa?");
                    System.out.println("1.Y");
                    System.out.println("2.N");
                    int delChoice = Integer.parseInt(sc.nextLine());
                    if (delChoice == 1) {
                        listDB.remove(i);
                        break;
                    } else
                        break;
                }
                break;
            }
            if (!check) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên!");
            }
            break;
        }

    }

    public static void timDB() {
        System.out.println("1. Tìm theo họ tên");
        System.out.println("2. Tìm theo số điện thoại");
        int findChoice = Integer.parseInt(sc.nextLine());
        while (true) {
            if (findChoice == 1) {
                System.out.println("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                for (DanhBa db : listDB) {
                    if (db.getHoTen().contains(hoTen))
                        System.out.println(db);
                }
                break;
            } else if (findChoice == 2) {
                System.out.println("Nhập số điện thoại: ");
                String sdt = sc.nextLine();
                for (DanhBa db : listDB) {
                    if (db.getSdt().contains(sdt))
                        System.out.println(db);
                }
                break;
            } else
                System.out.println("Lựa chọn không hợp lệ. Mời nhập lại");
            break;
        }
    }

    private static DanhBa taoDB() {
        System.out.println("Thông tin của danh bạ");
        String sdt = getSdt();
        String nhom = getNhom();
        String hoTen = getHoTen();
        String gioiTinh = getGioiTinh();
        String diaChi = getDiaChi();
        String ngaySinh = getNgaySinh();
        String email = getEmail();
        return new DanhBa(sdt, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
    }

    private static DanhBa taoDBNew(String sdt) {
        String nhom = getNhom();
        String hoTen = getHoTen();
        String gioiTinh = getGioiTinh();
        String diaChi = getDiaChi();
        String ngaySinh = getNgaySinh();
        String email = getEmail();
        return new DanhBa(sdt, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
    }

    private static String getSdt() {
        while (true) {
            try {
                System.out.println("Nhập số điện thoại(0xxxxxxxxx): ");
                String sdt = sc.nextLine();
                if (!ValidatePhoneNumber.validate(sdt))
                    throw new Exception();
                else return sdt;
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getNhom() {
        while (true) {
            try {
                System.out.println("Nhập nhóm: ");
                String nhom = sc.nextLine();
                return nhom;
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getHoTen() {
        while (true) {
            try {
                System.out.println("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                return hoTen;
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getGioiTinh() {
        while (true) {
            try {
                System.out.println("Nhập giới tính(Nam/Nữ): ");
                String gioiTinh = sc.nextLine();
                if (gioiTinh.equals("Nam") || gioiTinh.equals("Nữ"))
                    return gioiTinh;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getDiaChi() {
        while (true) {
            try {
                System.out.println("Nhập địa chỉ: ");
                String diaChi = sc.nextLine();
                return diaChi;
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getNgaySinh() {
        while (true) {
            try {
                System.out.println("Nhập ngày sinh: ");
                String ngaySinh = sc.nextLine();
                if (ValidateNgaySinh.validate(ngaySinh))
                    return ngaySinh;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }

    private static String getEmail() {
        while (true) {
            try {
                System.out.println("Nhập email: ");
                String email = sc.nextLine();
                if (ValidateEmail.validate(email))
                    return email;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("Sai định dạng. Nhập lại");
            }
        }
    }


}
