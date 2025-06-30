package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    protected static WebDriver driver ;
    protected static WebElement AddToCartForCucumberProduct ;


    public Main() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }
    public void addCucumberToCart(){
        AddToCartForCucumberProduct= driver.findElement(By.xpath("//div/div/div[3]/h4/parent::div/div/button"));driver.findElement(By.xpath("//div/div/div[3]/h4/parent::div/div/button"));
        System.out.println(AddToCartForCucumberProduct.getText());
        AddToCartForCucumberProduct.click();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addCucumberToCart();


    }
    }


