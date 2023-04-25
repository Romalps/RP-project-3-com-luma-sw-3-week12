package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        // * Mouse Hover on Women Menu
        //* Mouse Hover on Tops
        //* Click on Jackets
        actionsMethodForMouseHover(By.xpath("//span[normalize-space()='Women']"), By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"), By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //* Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"), "\n" +
                "Product Name ");
        //* Verify the products name display in alphabetical order
        List<WebElement> productsName = driver.findElements(By.xpath("//div[@class='product-item-info']"));
        for (int i = 0; i < productsName.size() - 1; i++) {
            String productName1 = productsName.get(i).getText().toLowerCase();
            String productName2 = productsName.get(i+1).getText().toLowerCase();

            Assert.assertTrue("Products are not sorted by product name", productName1.compareTo(productName2) <= 0);

        }
    }

    @Test
    public void verifyTheSortByPriceFilter() {

        // * Mouse Hover on Women Menu
        //* Mouse Hover on Tops
        //* Click on Jackets
        actionsMethodForMouseHover(By.xpath("//span[normalize-space()='Women']"), By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"), By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //* Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("//div[2]//div[3]//select[1]"), "\n" +
                "Price ");
        //* Verify the products price display in Low to High
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='product-item-info']//span[@class='price']"));

        for (int i = 0; i < productPrice.size() - 1; i++) {
            String productPrice1 = productPrice.get(i).getText().substring(1);
            String productPrice2 = productPrice.get(i + 1).getText().substring(1);

            Assert.assertTrue("Products are not sorted by Price", Float.parseFloat(productPrice1) <= Float.parseFloat(productPrice2));

        }

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
