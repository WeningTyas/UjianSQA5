package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.*;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSwagLabs {
    WebDriver driver;
    LoginPage loginPage;
    InventoriPage inventoriPage;
    CartPage cartPage;
    CheckoutStepOne checkoutStepOne;
    CheckoutStepTwo checkoutStepTwo;
    CheckoutComplete checkoutComplete;
    General general;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage();
        inventoriPage = new InventoriPage();
        cartPage = new CartPage();
        checkoutStepOne = new CheckoutStepOne();
        checkoutStepTwo = new CheckoutStepTwo();
        checkoutComplete = new CheckoutComplete();
        general = new General(driver);
    }

    @AfterClass
    public void finish(){
        General.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @BeforeMethod
    public void refresh(){
        // beri jeda di setiap methode yg berjalan
        General.refresh(driver);
        General.delay(2);
    }

    ////================================ LOGIN ================================////
    //======= Negative Test =======//
    @Test (priority = 1)
    public void invalidLoginTest(){
        loginPage.loginForm("", "");
        String actual = loginPage.getTxtMessage();
        String expected = "Username is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu username & password");
    }
    @Test (priority = 2)
    public void testLoginWithoutUsername(){
        loginPage.loginForm("", "secret_sauce");
        String actual = loginPage.getTxtMessage();
        String expected = "Username is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu username");
    }
    @Test (priority = 3)
    public void testLoginWithoutPassword(){
        loginPage.loginForm("standard_user", "");
        String actual = loginPage.getTxtMessage();
        String expected = "Password is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu password");
    }
    @Test (priority = 4)
    public void testLoginNotMatch(){
        loginPage.loginForm("standard_users", "secret_sauce");
        String actual = loginPage.getTxtMessage();
        String expected = "Username and password do not match";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Username atau password salah!");
    }

    //======= Positive Test =======//
    @Test (priority = 5)
    public void validLoginTest(){
        loginPage.loginForm("standard_user", "secret_sauce");
        String actual = loginPage.getTxtDashboard();
        Assert.assertEquals(actual, "Swag Labs");
        System.out.println("Berhasil login!");
    }

    ////================================ Tambah Produk ================================////
    @Test (priority = 6)
    public void testTambahProduk(){
        inventoriPage.tambahProduk();
        String actual = inventoriPage.getTxtCart();
        Assert.assertEquals(actual, "Your Cart");
        System.out.println("Di halaman Cart");
    }
    @Test (priority = 7)
    public void testCheckout(){
        cartPage.tambahProduk();
        String actual = cartPage.getTxtCheckout();
        String expected = "Your Information";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Isi data sebelum Checkout");
    }

    ////================================ Checkout ================================////
    //======= Negative Test =======//
    @Test (priority = 8)
    public void invalidChekoutTest(){
        checkoutStepOne.tambahPenerima("", "", "");
        String actual = checkoutStepOne.getTxtError();
        String expected = "First Name is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Checkout perlu First Name");
    }
    @Test (priority = 9)
    public void testChekoutWithFirstName(){
        checkoutStepOne.tambahPenerima("Wening", "", "");
        String actual = checkoutStepOne.getTxtError();
        String expected = "Last Name is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Checkout perlu Last Name");
    }
    @Test (priority = 10)
    public void testChekoutWithoutPosCode(){
        checkoutStepOne.tambahPenerima("Wening", "Tyas Putri", "");
        String actual = checkoutStepOne.getTxtError();
        String expected = "Postal Code is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Checkout perlu Postal Kode");
    }
    //======= Positive Test =======//
    @Test (priority = 11)
    public void validChekoutTest(){
        checkoutStepOne.tambahPenerima("Wening", "Tyas Putri", "11640");
        String actual = checkoutStepOne.getTxtCheckout();
        String expected = "Overview";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Berhasil dicheckout!");
    }
    @Test (priority = 12)
    public void testEndCheckout(){
        general.scrollBy(0, 500);

        System.out.println("ini");
        checkoutStepTwo.clickFinish();
        String actual = checkoutStepTwo.getTxtHalaman();
        System.out.println(actual);
        String expected = "Complete!";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Checkout selesai!");
    }
    ////================================ Logout ================================////
    @Test (priority = 13)
    public void kembaliKeHome(){
        checkoutComplete.kembali();
        String actual = loginPage.getTxtDashboard();
        Assert.assertEquals(actual, "Swag Labs");
    }

    @Test (priority = 14)
    public void logout(){
        inventoriPage.logout();
        String actual = loginPage.getTxtLogin();
        Assert.assertEquals(actual, "Swag Labs");
    }
}





/*
 * Expect (di Harapkan) & Actual (Aktual/hasil)
 *
 * Website: https://www.saucedemo.com/
 * uname : "standard_user"
 * pwd   : "secret_sauce"
 * */