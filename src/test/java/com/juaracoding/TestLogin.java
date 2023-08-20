package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
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

    //======= Negative Test =======//
    @Test
    public void invalidLoginTest(){
        loginPage.loginForm("", "");
        String actual = loginPage.getTxtMessage();
        String expected = "Username is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu username & password");
    }

    @Test
    public void testLoginWithoutUsername(){
        loginPage.loginForm("", "secret_sauce");
        String actual = loginPage.getTxtMessage();
        String expected = "Username is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu username");
    }
    @Test
    public void testLoginWithoutPassword(){
        loginPage.loginForm("standard_user", "");
        String actual = loginPage.getTxtMessage();
        String expected = "Password is required";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Login perlu password");
    }
    @Test
    public void testLoginNotMatch(){
        loginPage.loginForm("standard_users", "secret_sauce");
        String actual = loginPage.getTxtMessage();
        String expected = "Username and password do not match";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Username atau password salah!");
    }

    //======= Positive Test =======//
    @Test
    public void validLoginTest(){
        loginPage.loginForm("standard_user", "secret_sauce");
        String actual = loginPage.getTxtDashboard();
        Assert.assertEquals(actual, "Swag Labs");
        System.out.println("Berhasil login!");
    }
}





/*
 * Expect (di Harapkan) & Actual (Aktual/hasil)
 *
 * Website: https://www.saucedemo.com/
 * uname : "standard_user"
 * pwd   : "secret_sauce"
 * */