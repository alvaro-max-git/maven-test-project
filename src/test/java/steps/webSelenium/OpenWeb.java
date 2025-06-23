package steps.webSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OpenWeb {

    private WebDriver driver;

    public OpenWeb () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Inicializa el WebDriver de Chrome
        this.driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "menu-item-2008")
    WebElement littleTesterComicLink;

    public void openWebWithURL(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickLittleTesterComicLink () {
        littleTesterComicLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean checkUrl (String url) {
        String actualUrl = driver.getCurrentUrl();
        return url.equals(actualUrl);
    }

}
