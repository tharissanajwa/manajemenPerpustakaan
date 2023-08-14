public class Anggota {
    private String idAnggota;
    private String nama;
    private String statusAnggota;

    public Anggota(String idAnggota, String nama, String statusAnggota) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.statusAnggota = statusAnggota;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }
}
