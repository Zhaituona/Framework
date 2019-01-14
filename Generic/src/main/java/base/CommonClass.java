package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonClass  {

    public static WebDriver driver;
    public static Properties prop;

    public CommonClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Elzat\\IdeaProjects\\Auto3\\Cars\\confing.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elzat\\IdeaProjects\\Auto3\\Generic\\browser-driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Elzat\\IdeaProjects\\Auto3\\Generic\\browser-driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLiCIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}