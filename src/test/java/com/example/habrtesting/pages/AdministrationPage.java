package com.example.habrtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdministrationPage {
    private final Logger LOG = LoggerFactory.getLogger(AdministrationPage.class);
    private WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//*[contains(text(),'Администрирование')]")
    private WebElement administration;
    @FindBy(xpath = "//*[contains(text(),'Хабы')]")
    private WebElement hubs;
    @FindBy(css = "h2.tm-block__title.tm-block__title")
    private WebElement campaignContri;

    @FindBy(css = "input.tm-input-text-decorated__input")
    private WebElement searchField;
    @FindBy(css = "svg.tm-svg-img.tm-header-user-menu__icon.tm-header-user-menu__icon_write")
    private WebElement writeAnArticle;
    @FindBy(css = "button.btn.btn_solid.btn_small.tm-header-user-menu__login")
    private WebElement enter;
    @FindBy(css = "a.form__remind-password-link ")
    private WebElement remindPassword;
    @FindBy(css = "a.form-additional-message__link")
    private WebElement registr;
    @FindBy(css = "button.tm-header-user-menu__toggle")
    private WebElement settings;
    @FindBy(css = "div.tm-page-settings-form__title")
    private WebElement settingsActive;
    @FindBy(css = "svg.tm-svg-img.icon_dropdown-arrow")
    private WebElement dropDownEverythingInARow;
    @FindBy(css = "button.tm-navigation-filters-tabs__option-button.tm-navigation-filters-tabs__option-button_active")
    private WebElement theBestButton;


    public boolean becomeEnterFind() {
        LOG.info("Проврека активности кнопки войти");
        return enter.isEnabled();
    }

    public String checkEnterClickable() {
        LOG.info("Переход на страницу 'Хабр Аккаунт'");
        wait.until(ExpectedConditions.visibilityOfAllElements(enter));
        enter.click();
        return driver.getCurrentUrl();
    }

    public boolean campaignContributionsFind() {
        LOG.info("Проврека наличия раздела 'Вклад компаний'");
        administration.click();
        hubs.click();
        return campaignContri.isDisplayed();
    }

    public boolean findAdministration() {
        LOG.info("Проврека наличия раздела Хабы");
        administration.click();
        return hubs.isDisplayed();
    }

    public void clickHubs() {
        LOG.info("Переход в раздел 'Хабы'");
        administration.click();
        hubs.click();
    }

    public void setText(String text) {
        LOG.info("Проверка, что текст ввода остается в строке");
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введен текст:" + text);
    }

    public String getTextFromSearchField() {
        String val = searchField.getAttribute("value");
        return val;
    }

    public boolean checkWriteAnArticleClickable() {
        LOG.info("Проверка активности кнопки написать публикацию");
        wait.until(ExpectedConditions.visibilityOfAllElements(writeAnArticle));
        return writeAnArticle.isEnabled();
    }

    public boolean becomeRemindPasswordFind() {
        LOG.info("Наличие кнопки Войти");
        enter.click();
        return remindPassword.isDisplayed();
    }

    public String checkAccounHabrClickable() {
        LOG.info("Переход на страницу 'Восстановление пароля'");
        wait.until(ExpectedConditions.visibilityOfAllElements(enter));
        enter.click();
        remindPassword.click();
        return driver.getCurrentUrl();
    }

    public boolean becomeRegistrFind() {
        LOG.info("Поиск кнопки регистрация");
        enter.click();
        remindPassword.click();
        return registr.isDisplayed();
    }

    public String checkRegistrClickable() {
        LOG.info("Переход на страницу регистрации аккаунта");
        wait.until(ExpectedConditions.visibilityOfAllElements(enter));
        enter.click();
        remindPassword.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(registr));
        registr.click();
        return driver.getCurrentUrl();
    }

    public boolean becomeSettingsFind() {
        LOG.info("Поиск кнопки настройки");
        return settings.isDisplayed();
    }

    public boolean dropDownEverythingInARowActive() {
        LOG.info("Поиск drop down 'все подряд'");
        administration.click();
        return dropDownEverythingInARow.isDisplayed();
    }

    public boolean theBestButtonActive() {
        LOG.info("Поиск кнопки 'лучшее'");
        wait.until(ExpectedConditions.visibilityOfAllElements(dropDownEverythingInARow));
        administration.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(dropDownEverythingInARow));
        dropDownEverythingInARow.click();
        return theBestButton.isDisplayed();

    }

    public AdministrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }


}
