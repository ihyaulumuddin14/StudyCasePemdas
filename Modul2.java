import java.util.Scanner;
public class Modul2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;
        boolean run = true;

        // Data mobil
        int panjangArray = 0;
        String[] noPlat = new String[0];
        String[] merkMobil = new String[0];
        String[] warnaMobil = new String[0];
        short[] tahunkeluaran = new short[0];
        String[] jenisMobil = new String[0];
        int[] horsePower = new int[0];

        while (run) {
            System.out.println("\nMenu Input Data Mobil:");
            System.out.println("1. Input Data Mobil");
            System.out.println("2. Lihat Data Mobil");
            System.out.println("0. Selesai dan Lanjut ke Menu Sewa");
            System.out.print("Masukkan menu pilihan: ");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1 -> {
                    String[] tmpnoPlat = new String[panjangArray + 1];
                    String[] tmpmerkMobil = new String[panjangArray + 1];
                    String[] tmpwarnaMobil = new String[panjangArray + 1];
                    short[] tmptahunkeluaran = new short[panjangArray + 1];
                    String[] tmpjenisMobil = new String[panjangArray + 1];
                    int[] tmphorsePower = new int[panjangArray + 1];

                    for (int i = 0; i < panjangArray; i++) {
                        tmpnoPlat[i] = noPlat[i];
                        tmpmerkMobil[i] = merkMobil[i];
                        tmpwarnaMobil[i] = warnaMobil[i];
                        tmptahunkeluaran[i] = tahunkeluaran[i];
                        tmpjenisMobil[i] = jenisMobil[i];
                        tmphorsePower[i] = horsePower[i];
                    }

                    System.out.println("Pilih jenis mobil:");
                    System.out.println("1. Regular");
                    System.out.println("2. Supercar");
                    System.out.print("Masukkan pilihan: ");
                    int jenis = in.nextInt();
                    in.nextLine();

                    if (jenis == 1) {
                        tmpjenisMobil[panjangArray] = "Regular";
                        tmphorsePower[panjangArray] = 0; 
                        System.out.printf("%-15s: ", "Plat nomor? ");
                        tmpnoPlat[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Merk mobil? ");
                        tmpmerkMobil[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Warna mobil? ");
                        tmpwarnaMobil[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Tahun keluaran? ");
                        tmptahunkeluaran[panjangArray] = in.nextShort();
                        in.nextLine();
                    } else if (jenis == 2) {
                        tmpjenisMobil[panjangArray] = "Supercar";
                        System.out.printf("%-15s: ", "Plat nomor? ");
                        tmpnoPlat[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Merk mobil? ");
                        tmpmerkMobil[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Warna mobil? ");
                        tmpwarnaMobil[panjangArray] = in.nextLine();
                        System.out.printf("%-15s: ", "Tahun keluaran? ");
                        tmptahunkeluaran[panjangArray] = in.nextShort();
                        in.nextLine();
                        System.out.printf("%-15s: ", "Horse Power? ");
                        tmphorsePower[panjangArray] = in.nextInt();
                        in.nextLine();
                    }

                    noPlat = tmpnoPlat;
                    merkMobil = tmpmerkMobil;
                    warnaMobil = tmpwarnaMobil;
                    tahunkeluaran = tmptahunkeluaran;
                    jenisMobil = tmpjenisMobil;
                    horsePower = tmphorsePower;
                    panjangArray++;
                }
                case 2 -> lihatData(noPlat, merkMobil, warnaMobil, tahunkeluaran, jenisMobil, horsePower, panjangArray);
                case 0 -> {
                    run = false;
                    System.out.println("Anda telah menyelesaikan penginputan data mobil.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        run = true; // Reset untuk menu selanjutnya
        int maxTransaksi = 10; // Batas maksimum transaksi
        int[] nomorTransaksi = new int[maxTransaksi];
        String[] jenisLayanan = new String[maxTransaksi];
        String[] detailLayanan = new String[maxTransaksi]; 
        int[] jumlahTagihan = new int[maxTransaksi];
        int transaksiCounter = 1;
        int transaksiIndex = 0;
        String[] rute = {
            "Surabaya - Malang", 
            "Madura - Malang", 
            "Banyuwangi - Malang", 
            "Situbondo - Malang", 
            "Tulungagung - Malang"
        };
        int[] harga = {100000, 200000, 250000, 175000, 125000};

        while (run) {
            System.out.println("\nMenu Sewa dan Travel:");
            System.out.println("1. Travel");
            System.out.println("2. Sewa Mobil");
            System.out.println("3. Tampilkan Struk Keseluruhan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (transaksiIndex >= maxTransaksi) {
                        System.out.println("Jumlah maksimum transaksi telah tercapai.");
                        continue;
                    }
                    for (int i = 0; i < rute.length; i++) {
                        System.out.println((i + 1) + ". " + rute[i]);
                    }
                    System.out.print("Masukkan nomor rute yang Anda pilih: ");
                    int rutePilihan = in.nextInt();

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
                        struk("Travel", rute[rutePilihan - 1], hargaTravel);
                    }
                }
                case 2 -> {
                    if (panjangArray == 0) {
                        System.out.println("Tidak ada mobil untuk disewa.");
                        continue;
                    }

                    System.out.println("Pilih mobil yang ingin disewa:");
                    for (int i = 0; i < panjangArray; i++) {
                        System.out.printf("%d. %s (%s) - %s\n", (i + 1), merkMobil[i], noPlat[i], jenisMobil[i]);
                    }
                    System.out.print("Masukkan nomor mobil yang ingin disewa: ");
                    int mobilPilihan = in.nextInt() - 1;

                    if (mobilPilihan < 0 || mobilPilihan >= panjangArray) {
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
                        // Simpan transaksi
                        nomorTransaksi[transaksiIndex] = transaksiCounter++;
                        jenisLayanan[transaksiIndex] = "Sewa Mobil";
                        detailLayanan[transaksiIndex] = merkMobil[mobilPilihan] + " - " + sewaJam + " jam";
                        jumlahTagihan[transaksiIndex] = hargaTotal;
                        transaksiIndex++;
                        struk("Sewa Mobil", detailLayanan[transaksiIndex - 1], hargaTotal);
                    }
                }
                case 3 -> {
                    if (transaksiIndex == 0) {
                        System.out.println("Belum ada transaksi untuk ditampilkan.");
                    } else {
                        strukKeseluruhan(nomorTransaksi, jenisLayanan, detailLayanan, jumlahTagihan, transaksiIndex);
                    }
                }
                case 0 -> {
                    run = false; 
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        in.close();
    }

    public static void lihatData(String[] noPlat, String[] merkMobil, String[] warnaMobil, short[] tahunkeluaran, String[] jenisMobil, int[] horsePower, int panjangArray) {
        System.out.println("Daftar Mobil:");
        System.out.println("=================================================================================================");
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-15s\n", "No", "Plat No", "Merk", "Warna", "Tahun", "Jenis", "Horse Power");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (int i = 0; i < panjangArray; i++) {
            System.out.printf("%-5d %-15s %-15s %-15s %-15d %-15s", (i + 1), noPlat[i], merkMobil[i], warnaMobil[i], tahunkeluaran[i], jenisMobil[i]);
            if (jenisMobil[i].equals("Supercar")) {
                System.out.printf("%-15d\n", horsePower[i]);
            } else {
                System.out.printf("%-15c\n", '-');
            }
        }
        System.out.println("=================================================================================================");
    }

    public static void struk(String layanan, String detail, int tagihan) {
        System.out.print("=================================================\n");
        System.out.printf("%-15s %-20s %-15s\n", "Layanan", "Detail", "Tagihan (Rp)");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-15s %-20s Rp %-12d\n", layanan, detail, tagihan);
        System.out.println("=================================================");
    }

    public static void strukKeseluruhan(int[] nomorTransaksi, String[] jenisLayanan, String[] detailLayanan, int[] jumlahTagihan, int transaksiIndex) {
        System.out.print("=======================================================\n");
        System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
        System.out.println("-------------------------------------------------------");
        int subtotal = 0;

        for (int i = 0; i < transaksiIndex; i++) {
            System.out.printf("%-5d %-15s %-20s Rp %-12d\n", nomorTransaksi[i], jenisLayanan[i], detailLayanan[i], jumlahTagihan[i]);
            subtotal += jumlahTagihan[i];
        }
        // Diskon jika transaksi lebih dari 3
        double diskon = 0;
        if (transaksiIndex > 3) {
            diskon = subtotal * 0.05; 
        }
        double totalTagihan = subtotal - diskon;

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-42s Rp %-12d\n", "Subtotal:", subtotal);
        System.out.printf("%-42s Rp %-12.0f\n", "Diskon (5%):", diskon);
        System.out.printf("%-42s Rp %-12.0f\n", "Total Tagihan:", totalTagihan);
        System.out.println("=======================================================");
    }
}
