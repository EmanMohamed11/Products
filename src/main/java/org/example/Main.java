package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.id("FirstName")).sendKeys("Eman");
        driver.findElement(By.name("LastName")).sendKeys("Mohamed");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("EmanAliTest@test.com");
        driver.findElement(By.id("Password")).sendKeys("Emtest123#");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Emtest123#");
        driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
        String RegisterSuccess = driver.findElement(By.cssSelector(".result")).getText();
        System.out.println(RegisterSuccess);
        System.out.println(RegisterSuccess);
       // driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("EmanAliTest@test.com");
        driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("Emtest123#");
    }
}