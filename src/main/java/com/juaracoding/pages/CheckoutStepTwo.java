package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwo {
    private WebDriver driver;

    public CheckoutStepTwo() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtHalaman;
    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnFinish;
    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement txtSuccess;

    public String getTxtHalaman(){
        return txtHalaman.getText();
    }
    public void clickFinish(){
        btnFinish.click();
    }
    public String getTxtSuccess(){
        return txtSuccess.getText();
    }
}
