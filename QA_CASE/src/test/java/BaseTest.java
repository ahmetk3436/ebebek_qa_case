
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmet
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver driver;
    
    @BeforeAll
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmet\\Documents\\NetBeansProjects\\qa_case\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("www.ebebek.com.tr");
        driver.manage().window().maximize();
    }
    
    @AfterAll
    public void tearDown()
    {
        driver.quit();
    }
}
