
import com.beust.ah.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmet
 */
public class Test_Add_Product_To_Cart extends BaseTest{
    
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    
    @Test
    @Order(1)
    public void searchProduct() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("kaşık maması");
        Assertions.assertTrue(productsPage.isOnProductPage(),"Not on products page !");
    }
    
     @Test
     @Order(2)
    public void selectProduct() {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct();
        //Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Not on a product detail page !");
    }
    
     @Test
     @Order(3)
    public void addProductToCart() {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),"Product count did not increase !");
        
    }
    
     @Test
     @Order(4)
    public void goToCart() {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product was not added to cart !");
    }
}
