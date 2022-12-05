
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
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    boolean isOnProductPage() {
        return isDisplayed(kasikMamasiSelection);
    }

    void selectProduct() {
        List<WebElement> newList = getAllProducts();
        List<WebElement> needDelete = findAll(By.className("btn-buttonload"));
      //  System.out.println(newList.size());
       /* for (int i = 0; i < newList.size()-1; i++) {
            for (int j = 0; j < needDelete.size()-1; j++) {
                if(newList.get(i) == needDelete.get(j))
                {
                    newList.remove(newList.get(i));
                }
            }

        }*/
       // System.out.println(newList.size());
        WebElement element = newList.get(newList.size()-(1+needDelete.size()));
    System.out.println(needDelete.size());
        System.out.println(element.getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
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
