package com.pawpasta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        User ID :	mngr620495
//        Password :	Arymuge
        String geckodriver = "geckodriver.exe";
        String webgeckodriver = "webdriver.gecko.driver";

//        String edgedriver = "msedgedriver.exe";
//        String webedgedriver = "webdriver.msedge.driver";

//        String chromedriver = "chromedriver.exe";
//        String webchromedriver = "webdriver.chrome.driver";

        System.setProperty(webgeckodriver,geckodriver);

//        WebDriver myBrowser = new ChromeDriver();
        WebDriver myBrowser = new FirefoxDriver();
//        WebDriver myBrowser = new EdgeDriver();

        myBrowser.manage().window().maximize();
        myBrowser.get("https://google.com");

        WebElement searchBox = myBrowser.findElement(By.name("q"));
        searchBox.sendKeys("Hàn Quoc va Trieu Tien");
        searchBox.submit();
    }
}