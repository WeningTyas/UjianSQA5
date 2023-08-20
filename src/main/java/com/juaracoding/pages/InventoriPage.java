package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoriPage {
    private WebDriver driver;

    public InventoriPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement produkSatu;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement produkDua;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement keranjang;

    @FindBy(xpath = "//span[@class='title']")
    WebElement txtCart;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement btnMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement menuLogout;

    public void tambahProduk(){
        produkSatu.click();
        produkDua.click();
        keranjang.click();
        System.out.println("sudah ditambah");
    }
    public String getTxtCart(){
        return txtCart.getText();
    }
    public void logout(){
        btnMenu.click();
        menuLogout.click();
        System.out.println("Logout");
    }
}
