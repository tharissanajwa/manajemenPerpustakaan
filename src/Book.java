public class Book {
    private String judul;
    private String penulis;
    private String isbn;
    private int jumlah;
    private String statusBuku;

    public Book(String judul, String penulis, String isbn, int jumlah, String statusBuku) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.jumlah = jumlah;
        this.statusBuku = statusBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatusBuku() {
        return statusBuku;
    }

    public void setStatusBuku(String statusBuku) {
        this.statusBuku = statusBuku;
    }
}
