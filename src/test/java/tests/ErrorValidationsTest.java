package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.components.BaseTest;

public class ErrorValidationsTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void productNotFoundValidation(String productName, String expectedResult) {
        String actualResult = openHomePage()
                .searchProduct(productName)
                .noResultsFoundVerification()
                .toString();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"errortest", "false"},
                {"mug", "true"},
                {"wrongtext", "true"}

        };
    }
}
