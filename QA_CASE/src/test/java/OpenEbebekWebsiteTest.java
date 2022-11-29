import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import pages.OpenEbebekWebsite;

 class OpenEbebekWebsiteTest extends BaseTest {

	OpenEbebekWebsite openEbebekWebsite;

	@Test
	void testHomePageCopyRight() {
		openEbebekWebsite = goToUrl(new OpenEbebekWebsite(driver, wait), "https://www.ebebek.com.tr/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        String lastName = driver.findElement( By.cssSelector("class row product-list:last-child eb-product-list-item")).getText();

		assertEquals(lastName, openEbebekWebsite.getSearchValue());
		driver.quit();
	}
}
