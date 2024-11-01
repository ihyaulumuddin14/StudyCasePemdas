package StudyCasePemdas;
import java.util.Scanner;
public class TravelSewa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxTransaksi = 10; // Batas maksimum transaksi
        int[] nomorTransaksi = new int[maxTransaksi];
        String[] jenisLayanan = new String[maxTransaksi];
        String[] detailLayanan = new String[maxTransaksi];
        int[] jumlahTagihan = new int[maxTransaksi];
        int transaksiCounter = 1;
        int transaksiIndex = 0;
        boolean ulang = true;
        String[] rute = {
            "Surabaya - Malang", 
            "Madura - Malang", 
            "Banyuwangi - Malang", 
            "Situbondo - Malang", 
            "Tulungagung - Malang"
        };
        int[] harga = {100000, 200000, 250000, 175000, 125000};

        while (ulang) {
            System.out.println("\nSelamat datang di Filkom Tour and Travel");
            System.out.println("Pilih layanan yang Anda inginkan:");
            System.out.println("1. Travel");
            System.out.println("2. Sewa Mobil");
            System.out.println("3. Tampilkan Struk dan Selesai");
            System.out.print("Masukkan pilihan Anda (1, 2, atau 3): ");
            int pilihan = scan.nextInt();

            if (pilihan == 1 && transaksiIndex < maxTransaksi) {
                System.out.println("Pilih rute perjalanan:");
                for (int i = 0; i < rute.length; i++) {
                    System.out.println((i + 1) + ". " + rute[i]);
                }
                System.out.print("Masukkan nomor rute yang Anda pilih: ");
                int rutePilihan = scan.nextInt();

                if (rutePilihan < 1 || rutePilihan > rute.length) {
                    System.out.println("Pilihan rute tidak valid.");
                } else {
                    int hargaTravel = harga[rutePilihan - 1];
                    // Simpan transaksi
                    nomorTransaksi[transaksiIndex] = transaksiCounter++;
                    jenisLayanan[transaksiIndex] = "Travel";
                    detailLayanan[transaksiIndex] = rute[rutePilihan - 1];
                    jumlahTagihan[transaksiIndex] = hargaTravel;
                    transaksiIndex++;
                    System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                    System.out.println("----------------------------------------------------------");
                    System.out.printf("%-5d %-15s %-20s Rp %-12d\n", transaksiCounter - 1, "Travel", rute[rutePilihan - 1], hargaTravel);
                    System.out.println("==========================================================\n");
                }

            } else if (pilihan == 2 && transaksiIndex < maxTransaksi) {
                System.out.print("Masukkan lama sewa dalam jam: ");
                int sewaJam = scan.nextInt();
                int hargaRental;
                int hargaTambahan;
                if (sewaJam <= 5) {
                    hargaRental = 400000;
                    hargaTambahan = 100000;
                } else {
                    hargaRental = 500000;
                    hargaTambahan = 150000;
                }
                int hargaTotal = hargaRental + hargaTambahan;
                // Simpan transaksi
                nomorTransaksi[transaksiIndex] = transaksiCounter++;
                jenisLayanan[transaksiIndex] = "Sewa Mobil";
                detailLayanan[transaksiIndex] = sewaJam + " jam";
                jumlahTagihan[transaksiIndex] = hargaTotal;
                transaksiIndex++;
                System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                System.out.println("----------------------------------------------------------");
                System.out.printf("%-5d %-15s %-20s Rp %-12d\n", transaksiCounter - 1, "Sewa Mobil", sewaJam + " jam", hargaTotal);
                System.out.println("==========================================================\n");

            } else if (pilihan == 3) {
                System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                System.out.println("----------------------------------------------------------");
                int totalTagihan = 0;
                double diskon = 0.0;
                for (int i = 0; i < transaksiIndex; i++) {
                    System.out.printf("%-5d %-15s %-20s Rp %-12d\n", nomorTransaksi[i], jenisLayanan[i], detailLayanan[i], jumlahTagihan[i]);
                    totalTagihan += jumlahTagihan[i];
                }
                int subtotal = totalTagihan;
                System.out.println("----------------------------------------------------------");
                System.out.printf("%-42s Rp %-12d\n", "Subtotal:", subtotal);
                //Jika transaksi lebih dari 3 mendapatkan diskon
                if (transaksiIndex > 3) {
                    diskon = subtotal * 0.05; 
                    totalTagihan -= diskon;
                    System.out.printf("%-42s Rp %-12.0f\n", "Diskon 5%:", diskon);
                }
                System.out.printf("%-42s Rp %-12d\n", "Total Tagihan:", totalTagihan);
                System.out.println("==========================================================");
                System.out.println("\nTerima kasih telah menggunakan layanan Filkom Tour and Travel!");
                ulang = false; 
            } else if (pilihan != 3) {
                System.out.println("Maaf, jumlah maksimum transaksi telah tercapai.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }
}
