package StudyCasePemdas;
public class Karyawan {
    private String nama;
    private String alamat;
    private String kategori;
    private String shift;
    private String namaBank;
    private long noTelp;
    private long noRek;
    private char jenisKelamin;


    //Constructor
    public Karyawan (
        String nama, String alamat, String kategori, String shift,
        String namaBank, long noTelp, long noRek, char jenisKelamin
        ) {
        this.nama = nama;
        this.alamat = alamat;
        this.kategori = kategori;
        this.shift = shift;
        this.namaBank = namaBank;
        this.noTelp = noTelp;
        this.noRek = noRek;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {return nama.toUpperCase();}

    public String getAlamat() {return alamat.toUpperCase();}

    public String getKategori() {return kategori.toUpperCase();}

    public String getShift() {return shift.toUpperCase();}
    
    public String getNamaBank() {return namaBank.toUpperCase();}

    public long getNoTelp() {return noTelp;}

    public long getNoRek() {return noRek;}
    
    public char getJenisKelamin() {return jenisKelamin;}
    
}
