/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB_5;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Deltaviyahya
 */
public class MainBukuTamu {
     static ArrayList<BukuTamu> listTamu = new ArrayList<>();
    static ArrayList<Pesan> pesanTamu = new ArrayList<>();
    static Scanner scn;
    static int loggedID = 0;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        while (true) {
            if (loggedID > 0) {
                System.out.print("Selamat datang di buku tamu!\nAnda login sebagai : " + listTamu.get(loggedID - 1).getNama() + "\n1. Lihat daftar Tamu\n2. Isi Buku Tamu\n3. Lihat Buku Tamu\n4. Logout\n5. Kelua\nMasukkan pilihan : ");
                int pil = scn.nextInt();
                scn.nextLine(); //cast enter

                switch (pil) {
                    case 1:
                        MainBukuTamu.showTamu();
                        break;
                    case 2:
                        MainBukuTamu.isiPesan();
                        break;
                    case 3:
                        MainBukuTamu.showPesan();
                        break;
                    case 4:
                        MainBukuTamu.logoutTamu();
                        break;
                    case 5:
                        MainBukuTamu.exit();
                        break;
                    default:
                        System.out.println("Maaf menu tidak ditemukan.");
                        break;
                }
            } else {
                System.out.print("Selamat datang di buku tamu!\n1. Daftar\n2. Login\n3. Lihat Daftar Tamu\n4. Lihat Buku Tamu\n5. Logout\n6. Exit\nMasukkan pilihan : ");
                int pil = scn.nextInt();
                scn.nextLine(); //cast enter

                switch (pil) {
                    case 1:
                        MainBukuTamu.addTamu();
                        break;
                    case 2:
                        MainBukuTamu.loginTamu();
                        break;
                    case 3:
                        MainBukuTamu.showTamu();
                        break;
                    case 4:
                        MainBukuTamu.showPesan();
                        break;
                    case 5:
                        MainBukuTamu.logoutTamu();
                        break;
                    case 6:
                        MainBukuTamu.exit();
                        break;
                    default:
                        System.out.println("Maaf menu tidak ditemukan.");
                        break;
                }
            }
        }
    }

    private static void addTamu() {
        BukuTamu tamu = new BukuTamu();
        //set id tamu, get arraylist size and increment 1
        tamu.setId(listTamu.size() + 1);
        //set nama
        System.out.print("Masukkan Nama Anda  : ");
        tamu.setNama(scn.nextLine());
        System.out.print("Masukkan Email Anda : ");
        tamu.setEmail(scn.nextLine());
        System.out.print("Apakah data yang anda masukkan sudah benar ? (Y/N) : ");
        if (scn.next().equalsIgnoreCase("Y")) {
            listTamu.add(tamu);
            System.out.println("\nPendaftaran berhasil!\nID User : " + tamu.getId() + "\nNAMA : " + tamu.getNama() + "\nEMAIL : " + tamu.getEmail() + "\n");
        }
    }

    private static void loginTamu() {
        BukuTamu tamus = new BukuTamu();
        System.out.print("Masukkan id user : ");
        tamus.setId(scn.nextInt());
        scn.nextLine();
        System.out.print("Masukkan email : ");
        tamus.setEmail(scn.nextLine());
        boolean found = false;
        for (BukuTamu list : listTamu) {
            if (list.getId() == tamus.getId() && list.getEmail().equalsIgnoreCase(tamus.getEmail())) {
                System.out.println("Login Berhasil!");
                loggedID = tamus.getId();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User tidak ditemukan");
        }
    }

    private static void isiPesan() {
        Pesan pesan = new Pesan();
        System.out.print("Kepada : ");
        pesan.setKepada(scn.nextLine());
        System.out.print("Isi Pesan : ");
        pesan.setPesan(scn.nextLine());
        pesan.setId_tamu(loggedID - 1);
        System.out.print("Apakah data yang anda masukkan sudah benar ? (Y/N) : ");
        if (scn.next().equalsIgnoreCase("Y")) {
            pesanTamu.add(pesan);
            System.out.println("Pesan berhasil di tambahkan!");
        }
    }
    
    private static void showTamu(){
        for(BukuTamu tamu : listTamu){
            System.out.println("=============================");
            System.out.println("ID : " + tamu.getId());
            System.out.println("Nama : " + tamu.getNama());
            System.out.println("Email : " + tamu.getEmail());
            System.out.println("=============================");
        }
    }

    private static void showPesan() {
        if (loggedID > 0) {
            System.out.println("Anda telah login dengan akun : " + listTamu.get(loggedID - 1).getNama() + " list pesan akan difilter berdasarkan id anda.\n Jika anda ingin melihat pesan dari tamu lain silahkan logout.");
            for (Pesan pesans : pesanTamu) {
                if (pesans.getId_tamu() == (loggedID - 1)) {
                    System.out.println("===========================");
                    System.out.println("Kepada : " + pesans.getKepada());
                    System.out.println("Dari : " + listTamu.get(pesans.getId_tamu()).getNama());
                    System.out.println("Isi Pesan : " + pesans.getPesan());
                    System.out.println("===========================");
                }
            }
        } else {
            for (Pesan pesans : pesanTamu) {
                System.out.println("===========================");
                System.out.println("Kepada : " + pesans.getKepada());
                System.out.println("Dari : " + listTamu.get(pesans.getId_tamu()).getNama());
                System.out.println("Isi Pesan : " + pesans.getPesan());
                System.out.println("===========================");
            }
        }
    }

    private static void logoutTamu() {
        loggedID = 0;
        System.out.println("Anda telah logout.");
    }
    
    private static void exit(){
        System.exit(0);
    }
    
}
