import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static List<Book> tambahBuku (List<Book> books, String judul, String penulis, String isbn, int jumlah, String statusBuku) {
        books.add(new Book(judul, penulis, isbn, jumlah, statusBuku));
        return books;
    }

    public static List<Anggota> tambahAnggota (List<Anggota> member, String idAnggota, String nama, String statusAnggota) {
        member.add(new Anggota(idAnggota, nama, statusAnggota));
        return member;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Menanti Hari Berganti", "Titi Sanaria", "978-623-5592-06-0", 1, "aktif"));
        books.add(new Book("Sunset Bersama Rosie", "Tere Liye Dar", "978-623-9607-46-3", 1,"aktif"));
        books.add(new Book("Hujan di Hari Minggu", "Tere Liye Dar", "978-602-0324-78-4", 1,"aktif"));
        books.add(new Book("Mariposa Angan Angan", "Luluk Fajriya", "978-602-5508-61-5", 1, "aktif"));

        List<Anggota> member = new ArrayList<>();
        member.add(new Anggota("THA1", "Tharissa Najwa", "aktif"));
        member.add(new Anggota("PUT2", "Putri Budiman", "aktif"));
        member.add(new Anggota("ATH3", "Athifa Rasya P", "aktif"));

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
                        // Menangani pilihan switch case user dengan switch case
                        switch (pilihanMenuKategoriBuku) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan buku baru.");
                                tambahBukuBaru(scanner, books); // Memanggil fungsi tambah kategori baru dengan menyertakan scanner beserta arrayList nya(data set barang dan stok)
                            }
                            case 2 -> {
//                                System.out.println("Anda memilih menu untuk menghapus kategori.");
//                                hapusKategori(scanner, gudang); // Memangil fungsi menghapus kategori
                            }
                            case 3 -> {
//                                System.out.println("Anda memilih menu untuk mengganti nama kategori.");
//                                ubahNamaKategori(scanner, gudang); // Memanggil fungsi ubah nama kategori
                            }
                            case 4 -> {
                                System.out.println("Anda memilih menu untuk menghapus buku.");
                                hapusBuku(scanner, books); // Memanggil fungsi hapus buku
                            }
                            case 5 -> {
                                System.out.println("Anda memilih menu untuk melihat buku yang tersedia.");
                                listBuku(books); // Memanggil fungsi lihat kategori
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
                                System.out.println("Anda memilih menu untuk menghapus anggota.");
                                hapusAnggota(scanner, member); // Memanggil fungsi hapus anggota
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk melihat anggota yang masih aktif.");
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

    private static  void tampilkanMenu() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu tindakan yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Manajemen Buku");
        System.out.println("2. Manajemen Anggota");
        System.out.println("0. Keluar dari aplikasi");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-2) : ");
    }

    private static  void tampilkanBuku() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu di manajemen buku yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Pengembalian Buku");
        System.out.println("4. Hapus Data Buku");
        System.out.println("5. Lihat Buku");
        System.out.println("0. Keluar dari menu buku");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-5) : ");
    }

    private static  void tampilkanAnggota() {
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
            if (statusBuku.equalsIgnoreCase("aktif")) {
                System.out.printf("%d.\t%s\t\t\t\t\t\t\t\t|%s\t\t\t\t\t\t\t|%s\n", indeksBuku+1, judul, penulis, isbn);
            }
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
                System.out.printf("%d.\t%s\t\t\t\t|%s\n", indeksAnggota+1, idAnggota, nama);
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
                    if ((isbnSpasi.length() != 13) && (!isbnSpasi.matches("^[0-9]+$")) && isbn.length() != 13) {
                        System.out.println("Mohon maaf, input ISBN tidak boleh " + isbnSpasi.length() + " digit angka. Input ISBN harus 13 digit angka. Silahkan coba kembali. Untuk kembali ke menu, silahkan ketik `keluar`.");
                    } else {
                        StringBuilder formatted = new StringBuilder();
                        formatted.append(isbnSpasi.substring(0, 3)).append("-");
                        formatted.append(isbnSpasi.substring(3, 6)).append("-");
                        formatted.append(isbnSpasi.substring(6, 10)).append("-");
                        formatted.append(isbnSpasi.substring(10, 12)).append("-");
                        formatted.append(isbnSpasi.substring(12, 13));
                        isbnSpasi = formatted.toString();
                        isbnValid = true;
                    }
                }

                boolean bookExist = false;
                for (int indeksBuku = 0; indeksBuku < books.size(); indeksBuku++) {
                    String isbnCek = books.get(indeksBuku).getIsbn();
                    if (isbnCek.equalsIgnoreCase(isbnSpasi)) {
                        bookExist = true;
                        break;
                    }
                }

                if (bookExist) {
                    System.out.println("Maaf, kode seri buku (ISBN) sudah ada. Silahkan inputkan ISBN yang baru. Untuk kembali ke menu, silahkan ketik `keluar`.");
                    isbnValid = false;
                } else {
                    tambahBuku(books, judulBaru, penulisBaru, isbnSpasi, 1, "aktif");
                    System.out.println("Selamat! Anda berhasil menambahkan buku baru. Berikut update datanya : ");
                    listBuku(books);

                    System.out.print("Apakah Anda ingin menambahkan buku baru lagi (y/n) ? "); // Menanyakan pengguna apakah ingin menambahkan barang
                    String pilihanPengguna = scanner.nextLine();
                    if (!pilihanPengguna.equalsIgnoreCase("y")) {
                        bukuLooping = true;
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

    private static void hapusBuku(Scanner scanner, List<Book> books){
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
                        if (indexBuku -1 == indeksBuku) {
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

    private static void hapusAnggota(Scanner scanner, List<Anggota> member){
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


}
