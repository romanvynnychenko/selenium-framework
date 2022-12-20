package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sc-list-item-content")
    List<WebElement> cartAllProducts;
    private final By productNameBy = By.xpath("//span[@class='a-truncate-cut']");
    private final By deleteProductFromCart = By.xpath("//input[@value='Delete']");

    public WebElement getProductByName(String productName) {
        WebElement product = cartAllProducts.stream().filter(prod ->
                prod.findElement(productNameBy).getText().contains(productName)).findFirst().orElse(null);
        return product;
    }

    public CartPage deleteProductByName(String productName) {
        getProductByName(productName).findElement(deleteProductFromCart).click();
        return this;
    }
    public String getActualProductName(String productName){
        return getProductByName(productName).findElement(productNameBy).getText();
    }

}
