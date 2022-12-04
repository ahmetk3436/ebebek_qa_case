
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmet
 */
public class BasePage {
    
    WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    
    public List<WebElement> findAll(By locator)
    {
        return driver.findElements(locator);
    }
    
    public void click(By locator)
    {
        find(locator).click();
    }
     public void enter(By locator)
    {
        find(locator).click();
    }
    public void type(By locator,String text)
    {
        find(locator).sendKeys(text);
    }
    
    public Boolean isDisplayed(By locator)
    {
        return find(locator).isDisplayed();
    }
}
