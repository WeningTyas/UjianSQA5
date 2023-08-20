package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//span[@class='title']")
    WebElement txtCheckout;

    public void tambahProduk(){
        btnCheckout.click();
        System.out.println("checkout");
    }

    public String getTxtCheckout(){
        return txtCheckout.getText();
    }
}
