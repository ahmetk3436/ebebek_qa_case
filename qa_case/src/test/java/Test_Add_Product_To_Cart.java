
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

    MemberShipPage memberShipPage;
    
    @Test
    @Order(1)
    public void searchProduct() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("kaşık maması");
        Assertions.assertTrue(productsPage.isOnProductPage(),"Not on products page !");
        log.info("Ürün aratıldı");
    }
    
     @Test
     @Order(2)
    public void selectProduct() {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Not on a product detail page !");
         log.info("Ürün seçildi");
    }
    
    @Test
     @Order(3)
    public void addProductToCart() {
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.isSameProduct(),"Product is not same!");
        log.info("Ürün sepete eklendi");
    }
    
     @Test
     @Order(4)
    public void goToCart() {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product was not added to cart !");
         log.info("Sepet sayfasındayız");
     }

    @Test
    @Order(5)
    public void completeShopping() {
        memberShipPage = new MemberShipPage(driver);
        cartPage.clickCompleteShopping();
        Assertions.assertTrue(memberShipPage.isPageOpened(),"Membership page not opened !");
        log.info("Giriş yapma / üye olma sayfasındayız");
    }
}
