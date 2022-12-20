package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ConfirmationPage;
import test.components.BaseTest;


public class addToCartTest extends BaseTest {

    @Test(dataProvider = "testData")
    public void checkOrderAddingInCart(String productName) {
        ConfirmationPage confirmationPage = openHomePage()
                .searchProduct(productName)
                .goToProduct(productName)
                .addToCart()
                .checkConfirmationText();

        CartPage cartPage = confirmationPage.goToCartBtn();
        Assert.assertTrue(cartPage.getActualProductName(productName).contains(productName));
        cartPage.deleteProductByName(productName);
    }
    @DataProvider
    private Object[][] testData(){
        return new Object[][] {
                {"Mug"}, {"Teeburon Eat Sleep Canadian Football Mug"}

        };
    }
}