package StudyCasePemdas;

public class Mobil {
    private String noPlat;
    private String merkMobil;
    private String warnaMobil;
    private String jenisMobil;
    private short tahunkeluaran;
    private int horsePower;

    //Constructor
    public Mobil(
        String noPlat, String merkMobil, String warnaMobil, String jenisMobil,
        short tahunKeluaran, int horsePower
        ) {
        this.noPlat = noPlat;
        this.merkMobil = merkMobil;
        this.warnaMobil = warnaMobil;
        this.jenisMobil = jenisMobil;
        this.tahunkeluaran = tahunKeluaran;
        this.horsePower = horsePower;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public short getTahunkeluaran() {
        return tahunkeluaran;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
