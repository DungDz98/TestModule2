package IOOperator;

import Classes.DanhBa;
import Manager.QuanLyDanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DocGhiFile {
    static File contacts = new File("./src/Data/contacts.csv");
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<DanhBa> docFile() {
            ArrayList<DanhBa> listDBnew = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(contacts));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(",");
                    if (str.length >= 6) {
                        listDBnew.add(new DanhBa(str[0].trim(), str[1].trim(), str[2].trim(), str[3].trim(), str[4].trim(), str[5].trim(), str[6].trim()));
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return listDBnew;
        }

    public static void ghiFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(contacts));
            for (DanhBa dv : QuanLyDanhBa.listDB) {
                bw.write(dv.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
