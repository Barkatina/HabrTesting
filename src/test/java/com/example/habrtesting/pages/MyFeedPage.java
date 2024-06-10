package com.example.habrtesting.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MyFeedPage {
    private final Logger LOG = LoggerFactory.getLogger(MyFeedPage.class);
    WebDriver driver;
    private static final By DROP_DOWN_SETTING_UP_THE_FEED_CSS= By.cssSelector( "svg.tm-svg-img.icon_dropdown-arrow");
    private static final By DIFFICULTY_LEVEL_CSS= By.xpath( "//*[contains(text(),'Сложный')]");
    private static final By SIMPLE_LEVEL_CSS= By.xpath( "//*[contains(text(),'Простой')]");
    private static final By AVERAGE_LEVEL_CSS= By.xpath( "//*[contains(text(),'Средний')]");
    private static final By CHECKBOX_ARTICLES_CSS= By.xpath( "//*[contains(text(),'зарегистрируйтесь')]");
    private static final By DROP_DOWN_REGISTER_CSS= By.cssSelector( "span.tm-base-checkbox__figure");
    private static final By BECOME_AN_AUTHOR_CSS= By.cssSelector( "a.tm-header__become-author-btn");



    public boolean becomeSimpleLevel() {
        LOG.info("Проврека активности в drop down кнопки простой уровень");
        $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).click();
        return $(SIMPLE_LEVEL_CSS).isEnabled();
    }
    public String checkBecomeAnAuthorClickable() {
        LOG.info("Переход на страницу 'Как стать автором'");
        $(BECOME_AN_AUTHOR_CSS).shouldBe(Condition.visible,Duration.ofSeconds(10))
                .click();
        return driver.getCurrentUrl();
    }

    public boolean becomeDifficultyLevel() {
        LOG.info("Проврека активности в drop down кнопки средний уровень");
        $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).click();
        return $(DIFFICULTY_LEVEL_CSS).isEnabled();
    }
    public boolean becomeAverageLevel() {
        LOG.info("Проврека активности в drop down кнопки сложный уровень");
        $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).click();
        return $(AVERAGE_LEVEL_CSS).isEnabled();
    }

    public boolean becomeDropDownSettingUpTheFeed() {
        LOG.info("Проврека активности drop down настройка ленты");
        return $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).isEnabled();
    }

    public boolean becomeCheckboxArticles() {
        LOG.info("Проврека активности checkbox статьи");
        $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).click();
        return $(CHECKBOX_ARTICLES_CSS).isEnabled();
    }

    public String checkRegisterClickable() {
        LOG.info("Проврека открытия регистрации");
        $(DROP_DOWN_SETTING_UP_THE_FEED_CSS).click();
        $(DROP_DOWN_REGISTER_CSS).click();
        return driver.getCurrentUrl();
    }
    public boolean becomeAnAuthorFind() {
        LOG.info("Проврека активности");
        return $(BECOME_AN_AUTHOR_CSS).isEnabled();
    }

    public MyFeedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
