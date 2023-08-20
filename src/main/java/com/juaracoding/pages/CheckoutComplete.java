package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
    private WebDriver driver;

    public CheckoutComplete() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement btnBack;

    public void kembali(){
        btnBack.click();
        System.out.println("Kembali ke Home");
    }
}
