
import java.util.function.BooleanSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmet
 */
class HomePage  extends BasePage{
    
    SearchBox searchBox;
    
    By cartCount = By.cssSelector("span[class='mobile-shopping'] span[class='number ng-star-inserted']");
    By cartContainerLocator = By.cssSelector("#btnShowCart");
    
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    
    public SearchBox searchBox()
    {
       return this.searchBox;
    }



    void goToCart() {
        click(cartContainerLocator);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    

}
