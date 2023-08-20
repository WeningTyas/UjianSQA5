package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne {

    private WebDriver driver;

    public CheckoutStepOne() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement inputNamaDepan;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement inputNamaBelakang;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement inputPostCode;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnLanjutkan;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtError;
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtCheckout;

    public void tambahPenerima(String namaDepan, String namaBelakang, String postCode){
        inputNamaDepan.sendKeys(namaDepan);
        inputNamaBelakang.sendKeys(namaBelakang);
        inputPostCode.sendKeys(postCode);
        btnLanjutkan.click();
        System.out.println("Isi data diri");
    }
    public String getTxtError(){
        return txtError.getText();
    }
    public String getTxtCheckout(){
        return txtCheckout.getText();
    }
}
