package StudyCasePemdas;
import java.util.Scanner;
public class InputDataMobil {
    private String[] noPlat = new String[0];
    private String[] merkMobil = new String[0];
    private String[] warnaMobil = new String[0];
    private short[] tahunkeluaran = new short[0];
    private String[] jenisMobil = new String[0];
    private int[] horsePower = new int[0];
    private int panjangArray = 0;

    public String[] getNoPlat() {
        return noPlat;
    }

    public String[] getMerkMobil() {
        return merkMobil;
    }

    public String[] getWarnaMobil() {
        return warnaMobil;
    }

    public short[] getTahunkeluaran() {
        return tahunkeluaran;
    }

    public String[] getJenisMobil() {
        return jenisMobil;
    }

    public int[] getHorsePower() {
        return horsePower;
    }

    public int getPanjangArray() {
        return panjangArray;
    }

    public void tambahMobil(Scanner in) {
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
            System.out.printf("%-16s: ", "Plat nomor? ");
            tmpnoPlat[panjangArray] = in.nextLine();
            System.out.printf("%-16s: ", "Merk mobil? ");
            tmpmerkMobil[panjangArray] = in.nextLine();
            System.out.printf("%-16s: ", "Warna mobil? ");
            tmpwarnaMobil[panjangArray] = in.nextLine();
            System.out.printf("%-15s: ", "Tahun keluaran? ");
            tmptahunkeluaran[panjangArray] = in.nextShort();
            in.nextLine();
        } else if (jenis == 2) {
            tmpjenisMobil[panjangArray] = "Supercar";
            System.out.printf("%-16s: ", "Plat nomor? ");
            tmpnoPlat[panjangArray] = in.nextLine();
            System.out.printf("%-16s: ", "Merk mobil? ");
            tmpmerkMobil[panjangArray] = in.nextLine();
            System.out.printf("%-16s: ", "Warna mobil? ");
            tmpwarnaMobil[panjangArray] = in.nextLine();
            System.out.printf("%-15s: ", "Tahun keluaran? ");
            tmptahunkeluaran[panjangArray] = in.nextShort();
            in.nextLine();
            System.out.printf("%-16s: ", "Horse Power? ");
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
        System.out.println("Mobil berhasil ditambahkan.");
    }

    public void lihatData() {
        System.out.println("Daftar Mobil:");
        System.out.println("=================================================================================================");
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-15s\n", "No", "Plat No", "Merk", "Warna", "Tahun", "Jenis", "Horse Power");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (int i = 0; i < panjangArray; i++) {
            System.out.printf("%-5d %-15s %-15s %-15s %-15d %-15s", (i + 1), noPlat[i], merkMobil[i], warnaMobil[i], tahunkeluaran[i], jenisMobil[i]);
            if (jenisMobil[i].equals("Supercar")) {
                System.out.printf(" %-15d\n", horsePower[i]);
            } else {
                System.out.printf(" %c\n", '-');
            }
        }
        System.out.println("=================================================================================================");
    }
}
