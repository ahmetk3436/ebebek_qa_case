
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
    By productNameLocator = By.id("txtProductTitle");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }
    String getProductName()
    {
        return find(productNameLocator).getText();
    }
    void addToCart() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(addToCartButtonLocator);
    }

    public boolean isSameProduct() {
        if(ProductsPage.productName.contains(getProductName()))
        {
            return true;
        } else {
            return false;
        }
    }
}
