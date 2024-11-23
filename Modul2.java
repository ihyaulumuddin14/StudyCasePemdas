package StudyCasePemdas;
import java.util.Scanner;
public class Modul2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InputDataMobil dataMobil = new InputDataMobil();
        InputDataSewaDanTravel transaksi = new InputDataSewaDanTravel();

        boolean menuMobil = true;
        boolean run = true;
        while (run) 
        if (menuMobil) {
        System.out.println("\nMenu Input Data Mobil:");
        System.out.println("1. Input Data Mobil");
        System.out.println("2. Lihat Data Mobil");
        System.out.println("3. Lanjut ke Menu Travel dan Sewa");
        System.out.print("Masukkan menu pilihan: ");
        int pilihan = in.nextInt();
        in.nextLine();
        switch (pilihan) {
            case 1:
                dataMobil.tambahMobil(in);
                break;
            case 2:
                dataMobil.lihatData();
                break;
            case 3:
                menuMobil = false;
                System.out.println("Anda telah menyelesaikan penginputan data mobil.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
            }
        } else {
            System.out.println("\nMenu Sewa dan Travel:");
            System.out.println("1. Travel");
            System.out.println("2. Sewa Mobil");
            System.out.println("3. Tampilkan Struk Keseluruhan");
            System.out.println("4. Kembali ke Menu Input Data Mobil");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            int pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1:
                    transaksi.transaksiTravel(in);
                    break;
                case 2:
                    transaksi.transaksiSewaMobil(in, dataMobil);
                    break;
                case 3:
                    transaksi.tampilkanStruk();
                    break;
                case 4:
                    menuMobil = true;
                    break;
                case 0:
                    run = false; 
                    System.out.println("Terima kasih telah menggunakan layanan Filkom Tour and Travel!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
