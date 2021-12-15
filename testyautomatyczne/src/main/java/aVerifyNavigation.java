import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class aVerifyNavigation {

    public static WebDriver driver;

    @Test
    public void WomenPage() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Chrome driver
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://autodemo.testoneo.com");

        WebElement tabClothes = driver.findElement(By.linkText("CLOTHES"));
        tabClothes.click();

        WebElement tabwomen = driver.findElement(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[2]/a"));
        //WebElement tabwomen = driver.findElement(By.className("facet clearfix"));
        //tabwomen.findElement(By.id("facet_input_64329_1")).click();
        tabwomen.click();

        WebElement sizeM = driver.findElement(By.className("facet clearfix"));
        sizeM.findElement(By.id("facet_input_64329_1")).click();

        //Verify that you are on Women page
        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres url: " + adresUrl);
        Assert.assertEquals(adresUrl, "https://autodemo.testoneo.com/pl/5-women");

        //driver.close();
        //driver.quit();

    }


}
