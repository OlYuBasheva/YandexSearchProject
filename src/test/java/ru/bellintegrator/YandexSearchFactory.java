package ru.bellintegrator;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YandexSearchFactory {
    private WebDriver chromeDriver;
    private String url = "https://yandex.ru/";

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'input__control')]")
    WebElement searchField;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'search')]/button[@type='submit']")
    WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//li[@class='serp-item']//a[contains(@href, 'wikipedia.org')]")
    WebElement searchLink;

    public YandexSearchFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.chromeDriver.get(url);
    }

    public boolean checkWiki(String stringFind){
        searchField.click();
        searchField.sendKeys(stringFind);
        searchButton.click();
        String url;
        try {
            url = searchLink.getAttribute("href");
        } catch (NotFoundException exc) {
            System.out.println("Ссылка не найдена");
            System.out.println(exc.getMessage());
            return false;
        }
        System.out.println(url);
        return true;
    }
}
