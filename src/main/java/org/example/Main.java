package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;


public class Main {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String [] NeededProducts = {"Bro","Tomato","Mus","mango","rice","1/4 Kg",};




    public  static void navigate() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
         wait = new WebDriverWait(driver,Duration.ofSeconds(60));

    }

    public static void addMultipleProducts(String[] Products) {
        List<WebElement> productsList = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        List<String> notFoundItems = new ArrayList<>();

        for (String Product : Products) {
            String neededLower = Product .toLowerCase();
            boolean found = false;

            for (int i = 0; i < productsList.size(); i++) {
                String productName = productsList.get(i).getText().toLowerCase();

                if (productName.contains(neededLower)) {
                    addToCartButtons.get(i).click();
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Product added to cart: " + Product);
            } else {
                System.out.println("Product not found: " + Product);
                notFoundItems.add(Product);
            }
        }
    }





        public static void clickOnCartIcon(){
        driver.findElement(By.cssSelector(".cart-icon")).click();
    }

    public static void proceedToCheckoutBtn(){
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item"));

        if (!cartItems.isEmpty()){
            driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
        }
    }



    public static void applyPromoCode(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Apply']")));
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        String ReturnMessageOfPromo = driver.findElement(By.className("promoInfo")).getText();
        System.out.println(ReturnMessageOfPromo);
    }


    public static void placeOrder(){
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }


    public static void selectCountry(){
        WebElement Dropdown = driver.findElement(By.xpath("//select"));
        Dropdown.click();
        Select select = new Select(Dropdown);
        List<WebElement> Options = select.getOptions();
        int randomCountry = new Random().nextInt(Options.size());
        select.selectByIndex(randomCountry);
    }

    public static void agreeToTermsConditions(){
        driver.findElement(By.cssSelector(".chkAgree")).click();
    }

    public static void completeOrder(){
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();

    }






    public static void main(String[] args)  {
        navigate();
        addMultipleProducts(NeededProducts);
        clickOnCartIcon();
        proceedToCheckoutBtn();
        applyPromoCode();
        placeOrder();
        selectCountry();
        agreeToTermsConditions();
        completeOrder();



    }



    }


