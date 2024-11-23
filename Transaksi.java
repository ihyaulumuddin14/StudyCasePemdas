package StudyCasePemdas;
import java.util.Scanner;
public class Transaksi {
    private int maxTransaksi = 10;
    private Transaksi[] daftarTransaksi = new Transaksi[maxTransaksi];
    private String jenisLayanan;
    private String detailLayanan;
    private int nomorTransaksi;
    private int jumlahTagihan;
    private int transaksiCounter = 1;
    private int transaksiIndex = 0;
    private String[] rute = {
        "Surabaya - Malang", 
        "Madura - Malang",
        "Banyuwangi - Malang",
        "Situbondo - Malang",
        "Tulungagung - Malang"
    };
    private int[] harga = {100000, 200000, 250000, 175000, 125000};


    //Conctructor
    public Transaksi() {
        jenisLayanan = "";
        detailLayanan = "";
        nomorTransaksi = 0;
        jumlahTagihan = 0;
    }

    
    public void transaksiTravel(Scanner in) {
        
        if (transaksiIndex >= maxTransaksi) {
            System.out.println("Jumlah maksimum transaksi telah tercapai.");
            return;
        }

        System.out.println("\n\nJika transaksi yang akan anda lakukan lebih 3, akan terdapat DISKON sebanyak 5%!!!");
        System.out.println("==================================================================================");
        System.out.println("Pilih rute perjalanan:");
        for (int i = 0; i < rute.length; i++) {
            System.out.println((i + 1) + ". " + rute[i]);
        }
        System.out.print("Masukkan nomor rute yang Anda pilih: ");
        int rutePilihan = in.nextInt();

        if (rutePilihan < 1 || rutePilihan > rute.length) {
            System.out.println("Pilihan rute tidak valid.");
        } else {
            int hargaTravel = harga[rutePilihan - 1];
            daftarTransaksi[transaksiIndex] = new Transaksi();
            daftarTransaksi[transaksiIndex].nomorTransaksi = transaksiCounter++;
            daftarTransaksi[transaksiIndex].jenisLayanan = "Travel";
            daftarTransaksi[transaksiIndex].detailLayanan = rute[rutePilihan - 1];
            daftarTransaksi[transaksiIndex].jumlahTagihan = hargaTravel;
            transaksiIndex++;
            
            struk("Travel", rute[rutePilihan - 1], hargaTravel);
        }

    }

    public void transaksiSewaMobil(Scanner in, PengelolaanMobil kelolaMobil) {

        if (kelolaMobil.getJumlahMobil() == 0) {
            System.out.println("Tidak ada mobil untuk disewa.");
            return;
        }

        System.out.println("\n\nJika transaksi yang akan anda lakukan lebih 3, akan terdapat DISKON sebanyak 5%!!!");
        System.out.println("==================================================================================");
        System.out.println("\nPilih mobil yang ingin disewa:");
        for (int i = 0; i < kelolaMobil.getJumlahMobil(); i++) {
            System.out.printf("%d. %s (%s)\n", (i + 1), kelolaMobil.getDaftarMobil()[i].getMerkMobil(), kelolaMobil.getDaftarMobil()[i].getNoPlat());
        }

        System.out.print("Masukkan nomor mobil yang ingin disewa: ");
        int mobilPilihan = in.nextInt() - 1; // Input mobil pilihan

        if (mobilPilihan < 0 || mobilPilihan >= kelolaMobil.getJumlahMobil()) {
            System.out.println("Pilihan mobil tidak valid.");
        } else {
            System.out.print("Masukkan lama sewa dalam jam: ");
            int sewaJam = in.nextInt();
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
            daftarTransaksi[transaksiIndex] = new Transaksi();
            daftarTransaksi[transaksiIndex].nomorTransaksi = transaksiCounter++;
            daftarTransaksi[transaksiIndex].jenisLayanan = "Sewa Mobil";
            daftarTransaksi[transaksiIndex].detailLayanan = kelolaMobil.getDaftarMobil()[mobilPilihan].getMerkMobil() + " - " + sewaJam + " jam";
            daftarTransaksi[transaksiIndex].jumlahTagihan = hargaTotal;
            transaksiIndex++;

            struk("Sewa Mobil", daftarTransaksi[transaksiIndex-1].detailLayanan, hargaTotal);
        }

    }


    private void struk(String layanan, String detail, int tagihan) {
        System.out.println("=====================================================");
        System.out.println("Layanan        | Detail                | Tagihan (Rp)");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-14s | %-21s | Rp %-12d\n", layanan, detail, tagihan);
        System.out.println("=====================================================");
    }


    public void tampilkanStruk() {
        if (transaksiIndex == 0) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("\nSemua Struk Transaksi:");
            System.out.println("===========================================================");
            System.out.println("No  | Layanan        | Detail                | Tagihan (Rp)");
            System.out.println("-----------------------------------------------------------");
            int subtotal = 0;
            for (int i = 0; i < transaksiIndex; i++) {
                System.out.printf("%-3d | %-14s | %-21s | Rp %-12d\n", (i + 1), daftarTransaksi[i].jenisLayanan, daftarTransaksi[i].detailLayanan, daftarTransaksi[i].jumlahTagihan);
                subtotal += daftarTransaksi[i].jumlahTagihan;
            }

            // Hitung diskon jika transaksi lebih dari 3
            double diskon = 0;
            if (transaksiIndex > 3) {
                diskon = subtotal * 0.05; 
            }
            double totalTagihan = subtotal - diskon;

            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-46s Rp %-12d\n", "Subtotal:", subtotal);
            System.out.printf("%-46s Rp %-12.0f\n", "Diskon (5%):", diskon);
            System.out.printf("%-46s Rp %-12.0f\n", "Total Tagihan:", totalTagihan);
            System.out.println("===========================================================");
        }
    }
}
