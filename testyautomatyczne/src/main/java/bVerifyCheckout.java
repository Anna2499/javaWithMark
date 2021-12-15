//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class bVerifyCheckout {

    public static WebDriver driver;

    @Test
    public void checkout() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Chrome driver
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://autodemo.testoneo.com");

        WebElement tabClothes = driver.findElement(By.linkText("CLOTHES"));
        tabClothes.click();

        WebElement tabwomen = driver.findElement(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[2]/a"));
        tabwomen.click();

        //Verify that you are on Women page
        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres url: " + adresUrl);
        Assert.assertEquals(adresUrl, "https://autodemo.testoneo.com/pl/5-women");

        //TEST2
        //Select Size M
        WebElement sizeM = driver.findElement(By.xpath("/html/body/main/section/div/div[1]/div[2]/div[2]/section/ul/li[2]/label/a"));
        sizeM.click();

        //Verify active filters


        //Quick view

        //Najechanie mszyka na obraz
        //Actions builder = new Actions(driver);
        //WebElement picture = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article/div/a/img"));
        //builder.moveToElement(picture).perform();
        //WebElement quickView = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article/div/div[2]"));
        //quickView.click();

        Actions builder = new Actions(driver);
        WebElement picture = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article/div/a/img"));
        builder.moveToElement(picture).build().perform();
        WebElement quickView = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article/div/div[2]"));
        quickView.click();
    }


}
