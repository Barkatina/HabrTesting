package com.example.habrtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdministrationPage {
    private WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//*[contains(text(),'Администрирование')]")
    private WebElement administration ;
    @FindBy(xpath = "//*[contains(text(),'Хабы')]")
    private WebElement hubs;
    @FindBy(css="input.tm-input-text-decorated_input")
    private WebElement searchField;
    @FindBy(css = "a.tm-header__become-author-btn")
    private WebElement becomeAnAuthor;
    @FindBy(css="svg.tm-svg-img.tm-header-user-menu__icon.tm-header-user-menu__icon_write")
    private WebElement writeAnArticle;
    @FindBy(css="button.btn.btn_solid.btn_small.tm-header-user-menu__login")
    private WebElement enter;
    @FindBy(css="input#email_field")
    private WebElement user;
    @FindBy(css="input#password_field")
    private WebElement password;
    @FindBy(css="div.recaptcha-checkbox-borderAnimation")
    private WebElement checkbox;
    @FindBy(css="button.button.button_wide.button_primary")
    private WebElement buttonEnter;
    @FindBy(css="div.s-error")
    private WebElement enterTheCorrectOne;

    public boolean becomeAnAuthorFind() {
        return becomeAnAuthor.isEnabled();
    }
    public boolean becomeEnterFind() {
        return enter.isEnabled();
    }
    public String checkEnterClickable () {
        wait.until(ExpectedConditions.visibilityOfAllElements(enter));
        enter.click();
        return driver.getCurrentUrl();
    }

    public  boolean findAdministration(){
        administration.click();
        return hubs.isDisplayed();
    }
    public void clickHubs(){
        administration.click();
        hubs.click();
    }
    public void setText(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введен текст:" + text);}
    public String getTextFromSearchField(){
        String val = searchField.getAttribute("value");
        return val;
    }
    public String checkBecomeAnAuthorClickable() {
        wait.until(ExpectedConditions.visibilityOfAllElements(becomeAnAuthor));
        becomeAnAuthor.click();
        return driver.getCurrentUrl();
    }
    public boolean checkWriteAnArticleClickable() {
        //"Проверка активности кнопки написать публикацию");
        wait.until(ExpectedConditions.visibilityOfAllElements(writeAnArticle));
        return writeAnArticle.isEnabled();
    }
    public void setUserText(String text) {
        user.sendKeys(text);
        user.submit();
        System.out.println("Введен текст:" + text);}
    public void setPasswordText(String text) {
        password.sendKeys(text);
        password.submit();
        System.out.println("Введен текст:" + text);}
    public void unregisteredUserEnter(){
        enter.click();
        setUserText("aa6");
        setPasswordText("25654");
        checkbox.click();
        buttonEnter.click();
       String enterTheCorrectOne="Введите корректный e-mail";


    }
    public AdministrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }



}
