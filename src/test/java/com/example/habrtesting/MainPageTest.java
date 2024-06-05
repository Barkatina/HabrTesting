package com.example.habrtesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void HubTest() {
        driver.findElement(By.xpath("//*[contains(text(),'Администрирование')]")).click();
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Хабы')]")).isDisplayed(), "Раздел Хабы не найден");
    }
    @Test
    public void CompTest() {
        driver.findElement(By.xpath("//*[contains(text(),'Администрирование')]")).click();
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Вклад компаний')]")).isDisplayed(), "Раздел вклад компаний не найден");
    }
}

