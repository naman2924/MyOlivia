import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://myolivia.shop/products/claire-dress");
        //driver.findElement(By.cssSelector("input[value='M']")).click();
        driver.findElement(By.xpath("//button[text()='Buy it now']")).click();
        driver.findElement(By.name("email")).sendKeys("testcodeword@gmail.com");
        driver.findElement(By.name("firstName")).sendKeys("test");
        driver.findElement(By.name("lastName")).sendKeys("test");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("address1")));
        driver.findElement(By.name("address1")).sendKeys("fortest");
        driver.findElement(By.name("city")).sendKeys("testing");
        driver.findElement(By.name("postalCode")).sendKeys("249404");
        WebElement state = driver.findElement(By.name("zone"));
        Select drop = new Select(state);
        drop.selectByValue("UK");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        //driver.switchTo().alert().dismiss();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Continue to payment']")));
//        driver.findElement(By.xpath("//span[text()='Continue to payment']")).click();
//        driver.findElement(By.xpath("//span[text()='Razorpay Secure (UPI, Cards, Wallets, NetBanking)']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//main/form/div/div/div/div/div/button")));
        driver.findElement(By.xpath("//main/form/div/div/div/div/div/button")).click();
        driver.findElement(By.xpath("//span[text()='Razorpay Secure (UPI, Cards, Wallets, NetBanking)']")).click();
        System.out.println(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div/div/div/button/span"))));
        driver.findElement(By.xpath("//form/div/div/div/div/button/span")).click();
    }
}
////span[text()='Continue to payment']