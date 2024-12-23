package org.example;

import jdk.internal.classfile.impl.ClassPrinterImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class BookingSayurGUI {

    static final List<Pesanan> daftarPesanan = new ArrayList<>();
    public static ClassPrinterImpl.MapNodeImpl Pesanan;

    public static void main(String[] args) {
        Pesanan pesanan1 = new Pesanan("John Doe", "Jl. Mawar", "Bayam", 5);
        Pesanan pesanan2 = new Pesanan("Jane Doe", "Jl. Melati", "Kangkung", 3);
        daftarPesanan.add(pesanan1);
        daftarPesanan.add(pesanan2);

        tampilkanPesanan();

        updatePesanan(pesanan1);

        hapusPesanan(pesanan2);

        tampilkanPesanan();

        simpanPesananKeFile();
    }

    private static void tampilkanPesanan() {
        System.out.println("Daftar Pesanan:");
        for (Pesanan pesanan : daftarPesanan) {
            System.out.println(pesanan);
        }
    }

    static void updatePesanan(Pesanan pesanan) {
        pesanan.setNamaPembeli("John Doe");
        pesanan.setAlamat("Jl. Kenanga");
        pesanan.setPesanan("Sawi");
        pesanan.setJumlah(6);
        System.out.println("Pesanan telah diperbarui.");
    }

    static void hapusPesanan(Pesanan pesanan) {
        daftarPesanan.remove(pesanan);
        System.out.println("Pesanan telah dihapus.");
    }

    static void simpanPesananKeFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("pesanan.txt"))) {
            for (Pesanan pesanan : daftarPesanan) {
                writer.write(pesanan.getNamaPembeli() + "," + pesanan.getAlamat() + "," + pesanan.getPesanan() + "," + pesanan.getJumlah());
                writer.newLine();
            }
            System.out.println("Pesanan telah disimpan ke file: " + "pesanan.txt");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    static class Pesanan {
        private String namaPembeli;
        private String alamat;
        private String pesanan;
        private int jumlah;

        public Pesanan(String namaPembeli, String alamat, String pesanan, int jumlah) {
            this.namaPembeli = namaPembeli;
            this.alamat = alamat;
            this.pesanan = pesanan;
            this.jumlah = jumlah;
        }

        public String getNamaPembeli() {
            return namaPembeli;
        }

        public void setNamaPembeli(String namaPembeli) {
            this.namaPembeli = namaPembeli;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getPesanan() {
            return pesanan;
        }

        public void setPesanan(String pesanan) {
            this.pesanan = pesanan;
        }

        public int getJumlah() {
            return jumlah;
        }

        public void setJumlah(int jumlah) {
            this.jumlah = jumlah;
        }

        @Override
        public String toString() {
            return "Nama Pembeli: " + namaPembeli + ", Alamat: " + alamat + ", Pesanan: " + pesanan + ", Jumlah: " + jumlah;
        }
    }
}
