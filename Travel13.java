package StudyCasePemdas;

import java.util.Scanner;

public class Travel13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] stringKategori = {"Supir Travel", "Supir Rent Car", "Admin"};
        String kategori;
        int n, uangLembur, gajiPokok = 0, indexOfKategori = 0;
        double[][] hitungGaji = {
            {1500000, 1750000, 2000000},
            {20000, 45000, 40000},
            {5/100.0, 6/100.0, 7/100.0}
        };
        double gajiBersih = 0;
        boolean stop = false, inputAgain = false;

        while (!stop) {

            System.out.println("Menu");
            System.out.println("1. Hitung Gaji");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            n = in.nextInt();
            in.nextLine();

            switch(n) {
                case 1 -> {
                    while (!inputAgain) {
                        System.out.printf("%-15s: ", "Kategori"); kategori = in.nextLine();
                        for (int i = 0; i < stringKategori.length; i++) {
                            if (kategori.equalsIgnoreCase(stringKategori[i])) {
                                indexOfKategori = i;
                                inputAgain = true;
                            }
                        }
                        if (inputAgain == false) System.out.println("Data kategori tidak cocok.");
                    } inputAgain = false;
                    

                    while (!inputAgain) {
                        System.out.printf("%-15s: ", "Gaji Pokok"); gajiPokok = in.nextInt();
                        for (int i = 0; i < hitungGaji[0].length; i++) {
                            if (gajiPokok == hitungGaji[0][indexOfKategori]) {
                                inputAgain = true;
                            }
                        }
                        if (inputAgain == false) System.out.println("Gaji pokok tidak sesuai dengan kategori.");
                    } inputAgain = false;

                    System.out.printf("%-15s: ", "Jam Lembur"); uangLembur = in.nextInt();
                    uangLembur *= hitungGaji[1][indexOfKategori];
                    gajiBersih = (gajiPokok + uangLembur) - hitungGaji[2][indexOfKategori]*(gajiPokok + uangLembur);

                    tampilGaji(gajiBersih);
                }

                case 0 -> {
                    stop = true;
                }

                default -> {
                    System.out.println("Tidak terdeteksi, silakan input lagi..");
                }
            }

        }
    }

    public static void tampilGaji(double gajiBersih) {
        System.out.printf("%-15s: Rp.%.0f\n\n","Gaji Bersih", gajiBersih);
    }
}
