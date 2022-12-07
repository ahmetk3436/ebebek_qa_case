import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MemberShipPage extends  BasePage{
    By loginButtonLocator = By.id("btnSubmitLogin");
    public MemberShipPage(WebDriver driver) {
        super(driver);
    }
    boolean isPageOpened(){
    return  isDisplayed(loginButtonLocator);
    }
}
