package StudyCasePemdas;
import java.util.Scanner;

public class Travel12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] dataString = new String[5][0];
        long[][] dataLong = new long[2][0];
        char[] dataChar = new char[0];
        int n, lengthOfTmpDatas = 1;
        boolean stop = false;
        boolean inputAgain = false;
        boolean inputAgainisValid = false;

        System.out.println("\nSELAMAT DATANG DI APLIKASI FILKOM TOUR AND TRAVEL");
        System.out.println("Manajemen Karyawan");

        while (!stop) {
            System.out.println("\nMenu:");
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Lihat Data Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan menu pilihan: ");
            n = in.nextInt();
            in.nextLine();
            
            //switch
            switch (n) {
                case 1 -> {
                    while (!inputAgain) {

                        //temp data
                        String[][] dataStringTmp = new String[5][lengthOfTmpDatas];
                        long[][] dataLongTmp = new long[2][lengthOfTmpDatas];
                        char[] dataCharTmp = new char[lengthOfTmpDatas];
                        
                        //isi temp ke data asli
                        for (int i = 0; i < lengthOfTmpDatas-1; i++) {
                            for (int j = 0; j < dataString.length; j++) {
                                dataStringTmp[j][i] = dataString[j][i];
                            }
                        }
                        for (int i = 0; i < lengthOfTmpDatas-1; i++) {
                            for (int j = 0; j < dataLongTmp.length; j++) {
                                dataLongTmp[j][i] = dataLong[j][i];
                            }
                        }
                        for (int i = 0; i < dataCharTmp.length-1; i++) {
                            dataCharTmp[i] = dataChar[i];
                        }


                        System.out.println("\nINPUT KARYAWAN BARU\nPILIHAN KATEGORI KARYAWAN: Supir Travel, Supir Rent Car, Admin");
                        System.out.printf("%-20s: ", "Nama");               dataStringTmp[0][lengthOfTmpDatas-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Alamat");             dataStringTmp[1][lengthOfTmpDatas-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Kategori Karyawan");  dataStringTmp[2][lengthOfTmpDatas-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Shift");              dataStringTmp[3][lengthOfTmpDatas-1] = in.nextLine();
                        System.out.printf("%-20s: ", "Nama Bank");          dataStringTmp[4][lengthOfTmpDatas-1] = in.nextLine();
                        System.out.printf("%-20s: ", "No. Telepon");        dataLongTmp[0][lengthOfTmpDatas-1] = in.nextLong();
                        System.out.printf("%-20s: ", "No. Rekening");       dataLongTmp[1][lengthOfTmpDatas-1] = in.nextLong();
                        System.out.printf("%-20s: ", "Jenis Kelamin");      dataCharTmp[lengthOfTmpDatas-1] = in.next().charAt(0);
                        in.nextLine();
                        lengthOfTmpDatas++;
                        inputAgainisValid = false;

                        while (!inputAgainisValid) {
                            System.out.print("\nInput Lagi? (YA/TIDAK): "); String yesOrNo = in.nextLine();
                            if (yesOrNo.equalsIgnoreCase("YA")) {inputAgainisValid = true; inputAgain = false;}
                            else if (yesOrNo.equalsIgnoreCase("TIDAK")) {inputAgainisValid = true; inputAgain = true;}
                            else System.out.println("Input tidak valid.");
                        }
                        
                        
                        //data asli
                        dataString = new String[5][lengthOfTmpDatas-1];
                        dataLong = new long[2][lengthOfTmpDatas-1];
                        dataChar = new char[lengthOfTmpDatas-1];
            
                        //temp ke data asli
                        for (int i = 0; i < lengthOfTmpDatas-1; i++) {
                            for (int j = 0; j < dataString.length; j++) {
                                dataString[j][i] = dataStringTmp[j][i];
                            }
                        }
                        for (int i = 0; i < lengthOfTmpDatas-1; i++) {
                            for (int j = 0; j < dataLong.length; j++) {
                                dataLong[j][i] = dataLongTmp[j][i];
                            }
                        }
                        for (int i = 0; i < dataChar.length; i++) {
                            dataChar[i] = dataCharTmp[i];
                        }


                    } inputAgain = false;
                }
                case 2 -> {tampilNama(dataString, dataLong, dataChar);}
                case 0 -> {stop = true;}
                default -> {System.out.println("Tidak terdeteksi, silakan input lagi..");}
            }

        }
    }

    public static void tampilNama(String[][] dataString, long[][] dataLong, char[] dataChar) {
        String sequenceST = "", sequenceSRC = "", sequenceAdm = "";
        for (int i = 0; i < dataString[2].length; i++) {
            if (dataString[2][i].equalsIgnoreCase("Supir Travel")) sequenceST += i + " ";
            else if (dataString[2][i].equalsIgnoreCase("Supir Rent Car")) sequenceSRC += i + " ";
            else if (dataString[2][i].equalsIgnoreCase("Admin")) sequenceAdm += i + " ";
        }

        String[] indexST = sequenceST.split(" ");
        String[] indexSRC = sequenceSRC.split(" ");
        String[] indexAdm = sequenceAdm.split(" ");

        System.out.println("\nSUPIR TRAVEL");
        if (!sequenceST.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indexST.length; j++) {
                    if (i == Integer.parseInt(indexST[j])) {
                        System.out.printf("%-20s: %s\n", "Nama", dataString[0][i]);
                        System.out.printf("%-20s: %s\n", "Alamat", dataString[1][i]);
                        System.out.printf("%-20s: %s\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("%-20s: %s\n", "Shift", dataString[3][i]);
                        System.out.printf("%-20s: %s\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("%-20s: %d\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("%-20s: %d\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("%-20s: %c\n\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            }
        } else System.out.println("-\n");
        

        System.out.println("\nSUPIR RENT CAR");
        if (!sequenceSRC.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indexSRC.length; j++) {
                    if (i == Integer.parseInt(indexSRC[j])) {
                        System.out.printf("%-20s: %s\n", "Nama", dataString[0][i]);
                        System.out.printf("%-20s: %s\n", "Alamat", dataString[1][i]);
                        System.out.printf("%-20s: %s\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("%-20s: %s\n", "Shift", dataString[3][i]);
                        System.out.printf("%-20s: %s\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("%-20s: %d\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("%-20s: %d\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("%-20s: %c\n\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            }
        } else System.out.println("-\n");
        

        System.out.println("\nADMIN");
        if (!sequenceAdm.isEmpty()) {
            for (int i = 0; i < dataChar.length; i++) {
                for (int j = 0; j < indexAdm.length; j++) {
                    if (i == Integer.parseInt(indexAdm[j])) {
                        System.out.printf("%-20s: %s\n", "Nama", dataString[0][i]);
                        System.out.printf("%-20s: %s\n", "Alamat", dataString[1][i]);
                        System.out.printf("%-20s: %s\n", "Kategori Karyawan", dataString[2][i]);
                        System.out.printf("%-20s: %s\n", "Shift", dataString[3][i]);
                        System.out.printf("%-20s: %s\n", "Nama Bank", dataString[4][i]);
                        System.out.printf("%-20s: %d\n", "No. Telepon", dataLong[0][i]);
                        System.out.printf("%-20s: %d\n", "No.Rekening", dataLong[1][i]);
                        System.out.printf("%-20s: %c\n\n", "Jenis Kelamin", dataChar[i]);
                    }
                }
            }
        } else System.out.println("-\n");
    }
}