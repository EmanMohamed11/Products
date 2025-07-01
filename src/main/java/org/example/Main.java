package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Main {

    protected static WebDriver driver;
    //protected static WebElement AddToCartForCucumberProduct;


    public Main() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

    }

    public void addCucumberToCart() {
        /*  AddToCartForCucumberProduct = driver.findElement(By.xpath("//div/div/div[3]/h4/parent::div/div/button"));
          driver.findElement(By.xpath("//div/div/div[3]/h4/parent::div/div/button"));
          System.out.println(AddToCartForCucumberProduct.getText());
          AddToCartForCucumberProduct.click();

         */

        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
        System.out.println(products.size());

        for (WebElement product : products) {
            String ProductName = product.findElement(By.cssSelector(".product-name")).getText().trim();
            System.out.println(ProductName);
            if (ProductName.equalsIgnoreCase("Cucumber - 1 Kg")) {

                WebElement AddToCartButton = product.findElement(By.cssSelector(".product-action> button"));
                AddToCartButton.click();
                break;
            }
        }
    }




    public static void main(String[] args) {
        Main main = new Main();
        main.addCucumberToCart();


    }
    }


