
import java.util.List;
import java.util.function.BooleanSupplier;
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
class CartPage extends BasePage{
    By productNameLocator = By.cssSelector("eb-cart-item-list");
    By completeShoppingLocator = By.id("btnGoToShippingAddress");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    boolean checkIfProductAdded() {
        return !getProducts().isEmpty();
    }

    void clickCompleteShopping(){
        click(completeShoppingLocator);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private List<WebElement> getProducts()
    {
        return findAll(productNameLocator);
    }
}
