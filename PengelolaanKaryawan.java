package StudyCasePemdas;
import java.util.Scanner;

public class PengelolaanKaryawan {
    private final int jumlahMaksKaryawan = 100;
    private int jumlahKaryawan;
    private int jumlahSupirTravel;
    private int jumlahSupirRentCar;
    private int jumlahAdmin;
    private Karyawan[] daftarKaryawan = new Karyawan[jumlahMaksKaryawan];
    private Karyawan[] supirTravel = new Karyawan[jumlahMaksKaryawan];
    private Karyawan[] supirRentCar = new Karyawan[jumlahMaksKaryawan];
    private Karyawan[] admin = new Karyawan[jumlahMaksKaryawan];


    //Constructor
    public PengelolaanKaryawan() {
        jumlahKaryawan = 0;
        jumlahSupirTravel = 0;
        jumlahSupirRentCar = 0;
        jumlahAdmin = 0;
    }

    public void tambahKaryawan(Scanner in) {
        if (jumlahKaryawan < 100) {
            String nama, alamat, kategori, shift, namaBank;
            long noTelp, noRek;
            char jenisKelamin;

            System.out.printf("%-20s: ", "Nama");
            nama = in.nextLine();
            System.out.printf("%-20s: ", "Alamat");
            alamat = in.nextLine();
            System.out.printf("%-20s: ", "Kategori Karyawan");
            kategori = in.nextLine();
            System.out.printf("%-20s: ", "Shift");
            shift = in.nextLine();
            System.out.printf("%-20s: ", "Nama Bank");
            namaBank = in.nextLine();
            System.out.printf("%-20s: ", "No. Telepon");
            noTelp = in.nextLong();
            System.out.printf("%-20s: ", "No. Rekening");
            noRek = in.nextLong();
            System.out.printf("%-20s: ", "Jenis Kelamin");
            jenisKelamin = in.next().charAt(0);

            daftarKaryawan[jumlahKaryawan] = new Karyawan(nama, alamat, kategori, shift, namaBank, noTelp, noRek, jenisKelamin);
            jumlahKaryawan++;

            System.out.println("Karyawan berhasil ditambahkan.");
        } else {
            System.out.println("Slot karyawan full!");
        }
    }

    public int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public Karyawan[] getDaftarKaryawan() {
        return daftarKaryawan;
    }

    public void pisahKategori() {
        int i = jumlahKaryawan-1;
        if (daftarKaryawan[i].getKategori().equalsIgnoreCase("Supir Travel")) {
            supirTravel[jumlahSupirTravel] = daftarKaryawan[i];
            jumlahSupirTravel++;
        } else if (daftarKaryawan[i].getKategori().equalsIgnoreCase("Supir Rent Car")) {
            supirRentCar[jumlahSupirRentCar] = daftarKaryawan[i];
            jumlahSupirRentCar++;
        } else if (daftarKaryawan[i].getKategori().equalsIgnoreCase("Admin")) {
            admin[jumlahAdmin] = daftarKaryawan[i];
            jumlahAdmin++;
        }
    }

    public void tampilKaryawan() {
        System.out.println("+=========================================+");
        System.out.printf("|%-41s|\n"," SUPIR TRAVEL");
        if (jumlahSupirTravel > 0) {
            for (Karyawan karyawan : supirTravel) {
                if (karyawan == null) break;
                System.out.println("|-----------------------------------------|");
                System.out.printf("|%-19s: %-20s|\n", "Nama", karyawan.getNama());
                System.out.printf("|%-19s: %-20s|\n", "Alamat", karyawan.getAlamat());
                System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", karyawan.getKategori());
                System.out.printf("|%-19s: %-20s|\n", "Shift", karyawan.getShift());
                System.out.printf("|%-19s: %-20s|\n", "Nama Bank", karyawan.getNamaBank());
                System.out.printf("|%-19s: %-20d|\n", "No. Telepon", karyawan.getNoTelp());
                System.out.printf("|%-19s: %-20d|\n", "No.Rekening", karyawan.getNoRek());
                System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", karyawan.getJenisKelamin());
                System.out.println("+=========================================+\n");
            }
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+\n");
        }

        System.out.println("+=========================================+");
        System.out.printf("|%-41s|\n"," SUPIR RENT CAR");
        if (jumlahSupirRentCar > 0) {
            for (Karyawan karyawan : supirRentCar) {
                if (karyawan == null) break;
                System.out.println("|-----------------------------------------|");
                System.out.printf("|%-19s: %-20s|\n", "Nama", karyawan.getNama());
                System.out.printf("|%-19s: %-20s|\n", "Alamat", karyawan.getAlamat());
                System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", karyawan.getKategori());
                System.out.printf("|%-19s: %-20s|\n", "Shift", karyawan.getShift());
                System.out.printf("|%-19s: %-20s|\n", "Nama Bank", karyawan.getNamaBank());
                System.out.printf("|%-19s: %-20d|\n", "No. Telepon", karyawan.getNoTelp());
                System.out.printf("|%-19s: %-20d|\n", "No.Rekening", karyawan.getNoRek());
                System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", karyawan.getJenisKelamin());
                System.out.println("+=========================================+\n");
            }
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+\n");

        }

        System.out.println("+=========================================+");
        System.out.printf("|%-41s|\n"," ADMIN");
        if (jumlahAdmin > 0) {
            for (Karyawan karyawan : admin) {
                if (karyawan == null) break;
                System.out.println("|-----------------------------------------|");
                System.out.printf("|%-19s: %-20s|\n", "Nama", karyawan.getNama());
                System.out.printf("|%-19s: %-20s|\n", "Alamat", karyawan.getAlamat());
                System.out.printf("|%-19s: %-20s|\n", "Kategori Karyawan", karyawan.getKategori());
                System.out.printf("|%-19s: %-20s|\n", "Shift", karyawan.getShift());
                System.out.printf("|%-19s: %-20s|\n", "Nama Bank", karyawan.getNamaBank());
                System.out.printf("|%-19s: %-20d|\n", "No. Telepon", karyawan.getNoTelp());
                System.out.printf("|%-19s: %-20d|\n", "No.Rekening", karyawan.getNoRek());
                System.out.printf("|%-19s: %-20c|\n", "Jenis Kelamin", karyawan.getJenisKelamin());
                System.out.println("+=========================================+\n\n");
            }
        } else {
            System.out.println("|-----------------------------------------|");
            System.out.printf("|%-41s|\n"," -");
            System.out.println("+=========================================+\n\n");

        }
    }

    public int cariKaryawan(String nama, String kategori) {
        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].getNama().equalsIgnoreCase(nama) && daftarKaryawan[i].getKategori().equalsIgnoreCase(kategori)) {
                return i;
            }
        } return -1;
    }
}
