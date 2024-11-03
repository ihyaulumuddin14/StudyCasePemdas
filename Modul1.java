package StudyCasePemdas;
import java.util.Scanner;

public class Modul1 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String[][] dataString = new String[7][0];
        long[][] dataLong = new long[2][0];
        char[] dataChar = new char[0];
        int n, panjangDataTmp = 1;
        boolean berhenti = false;
        boolean inputLagi = false;
        boolean inputLagiBenar = false;

        String[] daftarKategori = {"Supir Travel", "Supir Rent Car", "Admin"};
        double[][] bahanPerhitunganGaji = {
            {1500000, 1750000, 2000000}, // gaji
            {50000, 45000, 40000}, // bayaran lembur per jam
            {5/100.0, 6/100.0, 7/100.0} // pajak
        };
        
        System.out.println("\nSELAMAT DATANG DI APLIKASI FILKOM TOUR AND TRAVEL");
        System.out.println("Manajemen Karyawan dan Penghitungan Gaji");

        while (!berhenti) {
            System.out.println("\nMenu:");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Lihat Data Karyawan");
            System.out.println("3. Hitung Gaji Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            n = in.nextInt();
            in.nextLine();

            switch (n) {
                case 1 -> {
                    while (!inputLagi) {
                        String[][] dataStringTmp = new String[7][panjangDataTmp];
                        long[][] dataLongTmp = new long[2][panjangDataTmp];
                        char[] dataCharTmp = new char[panjangDataTmp];

                        for (int i = 0; i < panjangDataTmp-1; i++) {
                            for (int j = 0; j < dataString.length; j++) {
                                dataStringTmp[j][i] = dataString[j][i];
                            }
                        }
                        for (int i = 0; i < panjangDataTmp-1; i++) {
                            for (int j = 0; j < dataLongTmp.length; j++) {
                                dataLongTmp[j][i] = dataLong[j][i];
                            }
                        }
                        for (int i = 0; i < dataCharTmp.length-1; i++) {
                            dataCharTmp[i] = dataChar[i];
                        }

                        System.out.println("\nINPUT KARYAWAN BARU\nPILIHAN KATEGORI KARYAWAN: Supir Travel, Supir Rent Car, Admin");
                        System.out.printf("%-20s: ", "Nama");               dataStringTmp[0][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Alamat");             dataStringTmp[1][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Kategori Karyawan");  dataStringTmp[2][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Shift");              dataStringTmp[3][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Nama Bank");          dataStringTmp[4][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Username");           dataStringTmp[5][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Password");           dataStringTmp[6][panjangDataTmp-1] = in.nextLine();
                        System.out.printf("%-20s: ", "No. Telepon");        dataLongTmp[0][panjangDataTmp-1] = in.nextLong();
                        System.out.printf("%-20s: ", "No. Rekening");       dataLongTmp[1][panjangDataTmp-1] = in.nextLong();
                        System.out.printf("%-20s: ", "Jenis Kelamin");      dataCharTmp[panjangDataTmp-1] = in.next().charAt(0);
                        in.nextLine();
                        
                        System.out.println("Karyawan Berhasil Ditambahkan");

                        panjangDataTmp++;
                        inputLagiBenar = false;

                        while (!inputLagiBenar) {
                            System.out.print("\nInput Lagi? (YA/TIDAK): ");
                            String yesOrNo = in.nextLine();
                            if (yesOrNo.equalsIgnoreCase("YA")) {
                                inputLagiBenar = true;
                                inputLagi = false;
                            } else if (yesOrNo.equalsIgnoreCase("TIDAK")) {
                                inputLagiBenar = true;
                                inputLagi = true;
                            } else System.out.println("Input tidak valid.");
                        }

                        dataString = new String[7][panjangDataTmp-1];
                        dataLong = new long[2][panjangDataTmp-1];
                        dataChar = new char[panjangDataTmp-1];

                        for (int i = 0; i < panjangDataTmp-1; i++) {
                            for (int j = 0; j < dataString.length; j++) {
                                dataString[j][i] = dataStringTmp[j][i];
                            }
                        }
                        for (int i = 0; i < panjangDataTmp-1; i++) {
                            for (int j = 0; j < dataLong.length; j++) {
                                dataLong[j][i] = dataLongTmp[j][i];
                            }
                        }
                        for (int i = 0; i < dataChar.length; i++) {
                            dataChar[i] = dataCharTmp[i];
                        }    
                    }
                    inputLagi = false;
                }
                case 2 -> tampilNama(dataString, dataLong, dataChar);
                case 3 -> {
                    System.out.print("Masukkan Username: ");
                    String username = in.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = in.nextLine();

                    int indeksKaryawan = validasiLogin(username, password, dataString);
                    if (indeksKaryawan == -1) {
                        System.out.println("Username atau Password salah.");
                    } else {
                        
                        String kategori = dataString[2][indeksKaryawan];

                        for (int i = 0; i < daftarKategori.length; i++) {
                            if (kategori.equalsIgnoreCase(daftarKategori[i])) {

                                double gajiPokok = bahanPerhitunganGaji[0][i];
                                double upahLembur = bahanPerhitunganGaji[1][i];
                                double pajak = bahanPerhitunganGaji[2][i];
        
                                System.out.printf("Kategori Karyawan: %s\n", kategori);
                                System.out.printf("Gaji Pokok: Rp.%.0f\n", gajiPokok);
                                System.out.printf("Upah Lembur per Jam: Rp.%.0f\n", upahLembur);
                                System.out.printf("Pajak: %.0f%%\n", pajak * 100);
        
                                System.out.print("Masukkan Jumlah Jam Lembur: ");
                                int jamLembur = in.nextInt();
        
                                double gajiBersih = (gajiPokok + upahLembur * jamLembur) * (1 - pajak);
                                System.out.printf("Gaji Bersih: Rp.%.0f\n", gajiBersih);

                            }
                        }

                    }
                        
                }
                case 0 -> berhenti = true;
                default -> System.out.println("Tidak terdeteksi, silakan input lagi..");
            }
        }

    }


    public static void tampilNama(String[][] dataString, long[][] dataLong, char[] dataChar) {

        String urutanST = "", urutanSRC = "", urutanAdm = "";
        for (int i = 0; i < dataString[2].length; i++) {
            if (dataString[2][i].equalsIgnoreCase("Supir Travel")) urutanST += i + " ";
            else if (dataString[2][i].equalsIgnoreCase("Supir Rent Car")) urutanSRC += i + " ";
            else if (dataString[2][i].equalsIgnoreCase("Admin")) urutanAdm += i + " ";
        }
    
        String[] indeksST = urutanST.split(" ");
        String[] indeksSRC = urutanSRC.split(" ");
        String[] indeksAdm = urutanAdm.split(" ");
            
        System.out.println("+=========================================+");
        System.out.printf("|%-41s|\n"," SUPIR TRAVEL");
        if (!urutanST.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indeksST.length; j++) {
                    if (i == Integer.parseInt(indeksST[j])) {
                        System.out.println("|-----------------------------------------|");
                        System.out.printf("|%-19s: %-20s|\n", "Nama", dataString[0][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Alamat", dataString[1][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Shift", dataString[3][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            } System.out.println("+=========================================+");
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+");
        }
            

        System.out.println("\n+=========================================+");
        System.out.printf("|%-41s|\n"," SUPIR RENT CAR");
        if (!urutanSRC.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indeksSRC.length; j++) {
                    if (i == Integer.parseInt(indeksSRC[j])) {
                        System.out.println("|-----------------------------------------|");
                        System.out.printf("|%-19s: %-20s|\n", "Nama", dataString[0][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Alamat", dataString[1][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Shift", dataString[3][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            } System.out.println("+=========================================+");
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+");
        }
            
    
        System.out.println("\n+=========================================+");
        System.out.printf("|%-41s|\n"," ADMIN");
        if (!urutanAdm.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indeksAdm.length; j++) {
                    if (i == Integer.parseInt(indeksAdm[j])) {
                        System.out.println("|-----------------------------------------|");
                        System.out.printf("|%-19s: %-20s|\n", "Nama", dataString[0][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Alamat", dataString[1][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Shift", dataString[3][i]);
                        System.out.printf("|%-19s: %-20s|\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("|%-19s: %-20d|\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            } System.out.println("+=========================================+");
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+");
        }
    }

    public static int validasiLogin(String username, String password, String[][] dataString) {
        for (int i = 0; i < dataString[0].length; i++) {
            if (username.equals(dataString[5][i]) && password.equals(dataString[6][i])) {
                return i;
            }
        }
        return -1;
    }

    public static int cariKaryawan(String name, String[][] dataString, String kategori, String[] daftarKategori) {
        for (int i = 0; i < dataString[0].length; i++) {
            if (dataString[0][i].equalsIgnoreCase(name)) {
                for (int j = 0; j < dataString[2].length; j++) {
                    if (kategori.equalsIgnoreCase(dataString[2][i])) {
                        for (int j2 = 0; j2 < daftarKategori.length; j2++) {
                            if (kategori.equalsIgnoreCase(daftarKategori[j2])) return j2;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public static void tampilGaji(double gajiBersih, String name) {
        System.out.printf("Gaji Bersih %s adalah Rp.%.0f\n\n", name, gajiBersih);
    }
}
