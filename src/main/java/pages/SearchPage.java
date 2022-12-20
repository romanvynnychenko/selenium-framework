package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".s-asin")
    List<WebElement> srcAllProducts;
    @FindBy(xpath = "//div[@class='s-no-outline']")
    WebElement noResultsFoundErrorTxt;

    private final By productNameBy = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");

    public WebElement getProductByName(String productName) {
        WebElement product = srcAllProducts.stream().filter(prod ->
                prod.findElement(productNameBy).getText().contains(productName)).findFirst().orElse(null);
        return product;
    }
    public ProductPage goToProduct(String productName){
        getProductByName(productName).click();
        return new ProductPage(driver);
    }
    public Boolean noResultsFoundVerification(){
        Boolean verificationResult = noResultsFoundErrorTxt.getText().contains("No results for");
        return verificationResult;
    }
}
