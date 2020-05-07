// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class NuevoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty( "webdriver.chrome.driver", "C:\\Users\\David\\eclipse-workspace\\iNspector\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void nuevo() {
    driver.get("http://localhost:8080/iNspector/Principal.jsp");
    driver.manage().window().setSize(new Dimension(974, 1040));
    driver.findElement(By.id("rotulo")).click();
    driver.findElement(By.id("rotulo")).sendKeys("market");
    driver.findElement(By.cssSelector(".u-border-radius-10")).click();
    driver.findElement(By.cssSelector("select")).click();
    {
      WebElement dropdown = driver.findElement(By.cssSelector("select"));
      dropdown.findElement(By.xpath("//option[. = 'DIA MARKET MINERVA']")).click();
    }
    driver.findElement(By.cssSelector("select")).click();
    driver.findElement(By.cssSelector(".u-align-center > .u-border-radius-10:nth-child(1)")).click();
  }
}
