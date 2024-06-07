package com.example.habrtesting.tests;

import com.example.habrtesting.pages.AdministrationPage;
import com.example.habrtesting.pages.MyFeedPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    AdministrationPage administrationPage;
    MyFeedPage myFeedPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        open("https://habr.com/");
        administrationPage = page();
        myFeedPage = page();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Наличие раздела Хабы")
    public void hubsFind() {
        assertTrue(administrationPage.findAdministration(), "Раздел Хабы не найден");
    }


    @Test
    @DisplayName("Проверка наличия раздела 'Вклад компаний'")
    public void becomeCampaignContributionsFind() {
        assertTrue(administrationPage.campaignContributionsFind(),
                "Раздел вклад компаний не найден");
    }

    @Test
    @DisplayName("Проверка, что кнопка 'как стать автором' активна")
    public void becomeAnAuthorCheckButton() {
        assertTrue(myFeedPage.becomeAnAuthorFind(), "Кнопка 'как стать автором' не активна");
    }

    @Test
    @DisplayName("Проверка открытие страницы 'Как стать автором' после нажатия кнопки ")
    public void openBecomeAnAuthor() {
        Assertions.assertEquals(myFeedPage.checkBecomeAnAuthorClickable(),
                "https://habr.com/ru/sandbox/start/",
                "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка, что кнопка написать публикацию активна")
    public void buttonCheckWriteAnArticle() {
        assertTrue(administrationPage.checkWriteAnArticleClickable(),
                "Кнопка написать публикацию не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка войти активна")
    public void becomeEnterCheckButton() {
        assertTrue(administrationPage.becomeEnterFind(), "Кнопка войти не найдена");
    }

    @Test
    @DisplayName("Проверка открытия страницы 'Хабр Аккаунт'")
    public void openHabrAccount() {
        assertTrue(administrationPage.checkEnterClickable().contains("https://account.habr.com/login/?consumer=habrahabr&ostate=")
                , "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка наличия кнопки 'Войти'")
    public void becomeRemindPasswordCheckButton() {
        assertTrue(administrationPage.becomeRemindPasswordFind(), "Кнопка войти не найдена");
    }

    @Test
    @DisplayName("Проверка открытие страницы Восстановление пароля после нажатия кнопки")
    public void openingAccountHabr() {
        assertTrue(administrationPage.checkAccounHabrClickable().contains("https://account.habr.com/login/reminder/?consumer=default&ostate="),
                "Не верная ссылка");
    }

    @Test
    @DisplayName("Проверка наличия кнопки зарегистрироваться")
    public void becomeRegistrCheckButton() {
        assertTrue(administrationPage.becomeRegistrFind(), "Кнопка зарегистрироваться не найдена");
    }

    @Test
    @DisplayName("Проверка,что кнопка настройки активна")
    public void becomeSetteningsCheckButton() {
        assertTrue(administrationPage.becomeSettingsFind(), "Кнопка настройки не активна");
    }

    @Test
    @DisplayName("Проверка,что Drop downs активна")
    public void becomedropDownEverythingInARowActiveCheck() {
        assertTrue(administrationPage.dropDownEverythingInARowActive(), "Drop downs не активен");
    }

    @Test
    @DisplayName("Проверка,что есть кнопка 'Лучшее'")
    public void becomeTheBestCheck() {
        assertTrue(administrationPage.theBestButtonActive(), "Нет кнопки лучшее");
    }

    @Test
    @DisplayName("Проврека активности drop down 'настройка ленты'")
    public void becomeDropDownSettingUpTheFeedCheck() {
        assertTrue(myFeedPage.becomeDropDownSettingUpTheFeed(), "drop down 'настройка ленты' не активен");
    }

    @Test
    @DisplayName("Проверка есть запись уровень сложности ")
    public void becomeDifficultyLevelFind() {
        assertTrue(myFeedPage.becomeDifficultyLevel(), "нет записи уровень сложности");
    }

    @Test
    @DisplayName("Проверка Кнопка выбора сложности 'Простой' активна ")
    public void becomeSimpleLevelFind() {
        assertTrue(myFeedPage.becomeSimpleLevel(), "Кнопка выбора сложности 'Простой' не активна");
    }

    @Test
    @DisplayName("Проверка Кнопка выбора сложности 'Средний' активна ")
    public void becomeAverageLevelFind() {
        assertTrue(myFeedPage.becomeAverageLevel(), "Кнопка выбора сложности 'Средний' не активна");
    }

    @Test
    @DisplayName("Проверка Кнопка выбора сложности 'Сложный' активна ")
    public void becomeDifficultLevelFind() {
        assertTrue(myFeedPage.becomeDifficultyLevel(), "Кнопка выбора сложности 'Сложный' не активна");
    }

    @Test
    @DisplayName("Проверка 'Checkbox статьи' активна ")
    public void becomeCheckboxArticlesFind() {
        assertTrue(myFeedPage.becomeCheckboxArticles(), "Checkbox статьи  не активен");
    }

    @Test
    @DisplayName("Проверка открытие страницы 'Регистрация' после нажатия кнопки-ссылки")
    public void openBecomeRegister() {
        assertTrue(myFeedPage.checkRegisterClickable().contains("https://account.habr.com/register/?state="),
                "Не верная ссылка");
    }
}



