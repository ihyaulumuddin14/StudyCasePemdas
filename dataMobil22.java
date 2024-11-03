import java.util.Scanner;
public class dataMobil22 {
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
                        System.out.printf("%-15s: ","Plat nomor?"); tmpnoPlat[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Merk mobil?"); tmpmerkMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Warna mobil?"); tmpwarnaMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Tahun keluaran?"); tmpTahunkeluaran[panjangArray-1] = in.nextShort();
                        in.nextLine();
                        panjangArray++;
                        input = true;
                    } else if (jenis == 2) {
                        tmpjenisMobil[panjangArray - 1] = "Supercar";
                        System.out.printf("%-15s: ","Plat nomor?"); tmpnoPlat[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Merk mobil?"); tmpmerkMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Warna mobil?"); tmpwarnaMobil[panjangArray-1] = in.nextLine();
                        System.out.printf("%-15s: ","Tahun keluaran?"); tmpTahunkeluaran[panjangArray-1] = in.nextShort();
                        in.nextLine();
                        System.out.printf("%-15s: ", "Horse Power?");
                        tmphorsePower[panjangArray - 1] = in.nextInt();
                        in.nextLine();
                        panjangArray++;
                        input = true;
                    }    
                
                
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
