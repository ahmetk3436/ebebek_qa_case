
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmet
 */
class ProductsPage extends BasePage {
    
    By kasikMamasiSelection = By.cssSelector("#btnCategoryFilter");
    By productNameLocator = By.cssSelector("eb-product-list-item");
    static String productName = "";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    boolean isOnProductPage() {
        return isDisplayed(kasikMamasiSelection);
    }

    void selectProduct() {
        List<WebElement> newList = getAllProducts();
        List<WebElement> needDelete = findAll(By.className("btn-buttonload"));
        WebElement element = newList.get(newList.size()-(1+needDelete.size()));
    System.out.println(needDelete.size());
        System.out.println(element.getText());
         ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productName = element.getText();
        System.out.println(element.isDisplayed());
        element.click();
    }
    
    private List<WebElement> getAllProducts() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        boolean reachedbottom = false;
        do{js.executeScript("window.scrollBy(0,1000)");
        reachedbottom = Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());
        System.out.println(reachedbottom);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(!reachedbottom);

        return findAll(productNameLocator);
    }
}
