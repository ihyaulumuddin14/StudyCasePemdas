package StudyCasePemdas;
import java.util.Scanner;

public class PengelolaanMobil {
    private int jumlahMobil = 0;
    private Mobil[] daftarMobil = new Mobil[jumlahMobil];

    public void tambahMobil(Scanner in, int jenis) {
        Mobil[] daftarMobilTmp = new Mobil[jumlahMobil+1];
        String noPlat, merkMobil, warnaMobil, jenisMobil = "Regular";
        short tahunkeluaran;
        int horsePower = 0;

        for (int i = 0; i < jumlahMobil; i++) {
            daftarMobilTmp[i] = daftarMobil[i];
        }

        System.out.printf("%-16s: ", "Plat nomor? ");
        noPlat = in.nextLine();
        System.out.printf("%-16s: ", "Merk mobil? ");
        merkMobil = in.nextLine();
        System.out.printf("%-16s: ", "Warna mobil? ");
        warnaMobil = in.nextLine();
        System.out.printf("%-15s: ", "Tahun keluaran? ");
        tahunkeluaran = in.nextShort();

        if (jenis == 2) {
            jenisMobil = "Supercar";
            System.out.printf("%-16s: ", "Horse Power? ");
            horsePower = in.nextInt();
        } else if (jenis ==1 ) {jenisMobil = "Regular";}

        jumlahMobil++;
        daftarMobilTmp[jumlahMobil-1] = new Mobil(noPlat, merkMobil, warnaMobil, jenisMobil, tahunkeluaran, horsePower);

        daftarMobil = new Mobil[jumlahMobil-1];
        daftarMobil = daftarMobilTmp;
        System.out.println("Mobil berhasil ditambahkan.");
    }


    public void lihatData() {
        System.out.println("Daftar Mobil:");
        System.out.println("=================================================================================================");
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-15s\n", "No", "Plat No", "Merk", "Warna", "Tahun", "Jenis", "Horse Power");
        System.out.println("-------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < jumlahMobil; i++) {
            System.out.printf("%-5d %-15s %-15s %-15s %-15d %-15s", (i + 1), daftarMobil[i].getNoPlat(), daftarMobil[i].getMerkMobil(), daftarMobil[i].getWarnaMobil(), daftarMobil[i].getTahunkeluaran(), daftarMobil[i].getJenisMobil());

            if (daftarMobil[i].getJenisMobil().equals("Supercar")) {
                System.out.printf(" %-15d\n", daftarMobil[i].getHorsePower());
            } else {
                System.out.printf(" %c\n", '-');
            }
        }
        System.out.println("=================================================================================================");
    }

    public int getJumlahMobil() {
        return jumlahMobil;
    }

    public Mobil[] getDaftarMobil() {
        return daftarMobil;
    }
}
