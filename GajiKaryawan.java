package StudyCasePemdas;

public class GajiKaryawan {
    private double gajiPokokSatuan, upahLemburSatuan, pajakSatuan;
    private final double[][] bahanPerhitunganGaji = {
        {1500000, 1750000, 2000000},
        {20000, 45000, 40000},
        {0.05, 0.06, 0.07}
    };

    //Constructor
    public GajiKaryawan() {
    }

    //Constructor
    public GajiKaryawan(Karyawan karyawan) {
        if (karyawan.getKategori().equalsIgnoreCase("Supir Travel")) {
            this.gajiPokokSatuan = bahanPerhitunganGaji[0][0];
            this.upahLemburSatuan = bahanPerhitunganGaji[1][0];
            this.pajakSatuan = bahanPerhitunganGaji[2][0];
        }
        else if (karyawan.getKategori().equalsIgnoreCase("Supir Rent Car")) {
            this.gajiPokokSatuan = bahanPerhitunganGaji[0][1];
            this.upahLemburSatuan = bahanPerhitunganGaji[1][1];
            this.pajakSatuan = bahanPerhitunganGaji[2][1];
        }
        else if (karyawan.getKategori().equalsIgnoreCase("Admin")) {
            this.gajiPokokSatuan = bahanPerhitunganGaji[0][2];
            this.upahLemburSatuan = bahanPerhitunganGaji[1][2];
            this.pajakSatuan = bahanPerhitunganGaji[2][2];
        }
    }

    public double getGajiPokokSatuan() {
        return gajiPokokSatuan;
    }

    public double getUpahLemburSatuan() {
        return upahLemburSatuan;
    }

    public double getPajakSatuan() {
        return pajakSatuan;
    }

    public double getGajiBersih(int jamLembur) {
        return (getGajiPokokSatuan()+(getUpahLemburSatuan()*jamLembur)) * (1-getPajakSatuan());
    }

    public void tampilGaji(double gajiBersih, String nama) {
        System.out.printf("Gaji Bersih %s adalah Rp.%.0f\n\n", nama, gajiBersih);
    }
}
