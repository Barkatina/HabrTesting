package com.example.habrtesting.tests;

import com.example.habrtesting.pages.AdministrationPage;
import org.junit.jupiter.api.*;

import static java.sql.DriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private AdministrationPage administrationPage;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://habr.com/");
        administrationPage = new AdministrationPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Наличие раздела Хабы")
    public void hubTest() {
        assertTrue(administrationPage.findAdministration(), "Раздел Хабы не найден");
    }

    @Test
    public void searchFiledText() {
        administrationPage.clickHubs();
        String input = "Linux";
        administrationPage.setText(input);
        assertEquals(input, administrationPage.getTextFromSearchField(), "Текст не совпал");
    }

    @Test
    public void compTest() {
        driver.findElement(By.xpath("//*[contains(text(),'Администрирование')]")).click();
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Вклад компаний')]")).isDisplayed(), "Раздел вклад компаний не найден");
    }
    @Test
    public void becomeAnAuthorCheckButton() {
        assertTrue(administrationPage.becomeAnAuthorFind(), "Кнопка Scala bundle не найдена");
    }
    @Test
    @DisplayName("Проверка открытие страницы Scala bundle после нажатия кнопки ")
    public void openBecomeAnAuthor() {
        Assertions.assertEquals(administrationPage.checkBecomeAnAuthorClickable(),
                "https://habr.com/ru/sandbox/start/",
                "Не верная ссылка");
    }
    @Test
    @DisplayName("Проверка, что кнопка написать публикацию активна")
    public void buttonCheckWriteAnArticle() {
        assertTrue(administrationPage.checkWriteAnArticleClickable(), "Кнопка написать публикацию не активна");
    }
    @Test
    public void becomeEnterCheckButton() {
        assertTrue(administrationPage.becomeEnterFind(), "Кнопка Scala bundle не найдена");
    }
    @Test
    @DisplayName("Проверка открытие страницы Scala bundle после нажатия кнопки ")
    public void openingJetBrainsMarketplace() {
        assertTrue(administrationPage.checkEnterClickable().contains("https://account.habr.com/login/?consumer=habrahabr&ostate="), "Не верная ссылка");
    }
    @Test
    @DisplayName("Негативный тест: ввод незарегистрированого пользователя и неверный пароль ")
    public void unregisteredUserpasswordEnter() {
        administrationPage.unregisteredUserEnter();

       // assertEquals(administrationPage.);
    }//Введите корректный e-mail

}



