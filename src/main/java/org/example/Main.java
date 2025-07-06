package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class Main {

    protected static WebDriver driver;
    protected static List<String> productNames = Arrays.asList("Brinjal", "Cauliflower", "Beetroot", "Potato");




    public  static void navigate() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

    }


    public static void addMultipleProducts(List<String> productNames) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.product"));
        int count = 0;
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("h4.product-name")).getText();

            for (String targetProduct : productNames) {
                if (productName.contains(targetProduct)) {
                    product.findElement(By.xpath(".//button[text()='ADD TO CART']")).click();
                    count++;
                    break;
                }
            }

            if (count == productNames.size()) {
                break;
            }
        }
    }




    public static void clickOnCartIcon(){
        driver.findElement(By.cssSelector(".cart-icon")).click();
    }

    public static void proceedToCheckoutBtn(){
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item"));
        System.out.println(cartItems.size());

        if (!cartItems.isEmpty()){
            driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
        }
    }



    public static void applyPromoCode(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Apply']")));
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        String ReturnMessageOfPromo = driver.findElement(By.className("promoInfo")).getText();
        System.out.println(ReturnMessageOfPromo);
    }


    public static void placeOrder(){
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }






    public static void main(String[] args) {
        navigate();
        addMultipleProducts(productNames);
        clickOnCartIcon();
        proceedToCheckoutBtn();
        applyPromoCode();
        placeOrder();

    }



    }


