package com.juaracoding;

public class ATM {
    public double saldo;

    // menginisialisasi saldo awal
    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    // melihat saldo
    public double lihatSaldo() {
        return saldo;
    }

    // menyetor uang
    public void setorUang(double jumlah) {
        if (saldo > 0) {
            saldo += jumlah;
        } else {
            throw new IllegalArgumentException("jumlah harus lebih besar dari 0");
        }

    }

    // menarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
        } else if (jumlah > saldo) {
            throw new IllegalArgumentException("Saldo tidak mencukupi");
        } else {
            throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
        }
    }
}


