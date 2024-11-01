
import java.util.Scanner;
public class dataMobil22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int banyakMobil = in.nextInt();

        lihatData(banyakMobil);
    }
    public static void lihatData(int banyakMobil){
        Scanner in = new Scanner(System.in);
        String noPlat[] = new String[banyakMobil];
        String merkMobil[] = new String[banyakMobil];
        String warnaMobil[] = new String[banyakMobil];
        short TahunKekeluaran[] = new short[banyakMobil];
        for (int i = 0; i < banyakMobil; i++) {
            System.out.println("Mobil " + (i+1));
            System.out.print("Masukkan plat nomor: ");
            noPlat[i] = in.nextLine();
            System.out.print("Masukkan merk mobil: ");
            merkMobil[i] = in.nextLine();
            System.out.print("Masukkan warna mobil: ");
            warnaMobil[i] = in.nextLine();
            System.out.print("Masukkan tahun keluaran mobil: ");
            TahunKekeluaran[i] = in.nextShort();
            in.nextLine();
        }
        System.out.println();
        System.out.println("DATA MOBIL");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < banyakMobil; i++) {
            System.out.println("MOBIL " + (i+1));
            System.out.printf("%-14s : %s\n","Plat Nomor",noPlat[i]);
            System.out.printf("%-14s : %s\n","Merk",merkMobil[i]);
            System.out.printf("%-14s : %s\n","Warna",warnaMobil[i]);
            System.out.printf("%-14s : %d\n","Tahun Keluaran",TahunKekeluaran[i]);
            System.out.println();
        }
    }
}
