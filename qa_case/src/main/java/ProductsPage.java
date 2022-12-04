
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
class ProductsPage extends BasePage {
    
    By kasikMamasiSelection = By.className("cx-facet-text");
    By productNameLocator = By.cssSelector("eb-product-list-item");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    boolean isOnProductPage() {
        return isDisplayed(kasikMamasiSelection);
    }

    void selectProduct(int i) {
        getAllProducts().get(1).click();
    }
    
    private List<WebElement> getAllProducts()
    {
      return findAll(productNameLocator);
    }
}
