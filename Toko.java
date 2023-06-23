import java.util.Scanner;

class Barang {
    String nama;
    int harga;
    int stok;

    public Barang(String nama, int harga, int stok) { //konstraktor barang
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
}

public class Toko {
    private static final int MAX_BARANG = 3; // Jumlah maksimum barang yang dapat disimpan
    private Barang[] daftarBarang;
    private int jumlahBarang;

    public Toko() {
        daftarBarang = new Barang[MAX_BARANG];
        jumlahBarang = 0;
    }

    public void tambahBarang(Barang barang) {
        if (jumlahBarang < MAX_BARANG) {
            daftarBarang[jumlahBarang] = barang;
            jumlahBarang++;
            System.out.println("Barang berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas toko penuh, tidak dapat menambah barang!");
        }
    }

    public Barang cariBarang(String nama) {
        for (int i = 0; i < jumlahBarang; i++) { //melakukan perulangannya dibatasi dengan jumlah barang
            if (daftarBarang[i].nama.equalsIgnoreCase(nama)) {
                return daftarBarang[i];
            }
        }
        return null; // Barang tidak ditemukan
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //inputan
        Toko toko = new Toko();

        System.out.println("===============================================");
        System.out.println("        Selamat Datang Di Mebel Keren          ");
        System.out.println("              Mebel Keren Meriah               ");
        System.out.println("               Jajag Banyuwangi                ");
        System.out.println("            Tlp :(0333) 123 321.               ");
        System.out.println("                Berkah Selalu                  ");
        System.out.println("-----------------------------------------------");

        System.out.print("Masukkan jumlah barang yang akan ditambahkan: ");
        int jumlahBarang = input.nextInt(); //inputan berupa angka

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            System.out.print("Nama barang: ");
            String nama = input.next();
            System.out.print("Harga barang: ");
            int harga = input.nextInt();
            System.out.print("Stok barang: ");
            int stok = input.nextInt();

            Barang barang = new Barang(nama, harga, stok);
            toko.tambahBarang(barang);
        }

        System.out.print("\nMasukkan nama barang yang ingin dicari: ");
        String namaCari = input.next();

        Barang barangDitemukan = toko.cariBarang(namaCari);
        if (barangDitemukan != null) {
            System.out.println("\nBarang ditemukan!");
            System.out.println("Nama: " + barangDitemukan.nama);
            System.out.println("Harga: " + barangDitemukan.harga);
            System.out.println("Stok: " + barangDitemukan.stok);
        } else {
            System.out.println("\nBarang tidak ditemukan!");
        }
        input.close();
    }
}