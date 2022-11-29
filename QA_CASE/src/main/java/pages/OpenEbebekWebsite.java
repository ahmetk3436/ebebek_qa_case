package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenEbebekWebsite  extends BasePage{

	public OpenEbebekWebsite(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	 private List<WebElement> items;
	 private List<WebElement> newItems;

	public String getSearchValue() {
	items =	driver.findElements(By.className("col-6 col-lg-4 col-md-4 col-xl-3 prod-item-col ng-star-inserted"));
	java.util.Iterator<WebElement> itr = items.iterator();
	while(itr.hasNext())
	{
		WebElement element = itr.next();
		if(element.findElement(By.className("btn-buttonload ng-star-inserted")).getText() != "Tükendi")
		{
			newItems.add(element);
		} else {
			System.out.println("Ürün tükenmiş");
		}
	}
	String elementName = newItems.get(newItems.size()-1).findElement(By.className("description plist-desc")).getText();
	return elementName;
	}
}
