
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
    
    By cartCount = By.cssSelector("number ng-star-inserted");
    By cartContainerLocator = By.className("icon-shopping-cart");
    
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    
    public SearchBox searchBox()
    {
       return this.searchBox;
    }

    boolean isProductCountUp() {
        return getCartCount() > 0;
    }

    void goToCart() {
        click(cartContainerLocator);
    }
    
    private int getCartCount()
    {
       String count = find(cartCount).getText();
       return Integer.parseInt(count);
    }
}
