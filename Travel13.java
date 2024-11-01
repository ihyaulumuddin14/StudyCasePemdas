package StudyCasePemdas;

import java.util.Scanner;

public class Travel13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] arrOfCategory = {"Supir Travel", "Supir Rent Car", "Admin"};
        String category, name;
        int n, overTimePay, bSalary = 0, indexOfCategory = 0;
        double[][] calculateSalary = {
            {1500000, 1750000, 2000000},
            {20000, 45000, 40000},
            {5/100.0, 6/100.0, 7/100.0}
        };
        double netSalary = 0;
        boolean stop = false, inputAgain = false;

        while (!stop) {
            System.out.println("DAFTAR GAJI POKOK");
            System.out.printf("%-15s : 1.500.000\n", "Supir Travel");
            System.out.printf("%-15s : 1.750.000\n", "Supir Rent Car");
            System.out.printf("%-15s : 2.000.000\n", "Admin");
            System.out.println("==========================================================");
            System.out.println("Menu");
            System.out.println("1. Hitung Gaji");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            n = in.nextInt();
            in.nextLine();

            switch(n) {
                case 1 -> {
                    System.out.printf("%-15s: ", "Nama"); name = in.nextLine();
                    while (!inputAgain) {
                        System.out.printf("%-15s: ", "Kategori"); category = in.nextLine();
                        for (int i = 0; i < arrOfCategory.length; i++) {
                            if (category.equalsIgnoreCase(arrOfCategory[i])) {
                                indexOfCategory = i;
                                inputAgain = true;
                            }
                        }
                        if (inputAgain == false) System.out.println("Data kategori tidak cocok.");
                    } inputAgain = false;
                    

                    while (!inputAgain) {
                        System.out.printf("%-15s: ", "Gaji Pokok"); bSalary = in.nextInt();
                        for (int i = 0; i < calculateSalary[0].length; i++) {
                            if (bSalary == calculateSalary[0][indexOfCategory]) {
                                inputAgain = true;
                            }
                        }
                        if (inputAgain == false) System.out.println("Gaji Pokok tidak sesuai dengan kategori.");
                    } inputAgain = false;

                    System.out.printf("%-15s: ", "Jam Lembur"); overTimePay = in.nextInt();
                    System.out.printf("%-15s: %.0f%s\n", "Pajak", (calculateSalary[2][indexOfCategory]*100), "%");
                    overTimePay *= calculateSalary[1][indexOfCategory];
                    netSalary = (bSalary + overTimePay) - (calculateSalary[2][indexOfCategory]*(bSalary + overTimePay));

                    tampilGaji(netSalary, name);
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

    public static void tampilGaji(double netSalary, String name) {
        System.out.printf("%s %s adalah Rp.%.0f\n\n","Gaji Bersih", name, netSalary);
    }
}
