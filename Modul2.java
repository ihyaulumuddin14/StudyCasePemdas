package StudyCasePemdas;
import java.util.Scanner;
public class Modul2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PengelolaanMobil kelolaMobil = new PengelolaanMobil();
        Transaksi transaksi = new Transaksi();
        boolean menuMobil = true;
        boolean run = true;

        while (run) {
            if (menuMobil) {
                System.out.println("\nMenu Input Data Mobil:");
                System.out.println("1. Input Data Mobil");
                System.out.println("2. Lihat Data Mobil");
                System.out.println("3. Lanjut ke Menu Travel dan Sewa");
                System.out.print("Masukkan menu pilihan: ");
                int pilihan = in.nextInt();
                in.nextLine();
                
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("Pilih jenis mobil:");
                        System.out.println("1. Regular");
                        System.out.println("2. Supercar");
                        System.out.print("Masukkan pilihan: ");
                        int jenis = in.nextInt();
                        in.nextLine();
                        kelolaMobil.tambahMobil(in, jenis);
                    }
                    case 2 -> kelolaMobil.lihatData();
                    case 3 -> {
                        menuMobil = false;
                        System.out.println("Anda telah menyelesaikan penginputan data mobil.");
                    }
                    default -> System.out.println("Pilihan tidak valid.");
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
                    case 1 -> transaksi.transaksiTravel(in);
                    case 2 -> transaksi.transaksiSewaMobil(in, kelolaMobil);
                    case 3 -> transaksi.tampilkanStruk();
                    case 4 -> menuMobil = true;
                    case 0 -> {
                        run = false; 
                        System.out.println("Terima kasih telah menggunakan layanan Filkom Tour and Travel!");
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }   
        }
    }
}
