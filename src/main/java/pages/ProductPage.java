package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    public ConfirmationPage addToCart(){
        addToCartBtn.click();
        return new ConfirmationPage(driver);
    }
}
