package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class ATMTest {
    private ATM atm;

    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000.0);
    }

    @Test(priority = 1)
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000.0);
    }

    // Menguji apakah metode setorUang() bekerja dengan valid
    @Test(priority = 2)
    public void testSetorUang() {
        atm.setorUang(500.0);
        Assert.assertEquals(atm.lihatSaldo(), 1500.0);
    }

    // menguji apakah metode setorUang() dengan melempar pengecualian untuk jumlah negatif
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testsetorUangNegatif() {
        atm.tarikUang(-500.0);
    }


    // menguji apakah metode tarikUang bekerja dengan valid
    @Test(priority = 3)
    public void testTarikUang() {
        atm.tarikUang(500.0);
        Assert.assertEquals(atm.lihatSaldo(), 500.0);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang ditarik melebihi saldo
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(1500.0);
    }

    // menguji apakah metode tarikUang() dengan melempar pengecualian untuk jumlah negatif
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-500.0);
    }
}
