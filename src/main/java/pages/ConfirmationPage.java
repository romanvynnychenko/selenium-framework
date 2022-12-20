package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmationPage extends BasePage{
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".sw-atc-text")
    WebElement ConfirmationTextElement;
    @FindBy(id ="sw-gtc")
    WebElement goToCartBtn;

    public String getConfirmationText(){
        return ConfirmationTextElement.getText();
    }
    public CartPage goToCartBtn(){
        goToCartBtn.click();
        return new CartPage(driver);
    }
    public ConfirmationPage checkConfirmationText(){
        Assert.assertEquals(getConfirmationText(), "Added to Cart");
        return this;
    }
}
