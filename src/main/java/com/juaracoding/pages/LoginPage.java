package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtError;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement txtDashboard;

    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement txtLogin;

    public void loginForm(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
        System.out.println("Masukkan Username & Password");
    }

    public String getTxtMessage(){
        return txtError.getText();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtLogin(){
        return txtLogin.getText();
    }

    public void clear(){
        username.clear();
        password.clear();
    }
}
