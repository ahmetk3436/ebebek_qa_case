
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
class ProductDetailPage extends BasePage {
    
    By addToCartButtonLocator = By.id("addToCartBtn");
    
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    void addToCart() {
        click(addToCartButtonLocator);
    }
    
}
