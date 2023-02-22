import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddDressesInCart {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://myolivia.shop/collections/dresses");
        driver.manage().window().maximize();
        List<WebElement> allDresses = driver.findElements(By.cssSelector("span[class='product-item__price']"));
        for (int i =  0; i < allDresses.size(); i++) {
            allDresses.get(i).click();
            List<WebElement> sizesOfDresses = driver.findElements(By.cssSelector("label[class='product-variant__label']"));
            for (int p = 0; p < sizesOfDresses.size(); p++) {
                sizesOfDresses.get(p).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='add-to-cart__text']")));
                var addToCart = driver.findElement(By.cssSelector("span[class='add-to-cart__text']"));
                addToCart.click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='page-overlay']")));
                var closeCart = driver.findElement(By.cssSelector("div[class='page-overlay']"));
                closeCart.click();
            }
            driver.navigate().to("https://myolivia.shop/collections/dresses");
            allDresses = driver.findElements(By.cssSelector("span[class='product-item__price']"));
        }

    }

}
