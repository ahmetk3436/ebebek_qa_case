
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
    
    By cartCount = By.xpath("span[class='mobile-shopping']span[class='number']");
    By cartContainerLocator = By.cssSelector("#btnShowCart");
    
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    
    public SearchBox searchBox()
    {
       return this.searchBox;
    }

    boolean isProductCountUp() {
        return getCartCount();
    }

    void goToCart() {
        click(cartContainerLocator);
    }
    
    private boolean getCartCount()
    {
      if(driver.findElement(cartCount) != null)
      {
          return true;
      } else {
          return false;
      }

    }
}
