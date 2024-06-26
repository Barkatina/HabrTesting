package com.example.habrtesting.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class AdministrationPage {
    private final Logger LOG = LoggerFactory.getLogger(AdministrationPage.class);

    private static final By ADMINISTRATION_XPATH = By.xpath("//*[contains(text(),'Администрирование')]");
    private static final By HUBS_XPATH = By.xpath("//*[contains(text(),'Хабы')]");
    private static final By CONTRIBUTION_TO_THE_COMPANY_CSS = By.cssSelector("h2.tm-block__title.tm-block__title");
    private static final By WRITE_AN_ARTICLE_CSS = By.cssSelector("svg.tm-svg-img.tm-header-user-menu__icon.tm-header-user-menu__icon_write");
    private static final By ENTER_CSS = By.cssSelector("button.btn.btn_solid.btn_small.tm-header-user-menu__login");
    private static final By REMIND_PASSWORD_CSS = By.cssSelector("a.form__remind-password-link ");
    private static final By REGISTER_CSS = By.cssSelector("a.form-additional-message__link");
    private static final By SETTINGS_CSS = By.cssSelector("button.tm-header-user-menu__toggle");
    private static final By DROP_DOWN_EVERYTHING_IN_A_ROW_CSS = By.cssSelector("svg.tm-svg-img.icon_dropdown-arrow");
    private static final By THE_BEST_BUTTON_CSS = By.xpath("//button[contains(@class, 'tm-navigation-filters-tabs__option-button') and contains(text(), 'Лучшие')]");

    public boolean becomeEnterFind() {
        LOG.info("Проврека активности кнопки войти");
        return $(ENTER_CSS).isEnabled();
    }

    public String checkEnterClickable() {
        LOG.info("Переход на страницу 'Хабр Аккаунт'");
        $(ENTER_CSS).shouldBe(Condition.visible, Duration.ofSeconds(8))
                .click();
        return webdriver().driver().getCurrentFrameUrl();
    }

    public boolean campaignContributionsFind() {
        LOG.info("Проврека наличия раздела 'Вклад компаний'");
        $(ADMINISTRATION_XPATH).click();
        $(HUBS_XPATH).click();
        return $(CONTRIBUTION_TO_THE_COMPANY_CSS).isDisplayed();
    }

    public boolean findAdministration() {
        LOG.info("Проврека наличия раздела Хабы");
        $(ADMINISTRATION_XPATH).click();
        return $(HUBS_XPATH).isDisplayed();
    }

    public boolean checkWriteAnArticleClickable() {
        LOG.info("Проверка активности кнопки написать публикацию");
        $(WRITE_AN_ARTICLE_CSS).shouldBe(Condition.visible, Duration.ofSeconds(8));
        return $(WRITE_AN_ARTICLE_CSS).isEnabled();
    }

    public boolean becomeRemindPasswordFind() {
        LOG.info("Наличие кнопки Войти");
        $(ENTER_CSS).click();
        return $(REMIND_PASSWORD_CSS).isDisplayed();
    }

    public String checkAccounHabrClickable() {
        LOG.info("Переход на страницу 'Восстановление пароля'");
        $(ENTER_CSS).shouldBe(Condition.visible, Duration.ofSeconds(8))
                .click();
        $(REMIND_PASSWORD_CSS).click();
        return webdriver().driver().getCurrentFrameUrl();
    }

    public boolean becomeRegistrFind() {
        LOG.info("Поиск кнопки регистрация");
        $(ENTER_CSS).click();
        $(REMIND_PASSWORD_CSS).click();
        return $(REGISTER_CSS).isDisplayed();
    }

    public boolean becomeSettingsFind() {
        LOG.info("Поиск кнопки настройки");
        return $(SETTINGS_CSS).isDisplayed();
    }

    public boolean dropDownEverythingInARowActive() {
        LOG.info("Поиск drop down 'все подряд'");
        $(ADMINISTRATION_XPATH).click();
        return $(DROP_DOWN_EVERYTHING_IN_A_ROW_CSS).isDisplayed();
    }

    public boolean theBestButtonActive() {
        LOG.info("Поиск кнопки 'лучшие'");
        $(ADMINISTRATION_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(15))
                .click();
        $(DROP_DOWN_EVERYTHING_IN_A_ROW_CSS).shouldBe(Condition.visible, Duration.ofSeconds(20))
                .click();
        $(THE_BEST_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(15));
        return $(THE_BEST_BUTTON_CSS).isDisplayed();
    }


}
