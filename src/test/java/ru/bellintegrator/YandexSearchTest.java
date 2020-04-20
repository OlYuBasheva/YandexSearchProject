package ru.bellintegrator;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class YandexSearchTest extends WebDriverSettings {

    private void son(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException exc) {
            System.out.println(exc.toString());
        }
    }

    @Test
    public void findInYandex() {
        YandexSearchFactory yandexSearch = PageFactory.initElements(chromeDriver, YandexSearchFactory.class);
        //son(5000);
        Assertions.assertTrue(yandexSearch.checkWiki("Гладиолус"));
    }
}
