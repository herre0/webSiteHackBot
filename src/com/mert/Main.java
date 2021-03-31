package com.mert;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mert\\Desktop\\chromedriver.exe");

        BruteForce bruteForce = new BruteForce();
        bruteForce.startForcing();

//        SqlInjection sqlInjection = new SqlInjection();
//        sqlInjection.getGoogleBot();



    }
}
