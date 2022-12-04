
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
class SearchBox extends BasePage{
    
    By searchBoxLocator = By.id("txtSearchBox");
    public SearchBox(WebDriver driver) {
        super(driver);
    }
     public void search(String text)
        {
            type(searchBoxLocator,text);
            enter(searchBoxLocator);
        }
}
