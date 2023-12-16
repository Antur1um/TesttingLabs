package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MailTest {
    @Test
    public void test() {
        String chromeDriverPath = "C:\\Users\\artem\\IdeaProjects\\TestProject\\drivers\\chromedriver.exe";
        String chromeBinaryPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromeBinaryPath);
        chromeOptions.addArguments("--start-maximized");

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);



        driver.get("https://account.mail.ru/login"); // Переход на страницу входа mail.ru
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@name='username']")), driver.switchTo().activeElement());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testovyy.testich"); // Ввод почты

        driver.findElement(By.xpath("//*[@class='inner-0-2-89 innerTextWrapper-0-2-90']")).click(); // Клик на кнопку "Ввести пароль"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Задержка
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("T@ptes13r"); // Ввод пароля
        driver.findElement(By.xpath("//*[@class='inner-0-2-89 innerTextWrapper-0-2-90']")).click(); // Клик на кнопку "Войти"


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("//*[@class='ph-project ph-project__account svelte-1osmzf1']")).click(); // Клик на профиль

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assertions.assertEquals("Тестовый Тестич", driver.findElement(By.xpath("//*[@aria-label='Тестовый Тестич']")).getText());// Сверка имени
        driver.findElement(By.xpath("//*[@data-click-counter='75068944']")).click(); // Клик на кнопку "Выйти"

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div[2]/a")).isDisplayed(); // Проверка наличия кнопки "Создать почту"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.quit();
    }
}