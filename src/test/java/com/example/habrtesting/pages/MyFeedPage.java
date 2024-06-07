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

public class MyFeedPage {
    private final Logger LOG = LoggerFactory.getLogger(MyFeedPage.class);
    WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "svg.tm-svg-img.icon_dropdown-arrow")
    private WebElement dropDownSettingUpTheFeed;
    @FindBy(css = "legend.my-feed-filter__section-legend")
    private WebElement difficultyLevel;
    @FindBy(css = "span.radio-like-button__button")
    private WebElement simpleLevel;
    @FindBy(css = "span.radio-like-button__button")
    private WebElement averageLevel;
    @FindBy(css = "span.radio-like-button__button")
    private WebElement difficultLevel;
    @FindBy(css = "span.tm-base-checkbox__figure")
    private WebElement checkboxArticles;
    @FindBy(xpath = "//*[contains(text(),'зарегистрируйтесь')]")
    private WebElement dropDownRegister;
    @FindBy(css = "a.tm-header__become-author-btn")
    private WebElement becomeAnAuthor;

    public boolean becomeSimpleLevel() {
        LOG.info("Проврека активности в drop down кнопки простой уровень");
        dropDownSettingUpTheFeed.click();
        return simpleLevel.isEnabled();
    }
    public String checkBecomeAnAuthorClickable() {
        wait.until(ExpectedConditions.visibilityOfAllElements(becomeAnAuthor));
        becomeAnAuthor.click();
        return driver.getCurrentUrl();
    }

    public boolean becomeDifficultyLevel() {
        LOG.info("Проврека активности в drop down кнопки средний уровень");
        dropDownSettingUpTheFeed.click();
        return difficultyLevel.isEnabled();
    }
    public boolean becomeAverageLevel() {
        LOG.info("Проврека активности в drop down кнопки сложный уровень");
        dropDownSettingUpTheFeed.click();
        return averageLevel.isEnabled();
    }

    public boolean becomeDropDownSettingUpTheFeed() {
        LOG.info("Проврека активности drop down настройка ленты");
        return dropDownSettingUpTheFeed.isEnabled();
    }

    public boolean becomeCheckboxArticles() {
        LOG.info("Проврека активности checkbox статьи");
        dropDownSettingUpTheFeed.click();
        return checkboxArticles.isEnabled();
    }

    public String checkRegisterClickable() {
        LOG.info("Проврека открытия регистрации");
        dropDownSettingUpTheFeed.click();
        dropDownRegister.click();
        return driver.getCurrentUrl();
    }
    public boolean becomeAnAuthorFind() {
        LOG.info("Проврека активности");
        return becomeAnAuthor.isEnabled();
    }

    public MyFeedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

}
