import java.util.Scanner;
public class Modul2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;
        int panjangArray = 1;
        boolean berjalan = true;
        boolean input = true;
        boolean run = true;
        String noPlat[] = new String[0];
        String merkMobil[] = new String[0];
        String warnaMobil[] = new String[0];
        short Tahunkeluaran[] = new short[0];
        String jenisMobil[] = new String[0];
        int horsePower[] = new int[0];

        while (run){
            System.out.println("\nMenu:");
            System.out.println("1. Input Data Mobil");
            System.out.println("2. Lihat Data Mobil");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            pilihan = in.nextInt();
            in.nextLine();
            switch (pilihan) {
                case 1 -> {
                while (berjalan) {
                    String tmpnoPlat[] = new String[panjangArray];
                    String tmpmerkMobil[] = new String[panjangArray];
                    String tmpwarnaMobil[] = new String[panjangArray];
                    short tmpTahunkeluaran[] = new short[panjangArray];
                    String tmpjenisMobil[] = new String[panjangArray];
                    int tmphorsePower[] = new int[panjangArray];

                    for (int i = 0; i < panjangArray - 1; i++) {
                        tmpnoPlat[i] = noPlat[i];
                        tmpmerkMobil[i] = merkMobil[i];
                        tmpwarnaMobil[i] = warnaMobil[i];
                        tmpTahunkeluaran[i] = Tahunkeluaran[i];
                        tmpjenisMobil[i] = jenisMobil[i];
                        tmphorsePower[i] = horsePower[i];
                    }
                    System.out.println("Pilih jenis mobil:");
                    System.out.println("1.Regular");
                    System.out.println("2.Supercar");
                    System.out.print("Masukkan pilihan: ");
                    int jenis = in.nextInt();
                    in.nextLine();
                    if (jenis == 1) {
                        tmpjenisMobil[panjangArray - 1] = "Regular";
                        tmphorsePower[panjangArray - 1] = 0;
                        System.out.printf("%-15s: ", "Plat nomor?"); 
                        tmpnoPlat[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Merk mobil?"); 
                        tmpmerkMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Warna mobil?"); 
                        tmpwarnaMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Tahun keluaran?"); 
                        tmpTahunkeluaran[panjangArray-1] = in.nextShort();
                        in.nextLine();
                    } else if (jenis == 2) {
                        tmpjenisMobil[panjangArray - 1] = "Supercar";
                        System.out.printf("%-15s: ", "Plat nomor?"); 
                        tmpnoPlat[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Merk mobil?"); 
                        tmpmerkMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Warna mobil?"); 
                        tmpwarnaMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ", "Tahun keluaran?"); 
                        tmpTahunkeluaran[panjangArray-1] = in.nextShort();
                        in.nextLine();
                        System.out.printf("%-15s: ", "Horse Power?"); 
                        tmphorsePower[panjangArray - 1] = in.nextInt();
                        in.nextLine();
                    }
                    panjangArray++;
                    input = true;
                
                
                        while (input) {
                            System.out.print("Apakah ingin memasukkan data? y/n: ");
                            String yaAtauTidak = in.nextLine();
                            if (yaAtauTidak.equalsIgnoreCase("y")){
                                input = false ;berjalan = true;}
                            else if(yaAtauTidak.equalsIgnoreCase("n")){
                                input = false ;berjalan = false;}
                            else System.out.println("Input tidak valid.");

                        }
                
                        noPlat = new String[panjangArray-1];
                        merkMobil = new String[panjangArray-1];
                        warnaMobil = new String[panjangArray-1];
                        Tahunkeluaran = new short[panjangArray-1];

                        for (int i = 0; i < panjangArray - 1; i++) {
                            noPlat[i] = tmpnoPlat[i];
                            merkMobil[i] = tmpmerkMobil[i];
                            warnaMobil[i] = tmpwarnaMobil[i];
                            Tahunkeluaran[i] = tmpTahunkeluaran[i];
                            jenisMobil[i] = tmpjenisMobil[i];
                            horsePower[i] = tmphorsePower[i];
                        }
                    
                    }
                    berjalan = true;
                }
                case 2 ->{lihatData(noPlat, merkMobil, warnaMobil, Tahunkeluaran,jenisMobil,horsePower);}
                case 0 -> {run = false;}
                default ->
                    {System.out.println("Tidak terdeteksi, silakan input lagi..");}
            }
        //batas transaksi
        int maxTransaksi = 10; 
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
            int pil = in.nextInt();
            if (pil == 1) {
                if (transaksiIndex >= maxTransaksi) {
                    System.out.println("Jumlah maksimum transaksi telah tercapai.");
                    continue;
                }
                System.out.println("Pilih rute perjalanan:");
                for (int i = 0; i < rute.length; i++) {
                    System.out.println((i + 1) + ". " + rute[i]);
                }
                System.out.print("Masukkan nomor rute yang Anda pilih: ");
                int rutepil = in.nextInt();

                if (rutepil < 1 || rutepil > rute.length) {
                    System.out.println("Pilihan rute tidak valid.");
                } else {
                    int hargaTravel = harga[rutepil - 1];
                    // Simpan transaksi
                    nomorTransaksi[transaksiIndex] = transaksiCounter++;
                    jenisLayanan[transaksiIndex] = "Travel";
                    detailLayanan[transaksiIndex] = rute[rutepil - 1];
                    jumlahTagihan[transaksiIndex] = hargaTravel;
                    transaksiIndex++;
                    System.out.print("=======================================================\n");
                    System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                    System.out.println("-------------------------------------------------------");
                    System.out.printf("%-5d %-15s %-20s Rp %-12d\n", transaksiCounter - 1, "Travel", rute[rutepil - 1], hargaTravel);
                    System.out.println("=======================================================");
                }
            } else if (pil == 2) {
                if (transaksiIndex >= maxTransaksi) {
                    System.out.println("Jumlah maksimum transaksi telah tercapai.");
                    continue;
                }
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
                detailLayanan[transaksiIndex] = sewaJam + " jam";
                jumlahTagihan[transaksiIndex] = hargaTotal;
                transaksiIndex++;
                System.out.print("=======================================================\n");
                System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                System.out.println("-------------------------------------------------------");
                System.out.printf("%-5d %-15s %-20s Rp %-12d\n", transaksiCounter - 1, "Sewa Mobil", sewaJam + " jam", hargaTotal);
                System.out.println("=======================================================");
            } else if (pil == 3) {
                System.out.print("=======================================================\n");
                System.out.printf("%-5s %-15s %-20s %-15s\n", "No", "Layanan", "Detail", "Tagihan (Rp)");
                System.out.println("-------------------------------------------------------");
                int totalTagihan = 0;
                double diskon = 0.0;
                for (int i = 0; i < transaksiIndex; i++) {
                    System.out.printf("%-5d %-15s %-20s Rp %-12d\n", nomorTransaksi[i], jenisLayanan[i], detailLayanan[i], jumlahTagihan[i]);
                    totalTagihan += jumlahTagihan[i];
                }
                int subtotal = totalTagihan;
                System.out.println("-------------------------------------------------------");
                System.out.printf("%-42s Rp %-12d\n", "Subtotal:", subtotal);
                //Jika transaksi lebih dari 3 mendapatkan diskon
                if (transaksiIndex > 3) {
                    diskon = subtotal * 0.05; 
                    totalTagihan -= diskon;
                    System.out.printf("%-42s Rp %-12.0f\n", "Diskon 5%:", diskon);
                }
                System.out.printf("%-42s Rp %-12d\n", "Total Tagihan:", totalTagihan);
                System.out.println("=======================================================");
                System.out.println("\nTerima kasih telah menggunakan layanan Filkom Tour and Travel!");
                ulang = false; 
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
        }
    }
    public static void lihatData(String noPlat[], String merkMobil[], String warnaMobil[], short tahunKeluaran[], String jenisMobil[], int horsePower[]) {
        for (int i = 0; i < noPlat.length; i++) {
            System.out.println("MOBIL " + (i + 1));
            System.out.printf("%-14s : %s\n", "Plat Nomor", noPlat[i]);
            System.out.printf("%-14s : %s\n", "Merk", merkMobil[i]);
            System.out.printf("%-14s : %s\n", "Warna", warnaMobil[i]);
            System.out.printf("%-14s : %d\n", "Tahun Keluaran", tahunKeluaran[i]);
            System.out.printf("%-14s : %s\n", "Jenis Mobil", jenisMobil[i]);
            if (jenisMobil[i].equals("Supercar")) {
                System.out.printf("%-14s : %d HP\n", "Horse Power", horsePower[i]);
            }
            System.out.println();
        }
    }
}
