package StudyCasePemdas;
import java.util.Scanner;

public class Modul1 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        PengelolaanKaryawan kelolaKaryawan = new PengelolaanKaryawan();
        

        int n;
        boolean berhenti = false;
        boolean inputKaryawanLagi;
        boolean konfirmasiValid;
        boolean cekGaji;
        
        System.out.println("\nSELAMAT DATANG DI APLIKASI FILKOM TOUR AND TRAVEL");
        
        while (!berhenti) {
            System.out.println("\n\n-----------------------------------------");
            System.out.println("Menu Manajemen Karyawan");
            System.out.println("-----------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Lihat Data Karyawan");
            System.out.println("3. Lanjut ke menu Hitung Gaji Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            n = in.nextInt();
            in.nextLine();

            switch (n) {
                case 1 -> {
                    inputKaryawanLagi = false;
                    while (!inputKaryawanLagi) {
                        //INPUT KARYAWAN
                        System.out.println("\nINPUT KARYAWAN BARU\nPILIHAN KATEGORI KARYAWAN: Supir Travel, Supir Rent Car, Admin");
                        kelolaKaryawan.tambahKaryawan(in);
                        in.nextLine();
                        kelolaKaryawan.pisahKategori();
                        //KONFIRMASI
                        konfirmasiValid = false;
                        while (!konfirmasiValid) {
                            System.out.print("\nInput Lagi? (YA/TIDAK): ");
                            String konfirmasi = in.nextLine();
                            if (konfirmasi.equalsIgnoreCase("YA")) {
                                konfirmasiValid = true;
                                inputKaryawanLagi = false;
                            } else if (konfirmasi.equalsIgnoreCase("TIDAK")) {
                                konfirmasiValid = true;
                                inputKaryawanLagi = true;
                            } else System.out.println("Input tidak valid.");
                        } 
                    }
                }
                case 2 -> kelolaKaryawan.tampilKaryawan();
                case 3 -> {
                    cekGaji = false;
                    while (!cekGaji) {
                        System.out.println("\n\n-----------------------------------------");
                        System.out.println("Menu Hitung Gaji Karyawan");
                        System.out.println("-----------------------------------------");
                        System.out.println("DAFTAR GAJI POKOK:");
                        System.out.println("- Supir Travel   : Rp. 1.500.000");
                        System.out.println("- Supir Rent Car : Rp. 1.750.000");
                        System.out.println("- Admin          : Rp. 2.000.000");
                        System.out.println("=========================================");

                        System.out.println("1. Hitung Gaji");
                        System.out.println("2. Kembali ke menu Manajemen Karyawan (keluar)");
                        System.out.print("Masukkkan pilihan: "); int pilihan = in.nextInt();
                        in.nextLine();

                        switch (pilihan) {
                            case 1 -> {

                                System.out.printf("%-27s: ","Masukkan Nama Karyawan");
                                String nama = in.nextLine();
                                System.out.printf("%-27s: ", "Masukkan Kategori Karyawan");
                                String kategori = in.nextLine();
            
                                int indeksKaryawan = kelolaKaryawan.cariKaryawan(nama, kategori);
            
                                if (indeksKaryawan == -1) {
                                    System.out.println("Karyawan tidak terdeteksi.");
                                } else {

                                    GajiKaryawan gajiKaryawan1 = null;

                                    konfirmasiValid = false;
                                    while (!konfirmasiValid) {
                                        System.out.printf("%-27s: ", "Gaji Pokok");
                                        int gajiPokok = in.nextInt();

                                        for (int i = 0; i < kelolaKaryawan.getJumlahKaryawan(); i++) {
                                            Karyawan karyawan1 = kelolaKaryawan.getDaftarKaryawan()[i];
                                            gajiKaryawan1 = new GajiKaryawan(karyawan1);
                                            if (gajiPokok == gajiKaryawan1.getGajiPokokSatuan()) {
                                                konfirmasiValid = true;
                                            }
                                        }
                                        if (konfirmasiValid == false) System.out.println("Gaji Pokok tidak sesuai dengan kategori.\n");
                                    }
                                    
                                    System.out.printf("%-27s: Rp.%.0f\n", "Upah Lembur per Jam", gajiKaryawan1.getUpahLemburSatuan());
                                    System.out.printf("Pajak: %.0f%%\n", gajiKaryawan1.getPajakSatuan() * 100);
            
                                    System.out.printf("%-27s: ", "Masukkan Jumlah Jam Lembur");
                                    int jamLembur = in.nextInt();
            
                                    double gajiBersih = gajiKaryawan1.getGajiBersih(jamLembur);
                                    
                                    gajiKaryawan1.tampilGaji(gajiBersih, nama);
                                }
                            }
                            case 2 -> cekGaji = true;
                            default -> System.out.println("Tidak terdeteksi, silakan input lagi..");
                        }
                    }
                }
                case 0 -> berhenti = true;
                default -> System.out.println("Tidak terdeteksi, silakan input lagi..");
            }
        }
        System.out.println("Program keluar..");
    }
}