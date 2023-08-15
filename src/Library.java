import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    public static List<Book> tambahBuku(List<Book> books, String judul, String penulis, String isbn, int jumlah, String statusBuku) {
        books.add(new Book(judul, penulis, isbn, jumlah, statusBuku));
        return books;
    }

    public static List<Anggota> tambahAnggota(List<Anggota> member, String idAnggota, String nama, String statusAnggota) {
        member.add(new Anggota(idAnggota, nama, statusAnggota));
        return member;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Menanti Hari Berganti", "Titi Sanaria", "978-623-5592-06-0", 1, "aktif"));
        books.add(new Book("Sunset Bersama Rosie", "Tere Liye Dar", "978-623-9607-46-3", 1, "aktif"));
        books.add(new Book("Hujan di Hari Minggu", "Tere Liye Dar", "978-602-0324-78-4", 1, "aktif"));
        books.add(new Book("Mariposa Angan Angan", "Luluk Fajriya", "978-602-5508-61-5", 1, "aktif"));

        List<Anggota> member = new ArrayList<>();
        member.add(new Anggota("THA1", "Tharissa Najwa", "aktif"));
        member.add(new Anggota("PUT2", "Putri Budiman", "aktif"));
        member.add(new Anggota("ATH3", "Athifa Rasya P", "aktif"));

        List<String> history = new ArrayList<>();
        // Menampilkan pesan selamat datang
        System.out.println("Selamat Datang di Manajemen Perpustakaan Tharissa!");

        // Looping menu utama
        boolean loopingMenu = true;
        while (loopingMenu) {
            // Menampilkan menu pilihan kepada pengguna
            tampilkanMenu();
            // Menampilkan input pilihan menu kepada pengguna dengan memanggil fungsi yang sudah dibuat
            int pilihanUser = getPilihanUser(scanner);

            switch (pilihanUser) {
                // Menggunakan switch-case untuk menangani pilihan pengguna
                // Case 1 untuk memilih menu buku
                case 1 -> {
                    boolean loopingBuku = true;
                    while (loopingBuku) {
                        tampilkanBuku();
                        int pilihanMenuKategoriBuku = getPilihanUser(scanner);
                        // Menangani pilihan switch case user dengan switch case lagi
                        switch (pilihanMenuKategoriBuku) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan buku baru.");
                                tambahBukuBaru(scanner, books); // Memanggil fungsi tambah kategori baru dengan menyertakan scanner beserta arrayList nya(data set barang dan stok)
                            }
                            case 2 -> {
                                System.out.println("Anda memilih menu untuk meminjam buku. Berikut list buku yang tersedia : ");
                                pinjamBuku(scanner, books, member, history); // Memangil fungsi pinjam buku
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk mengembalikan buku. Berikut list buku yang sedang dipinjam : ");
                                pengembalianBuku(scanner, books, history); // Memangil fungsi pinjam buku
                            }
                            case 4 -> {
                                System.out.println("Anda memilih menu untuk menghapus buku. Berikut list buku yang tersedia : ");
                                hapusBuku(scanner, books); // Memanggil fungsi hapus buku
                            }
                            case 5 -> {
                                boolean loopingLihatBuku = false;
                                while (!loopingLihatBuku) {
                                    tampilkanLihatBuku();
                                    int pilihanMenuLihatBuku = getPilihanUser(scanner);

                                    switch (pilihanMenuLihatBuku) {
                                        case 1 -> {
                                            System.out.println("Anda memilih menu untuk melihat buku yang tersedia. Berikut datanya : ");
                                            listBuku(books); // Memanggil fungsi lihat kategori
                                        }
                                        case 2 -> {
                                            System.out.println("Anda memilih menu untuk melihat buku yang dipinjam. Berikut datanya : ");
                                            listBukuPinjam(books); // Memanggil fungsi lihat kategori
                                        }
                                        case 3 -> {
                                            System.out.println("Anda memilih menu untuk melihat jumlah buku yang teserdia. Berikut datanya : ");
                                            listJumlahBuku(books); // Memanggil fungsi lihat kategori
                                        }
                                        case 4 -> {
                                            System.out.println("Anda memilih menu untuk melihat history buku. Berikut datanya : ");
                                            historyBook(history); // Memanggil fungsi lihat kategori
                                        }
                                        case 0 -> loopingLihatBuku = true;
                                        case -1 -> {
                                            System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                            scanner.nextLine(); // Fungsinya untuk menghapus buffer
                                        }
                                        // Menampilkan pesan kesalahan untuk pilihan yang tidak valid misal angka 5 keatas
                                        default -> {
                                            System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                            scanner.nextLine();
                                        }
                                    }
                                }
                            }
                            case 0 -> loopingBuku = false; // Loop diberhentikan karena program telah selesai
                            // Dalam scanner next int, bila kita inputkan karakter selain angka, maka hasil yang keluar adalah -1(error)
                            case -1 -> {
                                System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                scanner.nextLine(); // Fungsinya untuk menghapus buffer
                            }
                            // Menampilkan pesan kesalahan untuk pilihan yang tidak valid misal angka 5 keatas
                            default -> {
                                System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                // Case 2 untuk memilih menu barang
                case 2 -> {
                    boolean loopingAnggota = true;
                    while (loopingAnggota) {
                        tampilkanAnggota();
                        int pilihanMenuAnggota = getPilihanUser(scanner);
                        switch (pilihanMenuAnggota) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan anggota baru.");
                                tambahAnggotaBaru(scanner, member); // Memanggil fungsi tambah anggota baru
                            }
                            case 2 -> {
                                System.out.println("Anda memilih menu untuk menghapus anggota. Berikut list anggota yang tersedia : ");
                                hapusAnggota(scanner, member); // Memanggil fungsi hapus anggota
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk melihat anggota yang masih aktif. Berikut datanya : ");
                                listAnggota(member); // Memanggil fungsi list anggota
                            }
                            case 0 -> loopingAnggota = false;
                            case -1 -> {
                                System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                scanner.nextLine();
                            }
                            default -> {
                                System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                // Keluar dari aplikasi
                case 0 -> {
                    System.out.println("Anda memilih untuk keluar dari aplikasi.");
                    System.out.println("Terimakasih atas waktunya.");
                    System.out.println("==================================================================================================================================");
                    loopingMenu = false;
                }
                case -1 -> {
                    System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                    scanner.nextLine();
                }
                default -> {
                    System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu tindakan yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Manajemen Buku");
        System.out.println("2. Manajemen Anggota");
        System.out.println("0. Keluar dari aplikasi");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-2) : ");
    }

    private static void tampilkanBuku() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu di manajemen buku yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Peminjaman Buku");
        System.out.println("3. Pengembalian Buku");
        System.out.println("4. Hapus Data Buku");
        System.out.println("5. Lihat Buku");
        System.out.println("0. Keluar dari menu buku");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-5) : ");
    }

    private static void tampilkanLihatBuku() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu di menu lihat buku yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Lihat buku yang tersedia");
        System.out.println("2. Lihat buku yang dipinjam");
        System.out.println("3. Lihat jumlah buku");
        System.out.println("4. Lihat history buku");
        System.out.println("0. Keluar dari menu lihat buku");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-4) : ");
    }

    private static void tampilkanAnggota() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu di manajemen anggota yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Hapus Anggota");
        System.out.println("3. Lihat Anggota");
        System.out.println("0. Keluar dari menu anggota");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-3) : ");
    }

    // Fungsi untuk mendapatkan pilihan user
    private static int getPilihanUser(Scanner scanner) {
        int pilihanUser;
        // Mengecek inputan pengguna apakah integer atau bukan
        if (scanner.hasNextInt()) {
            pilihanUser = scanner.nextInt();
            scanner.nextLine(); // Untuk membersihkan buffer
        } else {
            scanner.nextLine();
            pilihanUser = -1; // Set untuk nilai yang salah
        }
        return pilihanUser;
    }

    private static void listBuku(List<Book> books) {
        System.out.println("No\tJudul\t\t\t\t\t\t\t\t\t\t\t\t|Penulis\t\t\t\t\t\t\t\t|ISBN");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
            String judul = books.get(indeksBuku).getJudul();
            String penulis = books.get(indeksBuku).getPenulis();
            String isbn = books.get(indeksBuku).getIsbn();
            String statusBuku = books.get(indeksBuku).getStatusBuku();
            int jumlah = books.get(indeksBuku).getJumlah();
            if (statusBuku.equalsIgnoreCase("aktif") && jumlah == 1) {
                System.out.printf("%d.\t%s\t\t\t\t\t\t\t\t|%s\t\t\t\t\t\t\t|%s\n", indeksBuku + 1, judul, penulis, isbn);
            }
        }
    }

    private static void listBukuPinjam(List<Book> books) {
        boolean dataExist = false; // Setel awalnya ke false karena belum ada data yang ditemukan
        System.out.println("No\tJudul\t\t\t\t\t\t\t\t\t\t\t\t|Penulis\t\t\t\t\t\t\t\t|ISBN");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
            String judul = books.get(indeksBuku).getJudul();
            String penulis = books.get(indeksBuku).getPenulis();
            String isbn = books.get(indeksBuku).getIsbn();
            String statusBuku = books.get(indeksBuku).getStatusBuku();
            int jumlah = books.get(indeksBuku).getJumlah();
            if (statusBuku.equalsIgnoreCase("aktif")) {
                if (jumlah == 0) {
                    System.out.printf("%d.\t%s\t\t\t\t\t\t\t\t|%s\t\t\t\t\t\t\t|%s\n", indeksBuku + 1, judul, penulis, isbn);
                    dataExist = true;
                }
            }
        }
        if (!dataExist) {
            System.out.println("Mohon maaf data buku yang dipinjam belum tersedia. Silahkan pinjam buku terlebih dahulu.");
        }
    }

    private static void listJumlahBuku(List<Book> books) {
        System.out.println("No\tJudul\t\t\t\t\t\t\t\t\t\t\t\t|Penulis\t\t\t\t\t\t\t\t|Jumlah");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        List<String> uniqueJuduls = new ArrayList<>();
        List<String> penulisJuduls = new ArrayList<>();
        List<Integer> judulJumlahs = new ArrayList<>();

        for (Book book : books) {
            String judul = book.getJudul();
            String penulis = book.getPenulis();
            String statusBuku = book.getStatusBuku();
            int jumlah = book.getJumlah();

            if (statusBuku.equalsIgnoreCase("aktif")) {
                judul = judul.trim();

                if (uniqueJuduls.contains(judul)) {
                    int index = uniqueJuduls.indexOf(judul);
                    judulJumlahs.set(index, judulJumlahs.get(index) + jumlah);
                } else {
                    uniqueJuduls.add(judul);
                    penulisJuduls.add(penulis);
                    judulJumlahs.add(jumlah);
                }
            }
        }

        for (int indeksBuku = 0; indeksBuku < uniqueJuduls.size(); indeksBuku++) {
            String judul = uniqueJuduls.get(indeksBuku);
            String penulis = penulisJuduls.get(indeksBuku);
            int jumlah = judulJumlahs.get(indeksBuku);

            if (jumlah > 0) {
                System.out.printf("%d.\t%s\t\t\t\t\t\t\t\t|%s\t\t\t\t\t\t\t|%d\n", indeksBuku + 1, judul, penulis, jumlah);
            }
        }
    }



    private static void historyBook(List<String> history) {
        if (history.size() != 0) {
            for (int indeksBuku = 0; indeksBuku < history.size(); indeksBuku++) {
                System.out.printf("%d.\t%s\n", indeksBuku+1, history.get(indeksBuku));
            }
        } else {
            System.out.println("Mohon maaf, data history tidak tersedia. Silahkan lakukan terlebih dahulu peminjaman dan pengembalian buku.");
        }
    }

    private static void listAnggota(List<Anggota> member) {
        System.out.println("No\tID Anggota\t\t\t|Nama");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for (int indeksAnggota = 0; indeksAnggota < member.size(); indeksAnggota++) {
            String idAnggota = member.get(indeksAnggota).getIdAnggota();
            String nama = member.get(indeksAnggota).getNama();
            String statusAnggota = member.get(indeksAnggota).getStatusAnggota();
            if (statusAnggota.equalsIgnoreCase("aktif")) {
                System.out.printf("%d.\t%s\t\t\t\t|%s\n", indeksAnggota + 1, idAnggota, nama);
            }
        }
    }

    private static void tambahBukuBaru(Scanner scanner, List<Book> books) {
        boolean bukuLooping = false;
        while (!bukuLooping) {
            System.out.print("Silahkan inputkan judul buku : ");
            String judulBaru = scanner.nextLine();
            System.out.print("Silahkan inputkan penulis buku : ");
            String penulisBaru = scanner.nextLine();
            boolean isbnValid = false;
            String isbnSpasi = "";
            while (!isbnValid) {
                System.out.print("Silahkan inputkan ISBN buku (13 digit) : ");
                String isbn = scanner.nextLine();
                if (isbn.equalsIgnoreCase("keluar")) {
                    bukuLooping = true;
                    break;
                } else {
                    isbnSpasi = isbn.replaceAll("\\s", "");
                    if (!isbnSpasi.matches("^[0-9]{13}$")) {
                        System.out.println("Mohon maaf, input ISBN tidak boleh " + isbnSpasi.length() + " digit. Dan input ISBN harus berupa 13 digit angka. Silahkan coba kembali. Untuk kembali ke menu, silahkan ketik `keluar`.");
                    } else {
                        StringBuilder formatted = new StringBuilder();
                        formatted.append(isbnSpasi.substring(0, 3)).append("-");
                        formatted.append(isbnSpasi.substring(3, 6)).append("-");
                        formatted.append(isbnSpasi.substring(6, 10)).append("-");
                        formatted.append(isbnSpasi.substring(10, 12)).append("-");
                        formatted.append(isbnSpasi.substring(12, 13));
                        isbnSpasi = formatted.toString();

                        boolean bookExist = cekBuku(books, isbnSpasi);

                        if (bookExist) {
                            System.out.println("Maaf, kode seri buku (ISBN) sudah ada. Silahkan inputkan ISBN yang baru. Untuk kembali ke menu, silahkan ketik `keluar`.");
                            isbnValid = false;
                        } else {
                            tambahBuku(books, judulBaru, penulisBaru, isbnSpasi, 1, "aktif");
                            System.out.println("Selamat! Anda berhasil menambahkan buku baru. Berikut update datanya : ");
                            listBuku(books);
                            isbnValid = true;

                            System.out.print("Apakah Anda ingin menambahkan buku baru lagi (y/n) ? "); // Menanyakan pengguna apakah ingin menambahkan barang
                            String pilihanPengguna = scanner.nextLine();
                            if (!pilihanPengguna.equalsIgnoreCase("y")) {
                                bukuLooping = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void tambahAnggotaBaru(Scanner scanner, List<Anggota> member) {
        boolean loopAnggota = false;
        while (!loopAnggota) {
            System.out.print("Silahkan inputkan nama anggota : ");
            String namaBaru = scanner.nextLine();
            String idAnggota = generateIdAnggota(namaBaru);

            tambahAnggota(member, idAnggota, namaBaru, "aktif");
            System.out.println("Selamat! Anda berhasil menambahkan anggota baru. Berikut update datanya : ");
            listAnggota(member);
            System.out.print("Apakah Anda ingin menambahkan anggota baru lagi (y/n) ? "); // Menanyakan pengguna apakah ingin menambahkan barang
            String pilihanPengguna = scanner.nextLine();
            if (!pilihanPengguna.equalsIgnoreCase("y")) {
                loopAnggota = true;
            }
        }
    }

    private static int runningNumber = 4;

    private static String generateIdAnggota(String namaAnggota) {
        String kodeHuruf = namaAnggota.substring(0, Math.min(3, namaAnggota.length())).toUpperCase();
        String generateIdAnggota = kodeHuruf + runningNumber;
        runningNumber++;

        return generateIdAnggota;
    }

    private static void hapusBuku(Scanner scanner, List<Book> books) {
        boolean hapusValid = false;
        boolean errorMessage = false;
        while (!hapusValid) {
            listBuku(books);
            System.out.print("Silahkan inputkan no buku yang ingin dihapus : ");
            String pilihanHapus = scanner.nextLine();

            if (pilihanHapus.equalsIgnoreCase("keluar")) {
                break;
            } else {
                for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
                    if (pilihanHapus.matches("^[0-9]+$")) {
                        int indexBuku = Integer.parseInt(pilihanHapus);
                        if (indexBuku - 1 == indeksBuku) {
                            books.get(indeksBuku).setStatusBuku("tidak aktif");
                            hapusValid = true;
                            errorMessage = false;
                            System.out.println("Selamat! Buku berhasil terhapus. Berikut update datanya : ");
                            listBuku(books);
                            break;
                        } else {
                            errorMessage = true;
                        }
                    } else {
                        if (books.get(indeksBuku).getJudul().equalsIgnoreCase(pilihanHapus)) {
                            books.get(indeksBuku).setStatusBuku("tidak aktif");
                            hapusValid = true;
                            errorMessage = false;
                            System.out.println("Selamat! Buku berhasil terhapus. Berikut update datanya : ");
                            listBuku(books);
                            break;
                        } else {
                            errorMessage = true;
                        }
                    }
                }

                if (errorMessage) {
                    System.out.println("Maaf, buku belum tersedia. Silahkan pilih buku yang sudah ada. Untuk kembali ke menu, silahkan ketik `keluar`.");
                }
            }
        }
    }

    private static void hapusAnggota(Scanner scanner, List<Anggota> member) {
        boolean hapusValid = false;
        boolean errorMessage = false;
        while (!hapusValid) {
            listAnggota(member);
            System.out.print("Silahkan inputkan no anggota yang ingin dihapus : ");
            String pilihanHapus = scanner.nextLine();

            if (pilihanHapus.equalsIgnoreCase("keluar")) {
                break;
            } else {
                for (int indeksAnggota = 0; indeksAnggota < member.size(); indeksAnggota++) {
                    if (pilihanHapus.matches("^[0-9]+$")) {
                        int indexAnggota = Integer.parseInt(pilihanHapus);
                        if (indexAnggota - 1 == indeksAnggota) {
                            member.get(indeksAnggota).setStatusAnggota("tidak aktif");
                            hapusValid = true;
                            errorMessage = false;
                            System.out.println("Selamat! Anggota berhasil terhapus. Berikut update datanya : ");
                            listAnggota(member);
                            break;
                        } else {
                            errorMessage = true;
                        }
                    } else {
                        if (member.get(indeksAnggota).getNama().equalsIgnoreCase(pilihanHapus) || member.get(indeksAnggota).getIdAnggota().equalsIgnoreCase(pilihanHapus)) {
                            member.get(indeksAnggota).setStatusAnggota("tidak aktif");
                            hapusValid = true;
                            errorMessage = false;
                            System.out.println("Selamat! Anggota berhasil terhapus. Berikut update datanya : ");
                            listAnggota(member);
                            break;
                        } else {
                            errorMessage = true;
                        }
                    }
                }

                if (errorMessage) {
                    System.out.println("Maaf, nama anggota tidak ada dalam data. Silahkan pilih nama anggota yang sudah ada. Untuk kembali ke menu, silahkan ketik `keluar`.");
                }
            }
        }
    }

    private static boolean cekAnggota(List<Anggota> member, String idAnggota) {
        boolean anggotaExist = false;
        for (int indeksAnggota = 0; indeksAnggota < member.size(); indeksAnggota++) {
            String idAnggotaCek = member.get(indeksAnggota).getIdAnggota();
            if (idAnggotaCek.equalsIgnoreCase(idAnggota)) {
                anggotaExist = true;
                break;
            }
        }
        return anggotaExist;
    }

    private static boolean cekBuku(List<Book> books, String isbnSpasi) {
        boolean bookExist = false;
        for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
            String isbnCek = books.get(indeksBuku).getIsbn();
            if (isbnCek.equalsIgnoreCase(isbnSpasi)) {
                bookExist = true;
                break;
            }
        }
        return bookExist;
    }

    private static String formatWaktu() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Membuat objek SimpleDateFormat dengan timezone Asia/Jakarta dan locale Indonesia
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        // Memformat Timestamp menjadi tanggal Indonesia
        String formattedDate = sdf.format(timestamp);

        // Menampilkan hasilnya
        return formattedDate;
    }

    private static void pinjamBuku(Scanner scanner, List<Book> books, List<Anggota> member, List<String> history) {
        boolean loopPinjam = false;
        while (!loopPinjam) {
            listBuku(books);
            boolean idAnggotaValid = false;
            while (!idAnggotaValid) {
                System.out.print("Silahkan inputkan id anggota peminjam : ");
                String idAnggota = scanner.nextLine();
                if (idAnggota.equalsIgnoreCase("keluar")) {
                    loopPinjam = true;
                    break;
                } else {
                    boolean anggotaExist = cekAnggota(member, idAnggota);
                    if (anggotaExist) {
                        boolean isbnValid = false;
                        while (!isbnValid) {
                            System.out.print("Silahkan inputkan ISBN buku yang ingin dipinjam(hanya angka) : ");
                            String isbn = scanner.nextLine();

                            if (isbn.equalsIgnoreCase("keluar")) {
                                idAnggotaValid = true;
                                loopPinjam = true;
                                break;
                            } else {
                                String isbnSpasi = isbn.replaceAll("\\s", "");
                                if (!isbnSpasi.matches("^[0-9]{13}$")) {
                                    System.out.println("Mohon maaf, input ISBN tidak boleh " + isbnSpasi.length() + " digit. Dan input ISBN harus berupa 13 digit angka. Silahkan coba kembali. Untuk kembali ke menu, silahkan ketik `keluar`.");
                                } else {
                                    StringBuilder formatted = new StringBuilder();
                                    formatted.append(isbnSpasi.substring(0, 3)).append("-");
                                    formatted.append(isbnSpasi.substring(3, 6)).append("-");
                                    formatted.append(isbnSpasi.substring(6, 10)).append("-");
                                    formatted.append(isbnSpasi.substring(10, 12)).append("-");
                                    formatted.append(isbnSpasi.substring(12, 13));
                                    isbnSpasi = formatted.toString();
                                    isbnValid = true;

                                    boolean bookExist = cekBuku(books, isbnSpasi);
                                    if (bookExist) {
                                        boolean validJumlah = false;
                                        for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
                                            String cekIsbn = books.get(indeksBuku).getIsbn();
                                            int cekJumlah = books.get(indeksBuku).getJumlah();
                                            if (cekIsbn.equalsIgnoreCase(isbnSpasi) && cekJumlah == 1) {
                                                String judul = books.get(indeksBuku).getJudul();
                                                int jumlah = books.get(indeksBuku).getJumlah();
                                                int kalkulasi = jumlah - 1;
                                                books.get(indeksBuku).setJumlah(kalkulasi);
                                                for (int indeksMember = 0; indeksMember < member.size(); indeksMember++) {
                                                    if (idAnggota.equalsIgnoreCase(member.get(indeksMember).getIdAnggota())) {
                                                        String namaMember = member.get(indeksMember).getNama();
                                                        history.add("Buku " + judul + " sedang dipinjam oleh " + namaMember + " di tanggal " + formatWaktu() + ".");
                                                        break;
                                                    }
                                                }
                                                System.out.println("Selamat! Anda berhasil meminjam buku " + judul + " di perpustakaan ini.");
                                                validJumlah = true;
                                                break;
                                            }
                                        }
                                        if (!validJumlah) {
                                            System.out.println("Mohon maaf buku ini sedang dipinjam.");
                                        }
                                        System.out.print("Apakah Anda ingin meminjam buku lagi (y/n) ? "); // Menanyakan pengguna apakah ingin meminjam buku lagi?
                                        String pilihanPengguna = scanner.nextLine();
                                        if (!pilihanPengguna.equalsIgnoreCase("y")) {
                                            idAnggotaValid = true;
                                            loopPinjam = true;
                                            break;
                                        }
                                    } else {
                                        System.out.println("Mohon maaf buku dengan ISBN " + isbnSpasi + " tidak ada dalam data. Silahkan inputkan data yang sudah ada. Jika ingin kembali ke menu, ketik `keluar`.");
                                        isbnValid = false;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Mohon maaf anggota dengan id " + idAnggota + " tidak ada dalam data. Silahkan inputkan data yang sudah ada. Jika ingin kembali ke menu, ketik `keluar`.");
                    }
                }
            }
        }
    }

    private static void pengembalianBuku(Scanner scanner, List<Book> books, List<String> history) {
        boolean loopKembali = false;
        while (!loopKembali) {
            listBukuPinjam(books);
            boolean isbnValid = false;
            while (!isbnValid) {
                System.out.print("Silahkan inputkan ISBN buku yang ingin dipinjam(hanya angka) : ");
                String isbn = scanner.nextLine();

                if (isbn.equalsIgnoreCase("keluar")) {
                    loopKembali = true;
                    break;
                } else {
                    String isbnSpasi = isbn.replaceAll("\\s", "");
                    if (!isbnSpasi.matches("^[0-9]{13}$")) {
                        System.out.println("Mohon maaf, input ISBN tidak boleh " + isbnSpasi.length() + " digit. Dan input ISBN harus berupa 13 digit angka. Silahkan coba kembali. Untuk kembali ke menu, silahkan ketik `keluar`.");
                    } else {
                        StringBuilder formatted = new StringBuilder();
                        formatted.append(isbnSpasi.substring(0, 3)).append("-");
                        formatted.append(isbnSpasi.substring(3, 6)).append("-");
                        formatted.append(isbnSpasi.substring(6, 10)).append("-");
                        formatted.append(isbnSpasi.substring(10, 12)).append("-");
                        formatted.append(isbnSpasi.substring(12, 13));
                        isbnSpasi = formatted.toString();
                        isbnValid = true;

                        boolean bookExist = cekBuku(books, isbnSpasi);
                        if (bookExist) {
                            boolean cekPinjam = true;
                            for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
                                String cekIsbn = books.get(indeksBuku).getIsbn();
                                int jumlah = books.get(indeksBuku).getJumlah();
                                if (cekIsbn.equalsIgnoreCase(isbnSpasi)) {
                                    if (jumlah == 0) {
                                        String judul = books.get(indeksBuku).getJudul();;
                                        int kalkulasi = jumlah + 1;
                                        books.get(indeksBuku).setJumlah(kalkulasi);
                                        history.add("Buku " + judul + " sudah dikembalikan" + " di tanggal " + formatWaktu() + ".");
                                        System.out.println("Selamat! Anda berhasil mengambalikan buku " + judul + " ke perpustakaan ini.");
                                        cekPinjam = true;
                                    } else {
                                        cekPinjam = false;
                                        isbnValid = false;
                                    }
                                }
                            }
                            if (cekPinjam == false) {
                                System.out.println("Mohon maaf buku ini tidak dipinjamkan.  Silahkan inputkan buku yang sedang dipinjam. Jika ingin kembali ke menu, ketik `keluar`.");
                            }
                            System.out.print("Apakah Anda ingin mengembalikan buku lagi (y/n) ? "); // Menanyakan pengguna apakah ingin meminjam buku lagi?
                            String pilihanPengguna = scanner.nextLine();
                            if (!pilihanPengguna.equalsIgnoreCase("y")) {
                                loopKembali = true;
                                break;
                            }
                        } else {
                            System.out.println("Mohon maaf buku dengan ISBN " + isbnSpasi + " tidak ada dalam data. Silahkan inputkan data yang sudah ada. Jika ingin kembali ke menu, ketik `keluar`.");
                            isbnValid = false;
                        }
                    }
                }
            }
        }
    }
}
